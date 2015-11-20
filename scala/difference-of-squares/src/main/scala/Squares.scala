case class Squares() {
  def difference(upperBound: Int) =
    squareOfSums(upperBound) - sumOfSquares(upperBound)

  def sumOfSquares(upperBound: Int) =
    (1 to upperBound).map(square).sum

  def squareOfSums(upperBound: Int) =
    square((1 to upperBound).sum)

  private def square(number: Int) = number * number
}
