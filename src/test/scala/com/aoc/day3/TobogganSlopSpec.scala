package com.aoc.day3

import com.aoc.UnitSpec

class TobogganSlopSpec extends UnitSpec {

  "TobogganSlope" should "return number of trees encountered trees in area given a specific slope" in {
    // Given
    val areaDescription = List(
      "..##.......",
      "#...#...#..",
      ".#....#..#.",
      "..#.#...#.#",
      ".#...##..#.",
      "..#.##.....",
      ".#.#.#....#",
      ".#........#",
      "#.##...#...",
      "#...##....#",
      ".#..#...#.#"
    )
    val area = Area(areaDescription)
    val slope = Slope(3, 1)

    // When
    val encounteredTrees = TobogganSlope.countTrees(area, slope)

    // Then
    encounteredTrees shouldBe 7
  }

  it should "return multiplied results given multiple slopes" in {
    // Given
    val areaDescription = List(
      "..##.......",
      "#...#...#..",
      ".#....#..#.",
      "..#.#...#.#",
      ".#...##..#.",
      "..#.##.....",
      ".#.#.#....#",
      ".#........#",
      "#.##...#...",
      "#...##....#",
      ".#..#...#.#"
    )
    val area = Area(areaDescription)
    val slopes = List(Slope(1, 1), Slope(3, 1), Slope(5, 1), Slope(7, 1), Slope(1, 2))

    // When
    val result = TobogganSlope.multiplyTreesPerSlope(area, slopes)

    // Then
    result shouldBe 336
  }

}
