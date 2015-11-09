class DNA(nucleotides: String) {

  val nucleotideCounts = {
    val intialCounts = Map('A' -> 0, 'T' -> 0, 'C' -> 0, 'G' -> 0)

    nucleotides.foldLeft(intialCounts) {
      (counts, nucleotide) =>
        val newCount = counts(nucleotide) + 1
        counts ++ Map(nucleotide -> newCount)
    }
  }
}
