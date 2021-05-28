lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-simple",
    version := "0.1.0",

    scalaVersion := "3.0.0",

    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.typelevel" %% "cats-effect" % "3.1.1",
      "org.http4s" %% "http4s-dsl" % "0.23.0-M1",
      "org.http4s" %% "http4s-blaze-server" % "0.23.0-M1",
    ),

    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:postfixOps"
    )
  )



