import akka.actor.testkit.typed.scaladsl.ActorTestKit
import akka.actor.typed.ActorSystem
import org.scalatest.BeforeAndAfterAll
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import primenumberserver.grpc.{PrimeNumberRequest, PrimeNumberResponse}
import service.PrimeNumberServiceImpl

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class PrimeNumberServiceImplTest extends AnyWordSpec with BeforeAndAfterAll with Matchers with ScalaFutures {

  val testKit = ActorTestKit()

  implicit val patience: PatienceConfig = PatienceConfig(scaled(5.seconds), scaled(100.millis))

  implicit val system: ActorSystem[_] = testKit.system

  val service = new PrimeNumberServiceImpl()

  override def afterAll(): Unit = {
    testKit.shutdownTestKit()
  }

  "PrimeNumberServiceImpl" should {
    "reply correctly to simple request" in {
      val reply = service.listPrimeNumbers(PrimeNumberRequest(10))
      reply.futureValue should === (PrimeNumberResponse(Seq(2,3,5,7)))
    }
  }

}
