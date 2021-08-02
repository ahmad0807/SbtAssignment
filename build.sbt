name := "SbtAssignment"

version := "0.1"

scalaVersion := "2.13.6"

   lazy val common = (project in file("common"))
    .settings(
      name :="common",
    libraryDependencies ++= Seq(
      "io.github.embeddedkafka" %% "embedded-kafka" % "2.8.0",
     "org.json4s" %% "json4s-native" %  "4.0.2",
     "org.scalactic" %% "scalactic" % "3.3.0-SNAP3",
     "org.typelevel" %% "discipline-scalatest" % "2.1.5" % Test,
     "org.mockito" %% "mockito-scala" % "1.16.37" % Test



))
lazy val actor = (project in file("actor"))
  .settings(
    name :="actor",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.15",
      "com.typesafe.akka" %% "akka-stream" % "2.6.15",
      "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.15",
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.15" % Test,
      "org.typelevel" %% "discipline-scalatest" % "2.1.5" % Test

      )).dependsOn(common)

lazy val root = (project in file(".")).aggregate(common,actor)