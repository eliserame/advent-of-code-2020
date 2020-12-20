scalaVersion := "2.13.4"

name := "advent-of-code-2020"

val scalatestVersion = "3.2.2"
libraryDependencies ++= List(
  "org.scalatest" %% "scalatest-flatspec" % scalatestVersion % "test",
  "org.scalatest" %% "scalatest-shouldmatchers" % scalatestVersion % "test"
)

libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

scalacOptions += "-deprecation"