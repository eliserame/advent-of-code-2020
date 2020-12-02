package com.aoc.day2

import com.aoc.UnitSpec

class PasswordCheckerSpec extends UnitSpec {

  private val Passwords = List(
    Password("1-3 a: abcde"),
    Password("1-3 b: cdefg"),
    Password("2-9 c: ccccccccc")
  )

  "PasswordChecker" should "count valid passwords respecting sled rental policy" in {
    // Given
    val policy = SledRentalPolicy

    // When
    val numberOfValidPassword = PasswordChecker.count(Passwords, policy)

    // Then
    numberOfValidPassword shouldBe 2
  }

  it should "count valid passwords respecting Official Toboggan Corporate Policy" in {
    // Given
    val policy = OfficialTobogganCorporatePolicy

    // When
    val numberOfValidPassword = PasswordChecker.count(Passwords, policy)

    // Then
    numberOfValidPassword shouldBe 1
  }

}
