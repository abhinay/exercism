import java.util.{Locale, Calendar, GregorianCalendar}

object Meetup {
  val Mon = "Monday"
  val Tue = "Tuesday"
  val Wed = "Wednesday"
  val Thu = "Thursday"
  val Fri = "Friday"
  val Sat = "Saturday"
  val Sun = "Sunday"
}

case class Meetup(month: Int, year: Int) {
  val monthIndex = month - 1

  def teenth(day: String) = getDate(day, 13 to 20)

  def first(day: String)  = getDate(day, 1 to 8)

  def second(day: String) = getDate(day, 8 to 15)

  def third(day: String)  = getDate(day, 15 to 22)

  def fourth(day: String) = getDate(day, 22 to 29)

  def last(day: String) = {
    val lastDayOfMonth = new GregorianCalendar(year, monthIndex, 1).getActualMaximum(Calendar.DAY_OF_MONTH)
    getDate(day, lastDayOfMonth to lastDayOfMonth - 7 by -1)
  }

  private def getDate(day: String, range: Range) =
    range
      .map(new GregorianCalendar(year, monthIndex, _))
      .find(isSameDay(day, _))
      .orNull

  private def isSameDay(day: String, date: GregorianCalendar) = {
      day == date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault)
  }
}
