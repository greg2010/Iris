name := "Iris"

organization := "org.red"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.2"

scalacOptions ++= Seq("-deprecation", "-feature")

publishTo := Some("Artifactory Realm" at "http://maven.red.greg2010.me/artifactory/sbt-local")
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

libraryDependencies ++= Seq(
  // For finding google/protobuf/descriptor.proto
  "com.trueaccord.scalapb" %% "scalapb-runtime" % "0.6.0" % "protobuf",
  "io.grpc" % "grpc-netty" % com.trueaccord.scalapb.compiler.Version.grpcJavaVersion,
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % com.trueaccord.scalapb.compiler.Version.scalapbVersion
)


PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)