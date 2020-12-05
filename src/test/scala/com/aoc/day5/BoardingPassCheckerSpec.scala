package com.aoc.day5

import com.aoc.UnitSpec

class BoardingPassCheckerSpec extends UnitSpec {

  "BoardingPassChecker" should "return the highest seat ID" in {
    // Given
    val boardingPass = List(BoardingPass("BFFFBBFRRR"), BoardingPass("FFFBBBFRRR"), BoardingPass("BBFFBBFRLL"))

    // When
    val result = BoardingPassChecker.highestSeatID(boardingPass)

    // Then
    result shouldBe 820
  }

}
