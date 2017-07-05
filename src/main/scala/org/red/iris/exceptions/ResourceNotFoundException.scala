package org.red.iris.exceptions

case class ResourceNotFoundException(reason: String) extends RuntimeException
