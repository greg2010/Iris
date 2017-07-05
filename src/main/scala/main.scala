import io.grpc.InternalMetadata.TrustedAsciiMarshaller
import io.grpc.Metadata.Key
import io.grpc._
import org.red.iris.exceptions.AuthenticationException
import org.red.protos.ceres.{UserGrpc, VerifyUserRequest}

import scala.collection.JavaConverters._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}



object main extends App {
  val channel = ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext(true).build
  val server = ServerBuilder.forPort(9999).addService(UserGrpc.bindService(new srv, global)).build().start()
  val client = UserGrpc.stub(channel)
  val res = client.verifyUser(VerifyUserRequest("123")).transformWith {
    case Success(res) =>
      Future(res)
    case Failure(t: StatusRuntimeException) =>
      println(t.getTrailers)
      val ex = Class.forName(t.getTrailers.get(Key.of("exceptionName", Metadata.ASCII_STRING_MARSHALLER))).asInstanceOf[Throwable]
      Future.failed(ex)
  }
  Await.result(res, Duration.Inf)
}

class srv extends UserGrpc.User {
  override def verifyUser(request: VerifyUserRequest): Future[VerifyUserRequest] = {
    println("хуй")
    val mt = new Metadata()
    mt.put[String](Key.of("exceptionName", Metadata.ASCII_STRING_MARSHALLER) , AuthenticationException.getClass.getName)
    Future.failed(throw new StatusRuntimeException(Status.NOT_FOUND, mt))
  }
}