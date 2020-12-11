package com.aoc.day11

import com.aoc.UnitSpec

class ModelExecutorSpec extends UnitSpec {

  "ModelExecutor" should "return number of occupied seats when people stop moving using first model" in {
    // Given
    val area = WaitingArea(List(
      "L.LL.LL.LL",
      "LLLLLLL.LL",
      "L.L.L..L..",
      "LLLL.LL.LL",
      "L.LL.LL.LL",
      "L.LLLLL.LL",
      "..L.L.....",
      "LLLLLLLLLL",
      "L.LLLLLL.L",
      "L.LLLLL.LL"
    ))

    // When
    val occupiedSeats = ModelExecutor.executeModel(area, FirstModel)

    // Then
    occupiedSeats shouldBe 37
  }

  it should "return number of occupied seats when people stop moving using second model" in {
    // Given
    val area = WaitingArea(List(
      "L.LL.LL.LL",
      "LLLLLLL.LL",
      "L.L.L..L..",
      "LLLL.LL.LL",
      "L.LL.LL.LL",
      "L.LLLLL.LL",
      "..L.L.....",
      "LLLLLLLLLL",
      "L.LLLLLL.L",
      "L.LLLLL.LL"
    ))

    // When
    val occupiedSeats = ModelExecutor.executeModel(area, SecondModel)

    // Then
    occupiedSeats shouldBe 26
  }
}
