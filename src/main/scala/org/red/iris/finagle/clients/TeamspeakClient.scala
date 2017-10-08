package org.red.iris.finagle.clients

import com.twitter.bijection.Conversion.asMethod
import com.twitter.bijection.twitter_util.UtilBijections.twitter2ScalaFuture
import com.twitter.util.{Future => TFuture}
import com.typesafe.config.Config
import org.red.hermes.finagle.TeamspeakService
import org.red.iris._

import scala.concurrent.{ExecutionContext, Future}
import scala.language.higherKinds


class TeamspeakClient(config: Config)(implicit ec: ExecutionContext)
  extends GenericClient[TeamspeakService[TFuture]](
    config.getString("hermes.teamspeakService.host"),
    config.getInt("hermes.teamspeakService.port")
  ) {
  private val client = super.build

  def registerUserOnTeamspeak(user: User, characterId: Long, userIp: String): Future[String] = {
    client.registerUserOnTeamspeak(user, characterId, userIp).as[Future[String]]
  }

  def getTeamspeakUniqueId(userId: Int): Future[String] = {
    client.getTeamspeakUniqueId(userId).as[Future[String]]
  }

  def getUserIdByUniqueId(uniqueId: String): Future[Int] = {
    client.getUserIdByUniqueId(uniqueId).as[Future[Int]]
  }

  def syncTeamspeakUser(user: User): Future[Unit] = {
    client.syncTeamspeakUser(user).as[Future[Unit]]
  }
}