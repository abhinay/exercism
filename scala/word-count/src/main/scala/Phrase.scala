class Phrase(text: String) {
  def wordCount() = {
    val wordCounts = Map[String, Int]().withDefaultValue(0)
    val words = text.replaceAll("[^'\\p{L}\\p{Nd}]+", " ").toLowerCase.split(" ")

    words.foldLeft(wordCounts) { (counts, word) =>
      counts ++ Map(word -> (counts(word) + 1))
    }
  }
}
