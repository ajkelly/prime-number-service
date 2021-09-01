import java.util.concurrent.TimeUnit

import org.scalatest.funsuite.AnyFunSuite
import service.PrimeNumberServiceImpl

import scala.concurrent._
import ExecutionContext.Implicits.global

/**
  * Contains the tests for the prime number sieve logic
  */
class PrimeNumberSieveTest() extends AnyFunSuite {

  val server = new PrimeNumberServiceImpl()

  test("Should return an empty list") {
    val result = server.getPrimes(0)
    assert(result === List.empty)

    val result2 = server.getPrimes(1)
    assert(result2 === List.empty)

    val result3 = server.getPrimes(-1)
    assert(result3 === List.empty)
  }

  test("Should return a list just containing the element 2") {
    val result = server.getPrimes(2)
    assert(result === List(2))
  }

  test("Should return the correct prime numbers - with the last number not prime") {
    val result = server.getPrimes(18)
    val expected = List(2,3,5,7,11,13,17)
    assert(result === expected)
  }

  test("Should return the correct prime numbers - with the last number being prime") {
    val result = server.getPrimes(13)
    val expected = List(2,3,5,7,11,13)
    assert(result === expected)
  }

  test("Should never take more than one second to find the prime numbers below 1,000,000") {
    //check the efficiency falls withing reasonable time-frame on my macbook pro!
    def time[R](block: => R): Long = {
      val t0 = System.nanoTime()
      block
      val t1 = System.nanoTime()
      TimeUnit.NANOSECONDS.toMillis(t1 - t0)
    }

    val elapsedTime  = time { server.getPrimes(1000000) }
    assert(elapsedTime < 1000L)
  }

}
