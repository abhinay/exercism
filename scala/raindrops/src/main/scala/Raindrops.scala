import scala.collection.SortedMap

case class Raindrops() {
  val rainDropValues = SortedMap(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

  def convert(implicit num: Int) = {
    validDrops match {
      case List()   => num.toString
      case nonEmpty => nonEmpty.mkString("")
    }
  }

  private def validDrops(implicit num: Int) =
    rainDropValues.keys
      .filter(num % _ == 0)
      .map(rainDropValues)
      .toList
}