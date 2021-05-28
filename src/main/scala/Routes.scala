
import cats.Applicative
import cats.syntax.semigroupk._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

import cats.Monad

object Routes:
  def all[F[_]: Monad]: HttpRoutes[F] = 
    given Http4sDsl[F] = Http4sDsl[F]
    helloWorldRoute[F] <+> other[F]

  def helloWorldRoute[F[_]: Monad](using dsl: Http4sDsl[F]): HttpRoutes[F] = 
    import dsl._  
    
    HttpRoutes.of[F] { 
      case GET -> Root / "hello" / name =>
        Ok(s"Hello, $name.")
    }
  

  def other[F[_]: Monad](using dsl: Http4sDsl[F]): HttpRoutes[F] =
    import dsl._

    HttpRoutes.of[F] {
      case GET -> Root / "other" =>
        Ok(s"It's an other enpoint")
    }
