case class Dna() {
  private val rnaComplements =
    Map('G' -> 'C', 'C' -> 'G', 'T' -> 'A', 'A' -> 'U')

  def toRna(dna: String) =
    dna.map(rnaComplements)
}
