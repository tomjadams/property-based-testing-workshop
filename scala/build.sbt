name := "property-based-testing-workshop-scala"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"
)

resolvers += Resolver.sonatypeRepo("snapshots")

scalacOptions ++= Seq("-Xlint", "-unchecked", "-deprecation")

scalacOptions in Test ++= Seq("-Yrangepos")
