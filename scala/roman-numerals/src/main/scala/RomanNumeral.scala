import scala.annotation.tailrec
import scala.collection.SortedMap

case class RomanNumeral(decimal: Int) {
  val numeralMapping = SortedMap(1 -> "I", 4 -> "IV", 5 -> "V", 9 -> "IX", 10 -> "X", 40 -> "XL", 50 -> "L", 90 -> "XC", 100 -> "C", 400 -> "CD", 500 -> "D", 900 -> "CM", 1000 -> "M")

  val value = {
    @tailrec
    def collectNumerals(currentNumber: Int, remainingNum: Int, numerals: List[String]): (Int, List[String]) = {
      if (remainingNum > 0 && remainingNum >= currentNumber)
        collectNumerals(currentNumber, remainingNum - currentNumber, numeralMapping(currentNumber) :: numerals)
      else
        (remainingNum, numerals)
    }

    val collectedNumerals = numeralMapping.keys.foldRight((decimal, List[String]())) {
      (currentNumber, accum) => collectNumerals(currentNumber, accum._1, accum._2)
    }._2.reverse

    collectedNumerals.mkString("")
  }
}
