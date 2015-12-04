case class Atbash() {
  val Plain = 'a' to 'z'
  val Cipher = Plain.zip(Plain.reverse).toMap

  def encode(value: String) = {
    value.toLowerCase
      .filter(_.isLetterOrDigit)
      .map(c => Cipher.getOrElse(c,c))
      .grouped(5)
      .mkString(" ")
  }
}