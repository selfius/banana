name := "banana"

version := "0.1"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq (
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test",
  "ru.sggr.banana" % "banana-api" % "1.0-SNAPSHOT"
)

resolvers += Resolver.mavenLocal


