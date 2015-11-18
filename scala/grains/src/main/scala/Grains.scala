object Grains {
  def square(i: Int) = Math.pow(2, i - 1)

  lazy val total = BigDecimal(2).pow(64) - 1
}
