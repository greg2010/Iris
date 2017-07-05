package org.red.iris.exceptions

case class CCPException(reason: String, cause: Option[Exception] = None) extends RuntimeException