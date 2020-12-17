package com.aoc.day4

import com.aoc.UnitSpec

import scala.collection.immutable.HashMap

class PassportScannerSpec extends UnitSpec {

  "PassportScanner" should "return number of valid passwords" in {
    val passports = List(
      Passport(HashMap("ecl" -> "gry", "pid" -> "860033327", "eyr" -> "2020", "hcl" -> "#fffffd", "byr" -> "1937", "iyr" -> "2017", "cid" -> "147", "hgt" -> "183cm")),
      Passport(HashMap("iyr" -> "2013", "ecl" -> "amb", "cid" -> "350", "eyr" -> "2023", "pid" -> "028048884", "hcl" -> "#cfa07d", "byr" -> "1929")),
      Passport(HashMap("hcl" -> "#ae17e1", "iyr" -> "2013", "eyr" -> "2024", "ecl" -> "brn", "pid" -> "760753108", "byr" -> "1931", "hgt" -> "179cm")),
      Passport(HashMap("hcl" -> "#cfa07d", "eyr" -> "2025", "pid" -> "166559648", "iyr" -> "2011", "ecl" -> "brn", "hgt" -> "59in"))
    )

    // When
    val validPassports = PassportScanner.countPassportsContainingAllMandatoryFields(passports)

    // Then
    validPassports shouldBe 2
  }

}
