package com.aoc.day4

import com.aoc.UnitSpec

import scala.collection.immutable.HashMap

class PassportSpec extends UnitSpec {

  private val validPairs = HashMap(
    "byr" -> "2002",
    "iyr" -> "2015",
    "eyr" -> "2023",
    "hgt" -> "190cm",
    "hcl" -> "#123abc",
    "ecl" -> "brn",
    "pid" -> "000000001",
    "cid" -> "147"
  )

  "Passport" should "be valid if all mandatory fields are present and valid" in {
    // Given
    val passport = Passport(validPairs)

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe true
  }

  it should "be valid if 'cid' field is missing" in {
    // Given
    val passport = Passport(validPairs - "cid")

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe true
  }

  it should "be invalid if a mandatory field is missing" in {
    // Given
    val passport = Passport(validPairs - "hgt")

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'byr' value is not valid" in {
    // Given
    val passport = Passport(validPairs.updated("byr", "2003"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'iyr' value is not valid" in {
    // Given
    val passport = Passport(validPairs.updated("iyr", "aaaa"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'eyr' value is not valid" in {
    // Given
    val passport = Passport(validPairs.updated("eyr", "02025"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'hgt' number is not valid" in {
    // Given
    val passport = Passport(validPairs.updated("hgt", "190in"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'hgt' unit is not valid" in {
    // Given
    val passport = Passport(validPairs.updated("hgt", "190"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'hcl' doesn't start with '#'" in {
    // Given
    val passport = Passport(validPairs.updated("hcl", "123abc"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'hcl' characters are not valid" in {
    // Given
    val passport = Passport(validPairs.updated("hcl", "#123abz"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'ecl' value is not valid" in {
    // Given
    val passport = Passport(validPairs.updated("ecl", "wat"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

  it should "be invalid if 'pid' value is not valid" in {
    // Given
    val passport = Passport(validPairs.updated("pid", "0123456789"))

    // When
    val isValid = passport.isValid

    // Then
    isValid shouldBe false
  }

}
