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

  def createLegacyUser(email: String, credentials: LegacyCredentials, password: String): Future[UserMini] = {
    client.createLegacyUser(email, credentials, password).as[Future[UserMini]]
  }

  def createSSOUser(email: String, credentials: SSOCredentials, password: Option[String]): Future[UserMini] = {
    client.createSSOUser(email, credentials, password).as[Future[UserMini]]
  }

  def verifyUserLegacy(nameOrEmail: String, password: String): Future[UserMini] = {
    client.verifyUserLegacy(nameOrEmail, password).as[Future[UserMini]]
  }

  def verifyUserSSO(ssoToken: String): Future[UserMini] = {
    client.verifyUserSSO(ssoToken).as[Future[UserMini]]
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

  def updateUserData(eveUserData: EveUserData): Future[Unit] = {
    client.updateUserData(eveUserData).as[Future[Unit]]
  }

  def updatePassword(userId: Int, newPassword: String): Future[Unit] = {
    client.updatePassword(userId, newPassword).as[Future[Unit]]
  }

  def requestPasswordReset(email: String): Future[Unit] = {
    client.requestPasswordReset(email).as[Future[Unit]]
  }

  def completePasswordReset(email: String, token: String, newPassword: String): Future[Unit] = {
    client.completePasswordReset(email, token, newPassword).as[Future[Unit]]
  }
}