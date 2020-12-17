package com.aoc.day4

import com.aoc.day4.Passport.MandatoryFields

import scala.collection.immutable.{HashMap, HashSet}

case class Passport(pairs: Map[String, String]) {

  def containsMandatoryFields: Boolean = MandatoryFields.subsetOf(pairs.keySet)

  def isValid: Boolean = {
    containsMandatoryFields &&
      isYearValid(pairs("byr"), "1920", "2002") &&
      isYearValid(pairs("iyr"), "2010", "2020") &&
      isYearValid(pairs("eyr"), "2020", "2030") &&
      isHeightValid(pairs("hgt")) &&
      pairs("hcl").matches("""#[0-9a-f]{6}""") &&
      eyeColorValidValues.contains(pairs("ecl")) &&
      pairs("pid").matches("""\d{9}""")
  }

  private val eyeColorValidValues = HashSet("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

  private def isYearValid(value: String, min: String, max: String): Boolean = {
    value.matches("""\d{4}""") && min <= value && value <= max
  }

  private def isHeightValid(value: String): Boolean = {
    val cmHeight = """(\d{3})cm""".r
    val inHeight = """(\d{2})in""".r

    value match {
      case cmHeight(height) => "150" <= height && height <= "193"
      case inHeight(height) => "59" <= height && height <= "76"
      case _ => false
    }
  }

}

object Passport {

  val MandatoryFields: Set[String] = HashSet("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

  def apply(description: String): Passport = {
    val pairs = description.split("""[\s-]""").filterNot(_.isEmpty).map { pair =>
      val tokens = pair.split(":")
      tokens(0) -> tokens(1)
    }.to(HashMap)

    Passport(pairs)
  }

}
