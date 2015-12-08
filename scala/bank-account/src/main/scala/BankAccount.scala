case class BankAccount() {
  private var balance = Option(0)

  def getBalance = balance

  def incrementBalance(amount: Int): Option[Int] = {
    this.synchronized(balance = balance.map(_ + amount))
    balance
  }

  def closeAccount() = balance = None
}
