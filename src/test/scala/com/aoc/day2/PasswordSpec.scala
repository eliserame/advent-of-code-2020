package com.aoc.day2

import com.aoc.UnitSpec

class PasswordSpec extends UnitSpec {

  "Password" should "have first and second int values, character and value according to its string description" in {
    // Given
    val description = "1-3 a: abcde"

    // When
    val password = Password(description)

    // Then
    password shouldBe Password(1, 3, 'a', "abcde")
  }

  it should "return false when password doesn't respect sled rental policy" in {
    // Given
    val password = Password("1-3 b: cdefg")
    val policy = SledRentalPolicy

    // When
    val isValid = password.isValid(policy)

    // Then
    isValid shouldBe false
  }

  it should "return true when password respects sled rental policy" in {
    // Given
    val password = Password("2-9 c: ccccccccc")
    val policy = SledRentalPolicy

    // When
    val isValid = password.isValid(policy)

    // Then
    isValid shouldBe true
  }

  it should "return true when it respects OTCP with exactly one matching character" in {
    // Given
    val password = Password("1-3 a: abcde")
    val policy = OfficialTobogganCorporatePolicy

    // When
    val isValid = password.isValid(policy)

    // Then
    isValid shouldBe true
  }

  it should "return false when it doesn't respect OTCP because no matching character" in {
    // Given
    val password = Password("1-3 b: cdefg")
    val policy = OfficialTobogganCorporatePolicy

    // When
    val isValid = password.isValid(policy)

    // Then
    isValid shouldBe false
  }

  it should "return false when it doesn't respect OTCP because too many matching character" in {
    // Given
    val password = Password("1-3 b: cdefg")
    val policy = OfficialTobogganCorporatePolicy

    // When
    val isValid = password.isValid(policy)

    // Then
    isValid shouldBe false
  }

}
