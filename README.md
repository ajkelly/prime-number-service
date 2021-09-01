# prime-number-service

Exposes a service listening for a Grpc request containing an integer. Using the Sieve of Eratosthenes, efficiently calculates all the prime numbers up to (and including if prime) the request integer.

To run:
- Clone the repository (git clone https://github.com/ajkelly/prime-number-service.git)
- Compile the project from the sbt shell (compile) - this will generate the Grpc interfaces and stubs
- Once the target folder containing the Grpc is present, simply run the project from the main method inside PrimeNumberServer.scala

To run tests:
- From the sbt shell (test)

Notable implementation choices:
- Used the Sieve of Eratosthenes for it's efficiency as well as ease of implementation - (took the algorithm steps from https://www.wikiwand.com/en/Sieve_of_Eratosthenes)
- in the getPrimes method inside PrimeNumberServiceImpl.scala I used "0" and "1" to denote the difference between primes and non primes as this is more efficient than Boolean values

Additional:
- See https://github.com/ajkelly/proxy-service.git