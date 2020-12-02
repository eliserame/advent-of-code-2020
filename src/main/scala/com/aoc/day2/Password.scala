package com.aoc.day2

case class Password(firstIntValue: Int, secondIntValue: Int, character: Char, value: String) {

  def isValid(policy: Policy): Boolean = policy match {
    case SledRentalPolicy =>
      val count = value.count(_ == character)
      firstIntValue <= count && count <= secondIntValue
    case OfficialTobogganCorporatePolicy =>
      value(firstIntValue - 1) == character ^ value(secondIntValue - 1) == character
  }

}

object Password {

  def apply(description: String): Password = {
    val splitDescription = description.split("""[\s-]""")

    val firstIntValue = splitDescription(0).toInt
    val secondIntValue = splitDescription(1).toInt
    val character = splitDescription(2)(0)
    val value = splitDescription(3)

    Password(firstIntValue, secondIntValue, character, value)
  }

}
