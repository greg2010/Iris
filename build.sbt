name := "Iris"

organization := "org.red"

version := "0.0.7-SNAPSHOT"

scalaVersion := "2.12.2"

scalacOptions ++= Seq("-deprecation", "-feature")

publishTo := Some("Artifactory Realm" at "http://maven.red.greg2010.me/artifactory/sbt-local")
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

val circeVersion = "0.8.0"

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "org.apache.thrift" % "libthrift" % "0.9.3",
  "com.twitter" %% "scrooge-core" % "4.18.0",
  "com.twitter" %% "scrooge-generator" % "4.18.0",
  "com.twitter" %% "finagle-core" % "6.45.0",
  "com.twitter" %% "finagle-thriftmux" % "6.45.0",
  "com.twitter" %% "bijection-util" % "0.9.5",
  "com.typesafe" % "config" % "1.3.1",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-yaml" % "0.5.0").map(_.exclude("org.slf4j", "slf4j-simple")
)