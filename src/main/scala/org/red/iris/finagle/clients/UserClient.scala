package org.red.iris.finagle.clients

import com.typesafe.config.Config
import org.red.ceres.finagle._
import com.twitter.util.{Future => TFuture}
import org.red.iris._
import com.twitter.bijection.twitter_util.UtilBijections.twitter2ScalaFuture
import com.twitter.bijection.Conversion.asMethod

import scala.concurrent.{ExecutionContext, Future}
import scala.language.higherKinds


class UserClient(config: Config)(implicit ec: ExecutionContext)
  extends GenericClient[UserService[TFuture]](
    config.getString("ceres.userService.host"),
    config.getInt("ceres.userService.port")
  ) {
  private val client = super.build

  def getEveUser(credentials: LegacyCredentials): Future[EveUserDataList] = {
    client.getEveUser(credentials).as[Future[EveUserDataList]]
  }

  def loginSSO(authCode: String): Future[SuccessfulLoginResponse] = {
    client.loginSSO(authCode).as[Future[SuccessfulLoginResponse]]
  }

  def getUser(userId: Int): Future[User] = {
    client.getUser(userId).as[Future[User]]
  }

  def getUserMini(userId: Int): Future[UserMini] = {
    client.getUserMini(userId).as[Future[UserMini]]
  }

  def triggerUserUpdate(userId: Int): Future[Unit] = {
    client.triggerUserUpdate(userId).as[Future[Unit]]
  }
}