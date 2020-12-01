object ExpenseReport {

  private val Year = 2020

  // O(n * eC)
  def fixTwoValues(expenseReport: Set[Int]): Option[Int] = {
    val maybeMatchingValue = expenseReport.find(element => expenseReport.contains(Year - element))

    maybeMatchingValue.map(matchingValue => matchingValue * (Year - matchingValue))
  }

  def fixThreeValues(expenseReport: Set[Int]): Option[Int] = {
    val maybeMatchingValues = expenseReport.subsets(3).find(_.sum == Year)
    maybeMatchingValues.map(_.product)
  }


  def main(args: Array[String]): Unit = {
    val input = InputReader.readToIntegerSet("src/main/resources/input-1")

    val firstStartTime = System.nanoTime()
    val maybeFirstAnswer = ExpenseReport.fixTwoValues(input)
    val firstEndTime = System.nanoTime()

    maybeFirstAnswer match {
      case None => println("Error: no answer found !")
      case Some(answer) => println(s"First answer is '$answer'")
    }

    val firstDuration = (firstEndTime - firstStartTime) * 10E-6
    println(s"Duration in ms: $firstDuration")

    val secondStartTime = System.nanoTime()
    val maybeSecondAnswer = ExpenseReport.fixThreeValues(input)
    val secondEndTime = System.nanoTime()

    maybeSecondAnswer match {
      case None => println("Error: no answer found !")
      case Some(answer) => println(s"Second answer is '$answer'")
    }

    val secondDuration = (secondEndTime - secondStartTime) * 10E-6
    println(s"Duration in ms: $secondDuration")

  }

}
