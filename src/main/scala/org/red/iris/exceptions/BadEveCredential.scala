package org.red.iris.exceptions

import scala.util.control.NoStackTrace

case class BadEveCredential(reason: String, statusCode: Int)
  extends RuntimeException with NoStackTrace
