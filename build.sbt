name := "HOCONconfReader"

version := "0.1"

scalaVersion := "2.13.6"

// Dependencies
libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.4.1",  // Existing dependency
  "org.scalatest" %% "scalatest" % "3.2.15" % Test  // Add Scalatest for testing
)
