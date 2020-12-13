package com.aoc.day12

import com.aoc.UnitSpec

class NavigationComputerSpec extends UnitSpec {

  "NavigationComputer" should "execute instructions and return Manhattan distance of the ship from starting point" in {
    // Given
    val instructions = List(
      ('F', 10),
      ('N', 3),
      ('F', 7),
      ('R', 90),
      ('F', 11)
    )

    // When
    val distance = NavigationComputer.execute(instructions)

    // Then
    distance shouldBe 25
  }

  it should "execute instructions using waypoint and return Manhattan distance of the ship from starting point" in {
    // Given
    val instructions = List(
      ('F', 10),
      ('N', 3),
      ('F', 7),
      ('R', 90),
      ('F', 11)
    )

    // When
    val distance = NavigationComputer.executeWithWaypoint(instructions)

    // Then
    distance shouldBe 286
  }

}
