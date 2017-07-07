package org.red.iris.finagle.servers

import com.twitter.util.Future
import com.typesafe.config.Config
import org.red.ceres.finagle.UserService


class UserServer(config: Config)
  extends GenericServer[UserService[Future]](
    config.getString("userService.host"),
    config.getInt("userService.port"))
