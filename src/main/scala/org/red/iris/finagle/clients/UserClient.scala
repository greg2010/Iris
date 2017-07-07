package org.red.iris.finagle.clients

import com.typesafe.config.Config
import org.red.ceres.finagle._

import com.twitter.util.Future
import scala.language.higherKinds

class UserClient(config: Config)
  extends GenericClient[UserService[Future]](
    config.getString("userService.host"),
    config.getInt("userService.port")
  )