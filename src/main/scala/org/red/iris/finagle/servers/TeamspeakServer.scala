package org.red.iris.finagle.servers

import com.twitter.util.Future
import com.typesafe.config.Config
import org.red.hermes.finagle.TeamspeakService


class TeamspeakServer(config: Config)
  extends GenericServer[TeamspeakService[Future]](
    config.getString("hermes.teamspeakService.host"),
      config.getInt("hermes.teamspeakService.port"))
