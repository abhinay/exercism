import scala.annotation.tailrec

case class PrimeFactors() {
  def primeFactors(number: Long) = findFactors(2, number, List())

  @tailrec
  private def findFactors(divisor: Int, remaining: Long, factors: List[Int]): List[Int] = {
    if (remaining <= 1)
      factors.reverse
    else if (remaining % divisor == 0)
      findFactors(divisor, remaining/divisor, divisor :: factors)
    else
      findFactors(divisor + 1, remaining, factors)
  }
}
