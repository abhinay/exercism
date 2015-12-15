import Plant._
import Garden._

case class Garden(children: List[String], garden: String) {
  private val plantRows: PlantRows = garden.split("\n").map(_.map(Plants))

  def getPlants(child: String) = {
    val childIndex = children.sorted.indexOf(child) * 2
    if (childIndex < 0 || childIndex >= plantRows.head.length)
      List.empty
    else
      plantRows.flatMap(row => List(row(childIndex), row(childIndex+1)))
  }
}

object Garden {
  private val Plants = Map('G' -> Grass, 'C' -> Clover, 'R' -> Radishes, 'V' -> Violets)
  private val DefaultChildren = List("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")
  private type PlantRows = Seq[Seq[Plant]]
  def defaultGarden(garden: String) = Garden(DefaultChildren, garden)
}

object Plant {
  sealed trait Plant
  object Grass extends Plant
  object Clover extends Plant
  object Radishes extends Plant
  object Violets extends Plant
}