package com.aoc.day17

import com.aoc.UnitSpec

class HyperCubeSpec extends UnitSpec {

  "A HyperCube" should "return all its neighbours" in {
    // Given
    val hyperCube = HyperCube(1, 2, 3, 4)

    // When
    val neighbours = hyperCube.neighbours

    // Then
    neighbours should have size 80
    neighbours should contain theSameElementsAs List(
      HyperCube(0, 1, 2, 3),
      HyperCube(0, 1, 2, 4),
      HyperCube(0, 1, 2, 5),
      HyperCube(0, 1, 3, 3),
      HyperCube(0, 1, 3, 4),
      HyperCube(0, 1, 3, 5),
      HyperCube(0, 1, 4, 3),
      HyperCube(0, 1, 4, 4),
      HyperCube(0, 1, 4, 5),
      HyperCube(0, 2, 2, 3),
      HyperCube(0, 2, 2, 4),
      HyperCube(0, 2, 2, 5),
      HyperCube(0, 2, 3, 3),
      HyperCube(0, 2, 3, 4),
      HyperCube(0, 2, 3, 5),
      HyperCube(0, 2, 4, 3),
      HyperCube(0, 2, 4, 4),
      HyperCube(0, 2, 4, 5),
      HyperCube(0, 3, 2, 3),
      HyperCube(0, 3, 2, 4),
      HyperCube(0, 3, 2, 5),
      HyperCube(0, 3, 3, 3),
      HyperCube(0, 3, 3, 4),
      HyperCube(0, 3, 3, 5),
      HyperCube(0, 3, 4, 3),
      HyperCube(0, 3, 4, 4),
      HyperCube(0, 3, 4, 5),
      HyperCube(1, 1, 2, 3),
      HyperCube(1, 1, 2, 4),
      HyperCube(1, 1, 2, 5),
      HyperCube(1, 1, 3, 3),
      HyperCube(1, 1, 3, 4),
      HyperCube(1, 1, 3, 5),
      HyperCube(1, 1, 4, 3),
      HyperCube(1, 1, 4, 4),
      HyperCube(1, 1, 4, 5),
      HyperCube(1, 2, 2, 3),
      HyperCube(1, 2, 2, 4),
      HyperCube(1, 2, 2, 5),
      HyperCube(1, 2, 4, 3),
      HyperCube(1, 2, 4, 4),
      HyperCube(1, 2, 4, 5),
      HyperCube(1, 3, 2, 3),
      HyperCube(1, 3, 2, 4),
      HyperCube(1, 3, 2, 5),
      HyperCube(1, 3, 3, 3),
      HyperCube(1, 3, 3, 4),
      HyperCube(1, 3, 3, 5),
      HyperCube(1, 3, 4, 3),
      HyperCube(1, 3, 4, 4),
      HyperCube(1, 3, 4, 5),
      HyperCube(2, 1, 2, 3),
      HyperCube(2, 1, 2, 4),
      HyperCube(2, 1, 2, 5),
      HyperCube(2, 1, 3, 3),
      HyperCube(2, 1, 3, 4),
      HyperCube(2, 1, 3, 5),
      HyperCube(2, 1, 4, 3),
      HyperCube(2, 1, 4, 4),
      HyperCube(2, 1, 4, 5),
      HyperCube(2, 2, 2, 3),
      HyperCube(2, 2, 2, 4),
      HyperCube(2, 2, 2, 5),
      HyperCube(2, 2, 3, 3),
      HyperCube(2, 2, 3, 4),
      HyperCube(2, 2, 3, 5),
      HyperCube(2, 2, 4, 3),
      HyperCube(2, 2, 4, 4),
      HyperCube(2, 2, 4, 5),
      HyperCube(2, 3, 2, 3),
      HyperCube(2, 3, 2, 4),
      HyperCube(2, 3, 2, 5),
      HyperCube(2, 3, 3, 3),
      HyperCube(2, 3, 3, 4),
      HyperCube(2, 3, 3, 5),
      HyperCube(2, 3, 4, 3),
      HyperCube(2, 3, 4, 4),
      HyperCube(2, 3, 4, 5),
      HyperCube(1, 2, 3, 3),
      HyperCube(1, 2, 3, 5)
    )
  }

}
