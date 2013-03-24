name := "Pysche"

scalaVersion := "2.10.0"

scalacOptions ++= Seq("-feature")

version := "0.0.1-ALPHA"

libraryDependencies ++= Seq("eu.henkelmann" % "actuarius_2.10.0" % "0.2.5",
                            "org.specs2" %% "specs2" % "1.14" % "test",
                            "org.scalacheck" %% "scalacheck" % "1.10.0" % "test")
            
resolvers ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)