package com.aoc.day4

import com.aoc.InputReader

object PassportScanner {

  def countPassportsContainingAllMandatoryFields(passports: Iterable[Passport]): Int = {
    passports.count(_.containsMandatoryFields)
  }

  def countValidPassports(passports: Iterable[Passport]): Int = {
    passports.count(_.isValid)
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readFile("src/main/resources/input-4")
    val passports = input.split("""(?m)^\s*$""").map(Passport(_))

    val firstAnswer = countPassportsContainingAllMandatoryFields(passports)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = countValidPassports(passports)
    println(s"Second answer is '$secondAnswer'")
  }

}
