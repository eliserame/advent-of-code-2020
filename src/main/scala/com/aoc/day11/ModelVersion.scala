package com.aoc.day11

import scala.collection.LinearSeq

trait ModelVersion {
  def findSeatsMethod: (WaitingArea, Seat) => LinearSeq[Boolean]

  def occupiedSeatsToLeave: Int
}

case object FirstModel extends ModelVersion {
  override def findSeatsMethod: (WaitingArea, Seat) => LinearSeq[Boolean] =
    (area: WaitingArea, seat: Seat) => seat.adjacentSeats.flatMap(area.seats.get)

  val occupiedSeatsToLeave: Int = 4
}

case object SecondModel extends ModelVersion {
  override def findSeatsMethod: (WaitingArea, Seat) => LinearSeq[Boolean] =
    (area: WaitingArea, seat: Seat) => area.statusOfVisibleSeats(seat)

  val occupiedSeatsToLeave: Int = 5
}
