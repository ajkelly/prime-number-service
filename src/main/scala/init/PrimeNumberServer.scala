package init

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import com.typesafe.config.ConfigFactory
import primenumberserver.grpc.PrimeNumberHandler
import service.PrimeNumberServiceImpl
import scala.util.{Failure, Success}

import scala.concurrent.{ExecutionContext, Future}

object PrimeNumberServer {

  def main(args: Array[String]): Unit = {
    //enable HTTP/2 in ActorSystem's config
    val conf = ConfigFactory
      .parseString("akka.http.server.preview.enable-http2 = on")
      .withFallback(ConfigFactory.defaultApplication())

    //boot akka
    val system = ActorSystem("PrimeNumberService", conf)
    new PrimeNumberServer(system).run()
  }

}

class PrimeNumberServer(system: ActorSystem) {

  def run(): Future[Http.ServerBinding] = {
    implicit val sys: ActorSystem = system
    implicit val ec: ExecutionContext = sys.dispatcher
    //create service handlers
    val service: HttpRequest => Future[HttpResponse] =
      PrimeNumberHandler(new PrimeNumberServiceImpl())
    //bind service handler servers to localhost 8081
    val futureBinding = Http().newServerAt("127.0.0.1", 8081).bind(service)

    futureBinding.onComplete {
      case Success(_) =>
        println("PrimeNumberService Server is online -- ready to start up the ProxyService!")
      case Failure(ex) =>
        println("Failed to bind HTTP endpoint -- terminating system", ex)
        system.terminate()
    }
    //
    futureBinding
  }
}
