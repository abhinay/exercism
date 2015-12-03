import Allergen._

object Allergen {
  sealed trait Allergen { val score: Int }
  object Eggs extends Allergen { val score = 1  }
  object Peanuts extends Allergen { val score = 2 }
  object Shellfish extends Allergen { val score = 4 }
  object Strawberries extends Allergen { val score = 8 }
  object Tomatoes extends Allergen { val score = 16 }
  object Chocolate extends Allergen { val score = 32 }
  object Pollen extends Allergen { val score = 64 }
  object Cats extends Allergen { val score = 128 }
}

case class Allergies() {
  private val Allergens = List(Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats)

  def allergies(score: Int) =
    Allergens.filter(isAllergicTo(_, score))

  def isAllergicTo(allergen: Allergen.Allergen, score: Int) =
    (allergen.score & score) == allergen.score
}
