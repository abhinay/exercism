import scala.collection.SortedMap

class School {
  private var schools = Map[Int, Seq[String]]().withDefaultValue(Seq())

  def db = schools

  def grade = schools

  def add(name: String, id: Int) = {
    val updatedList = db(id) :+ name
    schools = schools ++ Map(id -> updatedList)
  }

  def sorted = {
    SortedMap(schools.toArray:_*) mapValues (_.sorted)
  }
}
