
import cats.effect.IOApp
import cats.effect.IO
import org.http4s.server.Router
import org.http4s.syntax.all._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends IOApp.Simple:
  
  def run: IO[Unit] =
    val httpApp = Router("/" -> Routes.all[IO]).orNotFound
    val serverApp = ServerApplication.http4s[IO](8080, "localhost", httpApp, global)
    serverApp.server().use(_ => IO.never)
