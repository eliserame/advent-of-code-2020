package com.aoc.day11

import com.aoc.InputReader

import scala.annotation.tailrec

object ModelExecutor {

  def executeModel(area: WaitingArea, model: ModelVersion): Int = {
    @tailrec
    def round(area: WaitingArea, hasChanged: Boolean): WaitingArea = {
      if (!hasChanged) area
      else {
        val (newSeats, newHasChanged) = area.seats.foldLeft(area.seats, false) { case ((currentSeats, hasChanged), (seat, isOccupied)) =>
          val seatsToCheck = model.findSeatsMethod(area, seat)
          if (isOccupied && seatsToCheck.count(identity) >= model.occupiedSeatsToLeave) (currentSeats.updated(seat, false), true)
          else if (!isOccupied && seatsToCheck.forall(!_)) (currentSeats.updated(seat, true), true)
          else (currentSeats, hasChanged)
        }

        round(area.update(newSeats), newHasChanged)
      }
    }

    round(area, hasChanged = true).seats.count(_._2)
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-11")
    val area = WaitingArea(input)

    val firstAnswer = executeModel(area, FirstModel)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = executeModel(area, SecondModel)
    println(s"Second answer is '$secondAnswer'")
  }

}
