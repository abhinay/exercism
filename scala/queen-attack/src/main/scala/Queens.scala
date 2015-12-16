import java.lang.Math.abs

case class Queens() {
  val Row = Stream.continually("_").take(8).toArray

  def boardString(queen1: Option[Position], queen2: Option[Position]) = {
    val board = Stream.continually(Row.clone).take(8).toArray
    queen1.foreach(q => board(q.x)(q.y) = "W")
    queen2.foreach(q => board(q.x)(q.y) = "B")
    board.map(_.mkString(" ")).mkString("\n") + "\n"
  }

  def canAttack(position1: Position, position2: Position) =
    position1.x == position2.x ||
      position1.y == position2.y ||
      abs(position1.x - position2.x) == abs(position1.y - position2.y)
}

case class Position(x: Int, y: Int)