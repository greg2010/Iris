package org.red.iris.util

import org.red.iris.{User, UserMini}

import scala.language.implicitConversions


package object converters {
  implicit class RichUserMini(val userMini: UserMini.type) extends AnyVal {
    def fromUser(user: User) = UserMini(
      id = user.userId,
      permissions = user.permissions
    )
  }
}
