ThisBuild / scalaVersion := "2.13.4"

lazy val root = (project in file("."))
  .settings(
    name := "advent-of-code-2020",
    libraryDependencies ++= scalatest
  )

val scalatestVersion = "3.2.2"
val scalatest = List(
  "org.scalatest" %% "scalatest-flatspec" % scalatestVersion % "test",
  "org.scalatest" %% "scalatest-shouldmatchers" % scalatestVersion % "test"
)
