import scala.annotation.tailrec

case class PrimeFactors() {
  def primeFactors(number: Long) = findPrimeFactors(2, number, List())

  @tailrec
  private def findPrimeFactors(prime: Int, remaining: Long, factors: List[Int]): List[Int] = {
    if (remaining <= 1)
      factors.reverse
    else if (remaining % prime == 0)
      findPrimeFactors(prime, remaining/prime, prime :: factors)
    else
      findPrimeFactors(nextPrime(prime), remaining, factors)
  }

  private def nextPrime(from: Int) = {
    Stream.from(from + 1).find(isPrime).get
  }

  private def isPrime(i: Int) = !Range(2, i).exists(i % _ == 0)
}
