package org.red.iris.exceptions

import scala.util.control.NoStackTrace


trait AccessRestrictedException extends RuntimeException with NoStackTrace {
  val reason: String
}
