package com.aoc.day11

trait ModelVersion {
  def findSeatsMethod: (WaitingArea, Seat) => Seq[Boolean]

  def occupiedSeatsToLeave: Int
}

case object FirstModel extends ModelVersion {
  override def findSeatsMethod: (WaitingArea, Seat) => Seq[Boolean] =
    (area: WaitingArea, seat: Seat) => seat.adjacentSeats.flatMap(area.seats.get)

  override def occupiedSeatsToLeave: Int = 4
}

case object SecondModel extends ModelVersion {
  override def findSeatsMethod: (WaitingArea, Seat) => Seq[Boolean] =
    (area: WaitingArea, seat: Seat) => area.statusOfVisibleSeats(seat)

  override def occupiedSeatsToLeave: Int = 5
}
