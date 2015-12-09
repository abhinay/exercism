case class CryptoSquare() {
  def normalizePlaintext(text: String) =
    text.filter(_.isLetterOrDigit).toLowerCase

  def squareSize(text: String) =
    Math.sqrt(normalizePlaintext(text).length).ceil.toInt

  def plaintextSegments(text: String) =
    normalizePlaintext(text) match {
      case ""   => List.empty
      case list => list.grouped(squareSize(text)).toList
    }

  def ciphertext(text: String) =
    cipherSegments(text).mkString

  def normalizedCiphertext(text: String) =
    cipherSegments(text).mkString(" ")

  private def cipherSegments(text: String) = {
    val padSize = squareSize(text)
    plaintextSegments(text).map(_.padTo(padSize, "")).transpose.map(_.mkString(""))
  }
}