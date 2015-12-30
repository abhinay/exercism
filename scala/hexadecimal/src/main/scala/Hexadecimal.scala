object Hexadecimal {
  private val Valid = ('0' to '9') ++ ('a' to 'f')

  def hexToInt(implicit hex: String): Int = {
    validHex match {
      case false => 0
      case true  => hex.reverse.zipWithIndex.foldLeft(0)((total, hexPos) => total + IntValue(hexPos))
    }
  }

  private def validHex(implicit hex: String) =
    hex.toLowerCase.forall(Valid.contains)

  private def IntValue(hexPos: (Char, Int)) =
    (Valid.indexOf(hexPos._1.toLower) * Math.pow(16, hexPos._2)).toInt
}