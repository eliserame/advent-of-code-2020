package com.aoc.day17

import com.aoc.UnitSpec

class CubeSpec extends UnitSpec {

  "A Cube" should "return all its neighbours" in {
    // Given
    val cube = Cube(1, 2, 3)

    // When
    val neighbours = cube.neighbours

    // Then
    neighbours should have size 26
    neighbours should contain theSameElementsAs List(
      Cube(0, 1, 2),
      Cube(0, 1, 3),
      Cube(0, 1, 4),
      Cube(0, 2, 2),
      Cube(0, 2, 3),
      Cube(0, 2, 4),
      Cube(0, 3, 2),
      Cube(0, 3, 3),
      Cube(0, 3, 4),
      Cube(1, 1, 2),
      Cube(1, 1, 3),
      Cube(1, 1, 4),
      Cube(1, 2, 2),
      Cube(1, 2, 4),
      Cube(1, 3, 2),
      Cube(1, 3, 3),
      Cube(1, 3, 4),
      Cube(2, 1, 2),
      Cube(2, 1, 3),
      Cube(2, 1, 4),
      Cube(2, 2, 2),
      Cube(2, 2, 3),
      Cube(2, 2, 4),
      Cube(2, 3, 2),
      Cube(2, 3, 3),
      Cube(2, 3, 4)
    )
  }

}
