import scala.annotation.tailrec

object Sublist {
  sealed trait SublistResult

  object Equal extends SublistResult
  object Sublist extends SublistResult
  object Superlist extends SublistResult
  object Unequal extends SublistResult
}

class Sublist {
  def sublist[T](list1: List[T], list2: List[T]) =
    if (list2 == list1) Sublist.Equal
    else if (isSublist(list1, list2)) Sublist.Sublist
    else if (isSublist(list2, list1)) Sublist.Superlist
    else Sublist.Unequal

  private def isSublist[T](listA: List[T], listB: List[T]): Boolean = {
    @tailrec
    def containsListA(list: List[T]): Boolean = {
      list match {
        case head :: tail if list startsWith listA => true
        case head :: tail => containsListA(tail)
        case Nil => false
      }
    }

    containsListA(listB)
  }
}
