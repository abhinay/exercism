import java.util.{Calendar, GregorianCalendar}

case class Gigasecond(date: GregorianCalendar) {
  date.add(Calendar.SECOND, 1000000000)
}
