package com.aoc.day5

import com.aoc.InputReader

object BoardingPassChecker {

  def highestSeatID(boardingPass: Iterable[BoardingPass]): Int = {
    boardingPass.map(_.seatID).max
  }

  def findSeat(boardingPass: Iterable[BoardingPass], maxSeatID: Int): Option[Int] = {
    val seatIDs = maxSeatID to 0 by -1
    val takenSeatIDs = boardingPass.map(_.seatID).toSet

    seatIDs.find(!takenSeatIDs.contains(_))
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-5")
    val boardingPass = input.map(BoardingPass(_))

    val firstAnswer = highestSeatID(boardingPass)
    println(s"First answer is '$firstAnswer'")

    val maybeSecondAnswer = findSeat(boardingPass, firstAnswer)
    maybeSecondAnswer match {
      case None => println("Error: no answer found !")
      case Some(answer) => println(s"Second answer is '$answer'")
    }
  }

}
