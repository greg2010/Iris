package org.red.iris.finagle.servers

import com.twitter.util.Future
import com.typesafe.config.Config
import org.red.ceres.finagle.PermissionService


class PermissionServer(config: Config)
  extends GenericServer[PermissionService[Future]](
    config.getString("ceres.permissionService.host"),
      config.getInt("ceres.permissionService.port"))
