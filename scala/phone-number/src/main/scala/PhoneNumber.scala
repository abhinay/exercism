class PhoneNumber(numberStr: String) {

  val cleaned = {
    val cleanedStr = numberStr filter Character.isDigit
    if (cleanedStr.length == 11) cleanedStr.replaceAll("^1", "") else cleanedStr
  }

  val number = {
    val valid = cleaned.length == 10
    if (valid) cleaned else "0000000000"
  }

  val areaCode =
    number take 3

  val part1 =
    (number takeRight 7) take 3

  val part2 =
    number takeRight 4

  override def toString = {
    s"($areaCode) $part1-$part2"
  }
}
