package com.aoc.day17

import com.aoc.UnitSpec

class PocketDimensionSpec extends UnitSpec {

  "PocketDimension" should "return number of active cube after 6 cycles using 3 dimensions" in {
    // Given
    val initialState = List(
      ".#.",
      "..#",
      "###"
    )

    // When
    val activeCubes = PocketDimension.execute3D(initialState)

    // Then
    activeCubes shouldBe 112
  }

  it should "return number of active cube after 6 cycles using 4 dimensions" in {
    // Given
    val initialState = List(
      ".#.",
      "..#",
      "###"
    )

    // When
    val activeCubes = PocketDimension.execute4D(initialState)

    // Then
    activeCubes shouldBe 848
  }

}
