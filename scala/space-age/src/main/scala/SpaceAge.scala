case class SpaceAge(seconds: Double) {
  val earthYears = seconds / 31557600.0

  lazy val onEarth    = fromEarthYears(1)
  lazy val onMercury  = fromEarthYears(0.2408467)
  lazy val onVenus    = fromEarthYears(0.61519726)
  lazy val onMars     = fromEarthYears(1.8808158)
  lazy val onJupiter  = fromEarthYears(11.862615)
  lazy val onSaturn   = fromEarthYears(29.447498)
  lazy val onUranus   = fromEarthYears(84.016846)
  lazy val onNeptune  = fromEarthYears(164.79132)

  private def fromEarthYears(ratio: Double) =
    BigDecimal(earthYears/ratio).setScale(2, BigDecimal.RoundingMode.HALF_UP)
}
