case class Binary(binary: String) {
  private val invalidBinary = binary.exists(c => c != '0' && c != '1')

  def toDecimal: Double = {
    if (invalidBinary) return 0

    binary
      .reverse
      .zipWithIndex
      .map {case (bit,index) => bitToDecimal(bit, index)}
      .sum
  }

  def bitToDecimal(bit: Char, index: Int) =
    bit match {
      case '0' => 0.0
      case '1' => Math.pow(2, index)
    }
}
