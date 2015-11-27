object TriangleType {
  sealed trait TriangleType
  object Equilateral extends TriangleType
  object Isosceles extends TriangleType
  object Scalene extends TriangleType
  object Illogical extends TriangleType

}
case class Triangle(side1: Int, side2: Int, side3: Int) {
  val sides = List(side1, side2, side3)
  val triangleType = getTriangleType

  def getTriangleType: TriangleType.TriangleType = {
    if (invalidTriangle) return TriangleType.Illogical

    sides.distinct.size match {
      case 1 => TriangleType.Equilateral
      case 2 => TriangleType.Isosceles
      case 3 => TriangleType.Scalene
    }
  }

  def invalidTriangle = {
    sides.permutations.exists {
      case List(a, b, c) => a + b <= c
    }
  }
}
