package com.aoc.day11

import com.aoc.UnitSpec

class SeatSpec extends UnitSpec {

  "Seat" should "return its adjacent seats" in {
    // Given
    val seat = Seat(3, 5)

    // When
    val adjacentSeats = seat.adjacentSeats

    // Then
    adjacentSeats should contain theSameElementsAs List(
      Seat(2, 5),
      Seat(2, 4),
      Seat(2, 6),
      Seat(3, 4),
      Seat(3, 6),
      Seat(4, 5),
      Seat(4, 4),
      Seat(4, 6)
    )
  }

}
