
import cats.Monad
import cats.effect.{Async, Resource}
import org.http4s.HttpApp
import org.http4s.blaze.server.BlazeServerBuilder

import scala.concurrent.ExecutionContext

trait ServerApplication[F[_], Server]:
  def server(): Resource[F, Server]

object ServerApplication:
    def http4s[F[_]: Async](port: Int, host: String, app: HttpApp[F], ec: ExecutionContext): ServerApplication[F, org.http4s.server.Server] =
        () => BlazeServerBuilder[F](ec).bindHttp(port, host).withHttpApp(app).resource
