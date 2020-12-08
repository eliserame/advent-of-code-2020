package com.aoc.day8

import com.aoc.UnitSpec

import scala.util.Success

class GameConsoleSpec extends UnitSpec {

  "GameConsole" should "read code and translate it into instructions" in {
    // Given
    val code = List(
      "nop +0",
      "acc +1",
      "jmp +4",
      "acc +3",
      "jmp -3",
      "acc -99",
      "acc +1",
      "jmp -4",
      "acc +6"
    )

    // When
    val instructions = GameConsole.readCode(code)

    // Then
    instructions shouldBe Success(Vector(
      ("nop", 0),
      ("acc", 1),
      ("jmp", 4),
      ("acc", 3),
      ("jmp", -3),
      ("acc", -99),
      ("acc", 1),
      ("jmp", -4),
      ("acc", 6)
    ))
  }

  it should "execute code with infinite loop and return accumulator value before the loop" in {
    // Given
    val code = Vector(
      ("nop", 0),
      ("acc", 1),
      ("jmp", 4),
      ("acc", 3),
      ("jmp", -3),
      ("acc", -99),
      ("acc", 1),
      ("jmp", -4),
      ("acc", 6)
    )

    // When
    val accumulator = GameConsole.getAccumulatorBeforeInfiniteLoop(code)

    // Then
    accumulator.success.value shouldBe 5
  }

  it should "correct code and return accumulator value" in {
    // Given
    val code = Vector(
      ("nop", 0),
      ("acc", 1),
      ("jmp", 4),
      ("acc", 3),
      ("jmp", -3),
      ("acc", -99),
      ("acc", 1),
      ("jmp", -4),
      ("acc", 6)
    )

    // When
    val accumulator = GameConsole.fixCode(code)

    // Then
    accumulator.success.value shouldBe 8
  }


}
