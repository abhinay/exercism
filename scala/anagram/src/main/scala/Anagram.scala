class Anagram(val original: String) {

  def matches(values: Seq[String]) =
    values
      .filter(isAnagram)
      .filterNot(isIdentical)

  def isAnagram(value: String) =
    value.toLowerCase.sorted.equals(original.toLowerCase.sorted)

  def isIdentical(value: String) =
    value.toLowerCase.equals(original.toLowerCase)
}
