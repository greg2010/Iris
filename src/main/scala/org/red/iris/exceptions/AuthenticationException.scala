package org.red.iris.exceptions

import scala.util.control.NoStackTrace


case class AuthenticationException(reason: String, sub: String) extends RuntimeException with NoStackTrace
