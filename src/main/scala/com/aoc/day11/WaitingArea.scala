package com.aoc.day11

import scala.annotation.tailrec
import scala.collection.immutable.HashMap

case class WaitingArea(width: Int, length: Int, seats: Map[Seat, Boolean]) {

  def statusOfVisibleSeats(seat: Seat): Seq[Boolean] = {
    @tailrec
    def statusOfFirstVisibleSeat(xDirection: Int, yDirection: Int, increment: Int): Option[Boolean] = {
      val x = seat.x + increment * xDirection
      val y = seat.y + increment * yDirection

      if (x < 0 || y < 0 || x >= width || y >= length) None
      else {
        seats.get(Seat(x, y)) match {
          case Some(status) => Some(status)
          case None => statusOfFirstVisibleSeat(xDirection, yDirection, increment + 1)
        }
      }
    }

    List(
      statusOfFirstVisibleSeat(-1, -1, 1),
      statusOfFirstVisibleSeat(0, -1, 1),
      statusOfFirstVisibleSeat(1, -1, 1),
      statusOfFirstVisibleSeat(1, 0, 1),
      statusOfFirstVisibleSeat(1, 1, 1),
      statusOfFirstVisibleSeat(0, 1, 1),
      statusOfFirstVisibleSeat(-1, 1, 1),
      statusOfFirstVisibleSeat(-1, 0, 1)
    ).flatten
  }

  def update(seats: Map[Seat, Boolean]): WaitingArea = this.copy(seats = seats)

}

object WaitingArea {

  def apply(description: Seq[String]): WaitingArea = {
    val width = description.head.length
    val length = description.size
    val seats = description.zipWithIndex.foldLeft(HashMap.empty[Seat, Boolean]) { case (seats, (row, y)) =>
      seats ++ row.zipWithIndex.flatMap { case (seat, x) =>
        seat match {
          case 'L' => Some(Seat(x, y), false)
          case '#' => Some(Seat(x, y), true)
          case _ => None
        }
      }
    }

    WaitingArea(width, length, seats)
  }

}
