name := """play-slick-bootstrap3"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  javaEbean,
  "org.mindrot" % "jbcrypt" % "0.3m",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.typesafe.slick" %% "slick-codegen" % "2.1.0",
  "com.typesafe.play.plugins" %% "play-plugins-mailer" % "2.3.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4" ,
  "postgresql" % "postgresql" % "9.2-1002.jdbc4",
  "mysql" % "mysql-connector-java" % "5.1.27",
  cache,
  ws
)


fork in run := true