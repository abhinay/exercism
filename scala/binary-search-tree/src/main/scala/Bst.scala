case class Bst(value: Int) {
  var left:  Option[Bst] = None
  var right: Option[Bst] = None

  def insert(payload: Int): Bst =
    Bst.fromList(collectValues())._insert(payload)

  private def _insert(payload: Int): Bst = {
    if (payload <= value) {
      if (left.isDefined)
        left.get._insert(payload)
      else
        left = Option(Bst(payload))
    } else {
      if (right.isDefined)
        right.get._insert(payload)
      else
        right = Option(Bst(payload))
    }
    this
  }

  private def collectValues(values: List[Int] = List()): List[Int] = {
    val leftValues = left.fold(values)(_.collectValues(values))
    val rightValues  = right.fold(values)(_.collectValues(values))
    value :: (leftValues ++ rightValues)
  }
}

object Bst {
  def toList(bst: Bst) = bst.collectValues().sorted

  def fromList(list: List[Int]) =
    list.tail.foldLeft(Bst(list.head))((bst,element) => bst.insert(element))
}