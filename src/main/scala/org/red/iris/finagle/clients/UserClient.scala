package org.red.iris.finagle.clients

import com.twitter.finagle.ThriftMux
import com.twitter.finagle.service.RetryBudget
import com.twitter.scrooge.ThriftService
import com.twitter.util.{Duration => TDuration, Future => TFuture}
import com.typesafe.config.Config
import org.red.ceres.finagle._

import scala.concurrent.Future
import scala.language.higherKinds
import scala.reflect.ClassTag

class UserClient(config: Config)
  extends GenericClient[UserService[Future]](
    config.getString("ceres.userService.host"),
    config.getInt("ceres.userService.port")
  ) {
}

class GenericClient[T: ClassTag](host: String, port: Int) {
  val client: T = ThriftMux.client
    .withRetryBudget(RetryBudget())
    .withRequestTimeout(TDuration.fromSeconds(5))
    .newIface[T](s"$host:$port")
}