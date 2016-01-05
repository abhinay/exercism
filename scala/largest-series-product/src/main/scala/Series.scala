object Series {
  def digits(series: String) = series.map(_.asDigit)

  def slices(count: Int, series: String) =
    digits(series).toIterator.sliding(count).withPartial(false).toList

  def largestProduct(count: Int, series: String) = {
    slices(count, series) match {
      case List() => 1
      case digits => digits.map(l => l.product).sorted.last
    }
  }
}