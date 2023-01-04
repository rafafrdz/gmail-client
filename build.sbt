ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

lazy val root = (project in file("."))
  .settings(
    name := "gmail-client"
  )

libraryDependencies += "com.github.eikek" %% "emil-common" % "0.10.0-M2"  // the core library

libraryDependencies += "com.github.eikek" %% "emil-javamail" % "0.10.0-M2" // implementation module