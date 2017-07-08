package org.red.iris.finagle.clients

import com.twitter.finagle.ThriftMux
import com.twitter.finagle.service.RetryBudget
import com.twitter.util.{Duration => TDuration}
import com.typesafe.scalalogging.LazyLogging

import scala.reflect.ClassTag


abstract class GenericClient[T: ClassTag](host: String, port: Int) extends LazyLogging {
  def build: T = {
    logger.info(s"Setting up finagle client at $host:$port")
    ThriftMux.client
      .withRetryBudget(RetryBudget())
      .withRequestTimeout(TDuration.fromSeconds(10))
      .newIface[T](s"$host:$port")
  }
}