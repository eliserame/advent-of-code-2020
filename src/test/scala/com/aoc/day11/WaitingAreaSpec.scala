package com.aoc.day11

import com.aoc.UnitSpec

import scala.collection.immutable.HashMap

class WaitingAreaSpec extends UnitSpec {

  "WaitingArea" should "transform description into waiting area with width, length and seats with status" in {
    // Given
    val description = List(
      "L.LL.",
      "L...L",
    )

    // When
    val area = WaitingArea(description)

    // Then
    area shouldBe WaitingArea(5, 2, HashMap(
      Seat(0, 0) -> false,
      Seat(2, 0) -> false,
      Seat(3, 0) -> false,
      Seat(0, 1) -> false,
      Seat(4, 1) -> false
    ))
  }

  it should "return status of visible seats with eight occupied seats" in {
    // Given
    val area = WaitingArea(List(
      ".......#.",
      "...#.....",
      ".#.......",
      ".........",
      "..#L....#",
      "....#....",
      ".........",
      "#........",
      "...#....."
    ))
    val seat = Seat(3, 4)

    // When
    val visibleSeats = area.statusOfVisibleSeats(seat)

    // Then
    visibleSeats should have length 8
    visibleSeats should contain only true
  }

  it should "return status of visible seats with only one empty seats" in {
    // Given
    val area = WaitingArea(List(
      ".............",
      ".L.L.#.#.#.#.",
      "............."
    ))
    val seat = Seat(1, 1)

    // When
    val visibleSeats = area.statusOfVisibleSeats(seat)

    // Then
    visibleSeats should have length 1
    visibleSeats should contain only false
  }

  it should "return empty status of visible seats with no visible seats" in {
    // Given
    val area = WaitingArea(List(
      ".##.##.",
      "#.#.#.#",
      "##...##",
      "...L...",
      "##...##",
      "#.#.#.#",
      ".##.##.",
    ))
    val seat = Seat(3, 3)

    // When
    val visibleSeats = area.statusOfVisibleSeats(seat)

    // Then
    visibleSeats shouldBe empty
  }

}
