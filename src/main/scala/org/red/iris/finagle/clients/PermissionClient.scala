package org.red.iris.finagle.clients

import com.twitter.bijection.Conversion.asMethod
import com.twitter.bijection.twitter_util.UtilBijections.twitter2ScalaFuture
import com.twitter.util.{Future => TFuture}
import com.typesafe.config.Config
import org.red.ceres.finagle._
import org.red.iris._

import scala.concurrent.{ExecutionContext, Future}
import scala.language.higherKinds


class PermissionClient(config: Config)(implicit ec: ExecutionContext)
  extends GenericClient[PermissionService[TFuture]](
    config.getString("ceres.permissionService.host"),
    config.getInt("ceres.permissionService.port")
  ) {
  private val client = super.build

  def getPermissionBits(mask: Long): Future[Seq[PermissionBit]] = {
    client.getPermissionBits(mask).as[Future[Seq[PermissionBit]]]
  }

  def getPermissionMask(permissionList: Seq[PermissionBit]): Future[Long] = {
    client.getPermissionMask(permissionList).as[Future[Long]]
  }

  def getPermissionList: Future[Seq[PermissionBit]] = {
    client.getPermissionList.as[Future[Seq[PermissionBit]]]
  }
}