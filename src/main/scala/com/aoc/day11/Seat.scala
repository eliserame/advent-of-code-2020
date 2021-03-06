package com.aoc.day11

import scala.collection.immutable.LinearSeq

case class Seat(x: Int, y: Int) {

  def adjacentSeats: LinearSeq[Seat] = {
    List(
      Seat(x - 1, y - 1),
      Seat(x, y - 1),
      Seat(x + 1, y - 1),
      Seat(x + 1, y),
      Seat(x + 1, y + 1),
      Seat(x, y + 1),
      Seat(x - 1, y + 1),
      Seat(x - 1, y)
    )
  }

}
