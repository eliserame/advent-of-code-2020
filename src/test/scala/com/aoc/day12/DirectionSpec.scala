package com.aoc.day12

import com.aoc.UnitSpec

class DirectionSpec extends UnitSpec {

  "Direction" should "return new direction when it's updated with 'R' direction" in {
    // Given
    val direction = East

    // When
    val newDirection = direction.update(-180)

    // Then
    newDirection shouldBe West
  }

  it should "return new direction when it's updated with 'L' direction" in {
    // Given
    val direction = North

    // When
    val newDirection = direction.update(270)

    // Then
    newDirection shouldBe East
  }

}
