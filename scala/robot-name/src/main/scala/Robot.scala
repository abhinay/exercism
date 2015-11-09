import scala.util.Random

class Robot {
  private var robotName = generateName()

  def name = robotName

  def reset() = robotName = generateName()

  def generateName() = {
    (Random.alphanumeric take 2).mkString +
    (Random.alphanumeric filter Character.isDigit take 3).mkString
  }
}
