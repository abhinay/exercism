import scala.annotation.tailrec

class Accumulate {
  def accumulate[T0, T1](function: T0 => T1, list: List[T0]): List[T1] = {

    @tailrec
    def tailAccumulate(remainingList: List[T0], doneList: List[T1] = List()): List[T1] = {
      remainingList match {
        case head :: tail => tailAccumulate(tail, function(head) :: doneList)
        case _ => doneList.reverse
      }
    }

    tailAccumulate(list)
  }
}
