class Bob {
  def hey(message: String) = message.trim match {
    case "" => "Fine. Be that way!"
    case warning if warning.matches(".*[a-zA-Z].*") && message == warning.toUpperCase => "Whoa, chill out!"
    case question if question.endsWith("?") => "Sure."
    case _ => "Whatever."
  }
}
