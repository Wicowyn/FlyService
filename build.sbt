name := "FlyService"

version := "1.0"

lazy val `FlyService` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( javaJdbc , javaEbean , cache , javaWs )

libraryDependencies ++= Seq(
  javaJpa,
//  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
//  "org.hibernate.javax.persistence" % "hibernate-jpa-2.1-api" % "1.0.0.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.2.16.Final", // replace by your jpa implementation
  "org.mindrot" % "jbcrypt" % "0.3m"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  