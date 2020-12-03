package com.aoc.day3

import com.aoc.UnitSpec

class AreaSpec extends UnitSpec {

  "Area" should "contain width, length and coordinates for all trees" in {
    // Given
    val description = List(
      "..##.......",
      "#...#...#..",
      ".#....#..#.",
      "..#.#...#.#"
    )

    // When
    val area = Area(description)

    // Then
    area shouldBe Area(11, 4, Set(
      (2, 0),
      (3, 0),
      (0, 1),
      (4, 1),
      (8, 1),
      (1, 2),
      (6, 2),
      (9, 2),
      (2, 3),
      (4, 3),
      (8, 3),
      (10, 3)
    ))
  }

  it should "return false when coordinates are not a tree" in {
    // Given
    val area = Area(11, 2, Set((2, 0), (3, 0), (0, 1), (4, 1), (8, 1)))
    val x = 38
    val y = 1

    // When
    val isTree = area.isTree(x, y)

    // Then
    isTree shouldBe false
  }

  it should "return true when coordinates are a tree" in {
    // Given
    val area = Area(11, 2, Set((2, 0), (3, 0), (0, 1), (4, 1), (8, 1)))
    val x = 47
    val y = 0

    // When
    val isTree = area.isTree(x, y)

    // Then
    isTree shouldBe true
  }

}
