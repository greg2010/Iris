package org.red.iris.finagle.servers

import com.twitter.util.Future
import com.typesafe.config.Config
import org.red.ceres.finagle.UserService


class UserServer(config: Config)
  extends GenericServer[UserService[Future]](
    config.getString("ceres.userService.host"),
      config.getInt("ceres.userService.port"))
