package org.red.iris.finagle.servers

import com.twitter.finagle.{ListeningServer, ThriftMux}
import com.twitter.scrooge.ThriftService
import com.typesafe.scalalogging.LazyLogging



abstract class GenericServer[T <: ThriftService](host: String, port: Int) extends LazyLogging {
  def build(t: T): ListeningServer = {
    logger.info(s"Setting up finagle server for ${t.getClass.toString} at $host:$port")
    ThriftMux.server.serveIface(s"$host:$port", t)
  }
}