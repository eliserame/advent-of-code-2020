package com.aoc.day2

import com.aoc.InputReader

object PasswordChecker {

  def count(passwords: Seq[Password], policy: Policy): Int = {
    passwords.count(_.isValid(policy))
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-2")
    val passwords = input.map(Password(_))

    val firstAnswer = count(passwords, SledRentalPolicy)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = count(passwords, OfficialTobogganCorporatePolicy)
    println(s"Second answer is '$secondAnswer'")
  }

}
