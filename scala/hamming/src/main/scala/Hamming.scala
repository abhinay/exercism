object Hamming {
  def compute(val1: String, val2: String) = {
    require(val1.length == val2.length, "String lengths are not the same")

    val1 zip val2 count { tuple => tuple._1 != tuple._2 }
  }
}
