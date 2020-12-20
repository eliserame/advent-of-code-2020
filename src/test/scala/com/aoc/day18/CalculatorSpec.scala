package com.aoc.day18

import com.aoc.UnitSpec

class CalculatorSpec extends UnitSpec {

  "Calculator" should "evaluate '1 + 2 * 3 + 4 * 5 + 6' using same precedence for all operators" in {
    // Given
    val expression = "1 + 2 * 3 + 4 * 5 + 6"

    // When
    val result = Calculator.evaluateWithSamePrecedence(expression)

    // Then
    result shouldBe 71
  }

  it should "evaluate '1 + (2 * 3) + (4 * (5 + 6))' using same precedence for all operators" in {
    // Given
    val expression = "1 + (2 * 3) + (4 * (5 + 6))"

    // When
    val result = Calculator.evaluateWithSamePrecedence(expression)

    // Then
    result shouldBe 51
  }

  it should "evaluate '2 * 3 + (4 * 5)' using same precedence for all operators" in {
    // Given
    val expression = "2 * 3 + (4 * 5)"

    // When
    val result = Calculator.evaluateWithSamePrecedence(expression)

    // Then
    result shouldBe 26
  }

  it should "evaluate 5 + (8 * 3 + 9 + 3 * 4 * 3)' using same precedence for all operators" in {
    // Given
    val expression = "5 + (8 * 3 + 9 + 3 * 4 * 3)"

    // When
    val result = Calculator.evaluateWithSamePrecedence(expression)

    // Then
    result shouldBe 437
  }

  it should "evaluate '5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))' using same precedence for all operators" in {
    // Given
    val expression = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"

    // When
    val result = Calculator.evaluateWithSamePrecedence(expression)

    // Then
    result shouldBe 12240
  }

  it should "evaluate '((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2' using same precedence for all operators" in {
    // Given
    val expression = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"

    // When
    val result = Calculator.evaluateWithSamePrecedence(expression)

    // Then
    result shouldBe 13632
  }

  it should "evaluate '1 + 2 * 3 + 4 * 5 + 6' using different precedence for operators" in {
    // Given
    val expression = "1 + 2 * 3 + 4 * 5 + 6"

    // When
    val result = Calculator.evaluateWithDifferentPrecedence(expression)

    // Then
    result shouldBe 231
  }

  it should "evaluate '1 + (2 * 3) + (4 * (5 + 6))' using different precedence for operators" in {
    // Given
    val expression = "1 + (2 * 3) + (4 * (5 + 6))"

    // When
    val result = Calculator.evaluateWithDifferentPrecedence(expression)

    // Then
    result shouldBe 51
  }

  it should "evaluate '2 * 3 + (4 * 5)' using different precedence for operators" in {
    // Given
    val expression = "2 * 3 + (4 * 5)"

    // When
    val result = Calculator.evaluateWithDifferentPrecedence(expression)

    // Then
    result shouldBe 46
  }

  it should "evaluate '5 + (8 * 3 + 9 + 3 * 4 * 3)' using different precedence for operators" in {
    // Given
    val expression = "5 + (8 * 3 + 9 + 3 * 4 * 3)"

    // When
    val result = Calculator.evaluateWithDifferentPrecedence(expression)

    // Then
    result shouldBe 1445
  }

  it should "evaluate '5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4)) using different precedence for operators" in {
    // Given
    val expression = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"

    // When
    val result = Calculator.evaluateWithDifferentPrecedence(expression)

    // Then
    result shouldBe 669060
  }

  it should "evaluate '((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2' using different precedence for operators" in {
    // Given
    val expression = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"

    // When
    val result = Calculator.evaluateWithDifferentPrecedence(expression)

    // Then
    result shouldBe 23340
  }

}
