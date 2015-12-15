import Bearing._
import Robot._

case class Robot(bearing: Bearing, coordinates: (Int,Int)) {
  def simulate(instruction: String) =
    instruction.foldLeft(this)((robot, move) => move match {
      case 'L' => robot.turnLeft
      case 'R' => robot.turnRight
      case 'A' => robot.advance
    })

  def turnLeft = Robot(LeftTransitions(bearing), coordinates)

  def turnRight = Robot(RightTransitions(bearing), coordinates)

  def advance = Robot(bearing, addCoords(coordinates, CoordTransitions(bearing)))

  private def addCoords(coords1: (Int, Int), coords2: (Int, Int)) =
    (coords1._1 + coords2._1, coords1._2 + coords2._2)
}

object Robot {
  val LeftTransitions = Map(North->West, South->East, East->North, West->South)
  val RightTransitions = Map(North->East, South->West, East->South, West->North)
  val CoordTransitions = Map(North->(0,1), South->(0,-1), East->(1,0), West->(-1,0))
}

object Bearing {
  sealed trait Bearing
  object North extends Bearing
  object South extends Bearing
  object East extends Bearing
  object West extends Bearing
}
