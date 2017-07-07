name := "Iris"

organization := "org.red"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.2"

scalacOptions ++= Seq("-deprecation", "-feature")

publishTo := Some("Artifactory Realm" at "http://maven.red.greg2010.me/artifactory/sbt-local")
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

libraryDependencies ++= Seq(
  "org.apache.thrift" % "libthrift" % "0.9.3",
  "com.twitter" %% "scrooge-core" % "4.18.0",
  "com.twitter" %% "scrooge-generator" % "4.18.0",
  "com.twitter" %% "finagle-core" % "6.45.0",
  "com.twitter" %% "finagle-thriftmux" % "6.45.0",
  "com.twitter" %% "bijection-util" % "0.9.5",
  "com.typesafe" % "config" % "1.3.1"
)