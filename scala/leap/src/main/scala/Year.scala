case class Year(year: Int) {
  def isLeap =
    isDivisibleBy(400) ||
      (isDivisibleBy(4) && !isDivisibleBy(100))

  private def isDivisibleBy(number: Int) = year % number == 0
}
