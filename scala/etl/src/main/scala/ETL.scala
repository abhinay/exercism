object ETL {
  def transform(old: Map[Int, Seq[String]]) = {
    for((score, words) <- old;
        word <- words)
      yield (word.toLowerCase, score)
  }
}
