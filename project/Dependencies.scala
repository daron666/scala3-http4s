import sbt._

object Dependencies {

    object Http4s {
        private val version = "0.23.0-M1"

        val dsl = "org.http4s" %% "http4s-dsl" % version
        val blaze = "org.http4s" %% "http4s-blaze-server" % version
        val circe = "org.http4s" %% "http4s-circe" % version

        val all = Seq(dsl, blaze, circe)
    }

    object Circe {
        private val version = "0.14.1"

        val core = "io.circe" %% "circe-core" % version
        val generic = "io.circe" %% "circe-generic" % version

        val all = Seq(core, generic)
    }
}
  


   