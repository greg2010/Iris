name := "Iris"

organization := "org.red"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.2"

scalacOptions ++= Seq("-deprecation", "-feature")

publishTo := Some("Artifactory Realm" at "http://maven.red.greg2010.me/artifactory/sbt-local")
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

libraryDependencies ++= Seq(
  "org.apache.thrift" % "libthrift" % "0.10.0",
  "com.twitter" %% "scrooge-core" % "4.18.0" exclude("com.twitter", "libthrift"),
  "com.twitter" %% "finagle-thrift" % "6.45.0" exclude("com.twitter", "libthrift")
)