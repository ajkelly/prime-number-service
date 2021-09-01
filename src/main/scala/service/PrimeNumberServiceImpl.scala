package service

import primenumberserver.grpc.{PrimeNumber, PrimeNumberRequest, PrimeNumberResponse}

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.{ExecutionContext, Future}

class PrimeNumberServiceImpl(implicit val ec: ExecutionContext) extends PrimeNumber {

  override def listPrimeNumbers(in: PrimeNumberRequest): Future[PrimeNumberResponse] = {
    val primes = getPrimes(in.max)
    Future(PrimeNumberResponse(primes))
  }

  /*
   * Sieve of Eratosthenes:
   * 1. Create an Integer list of n.size and initialise each element to 1 aside from index 0 amd 1 which should be 0
   * 2. Initially, let p equal 2, the smallest prime number.
   * 3. Enumerate the multiples of p by counting in increments of p from p[squared] to n, and mark them in the list
   *    (these will be p[squared], p[squared]+p, p[squared]+2p, ...; the p itself should not be marked).
   * 4. Find the smallest number in the list greater than p that is not marked. If there was no such number, stop.
   *    Otherwise, while p[squared] > n, let p now equal this new number (which is the next prime), and repeat from
   *    step 3.
   * 5. When the algorithm terminates, the numbers remaining not marked in the list are all the primes below n.
   */
  /**
    * Using an implementation of the Sieve of Eratosthenes this returns a
    * list containing all the prime numbers up to (and including if it is
    * a prime number) the input Int
    *
    * @param n the limit at which we check for all prime numbers
    * @return a List containing all the prime numbers between 0 -> n
    */
  def getPrimes(n: Int): List[Int] = {
    if (n <= 1) {
      return List.empty
    }
    val x = ArrayBuffer.fill(n + 1)(1)
    x(0) = 0
    x(1) = 0
    val lastToCheck = scala.math.sqrt(n).toInt

    for (i <- 2 to lastToCheck; if x(i) == 1) {
      for (j <- i * i to n by i) {
        x(j) = 0
      }
    }
    //collect the indices of each element which is a one
    x.zipWithIndex.collect {
      case (prime, index) if prime == 1 => index
    }.toList
  }

}