package com.aoc.day5

import com.aoc.UnitSpec

class BoardingPassSpec extends UnitSpec {

  "Boarding pass" should "contain row, column and seat ID corresponding to its description" in {
    // Given
    val description = "FBFBBFFRLR"

    // When
    val boardingPass = BoardingPass(description)

    // Then
    boardingPass shouldBe BoardingPass(44, 5, 357)
  }

}
