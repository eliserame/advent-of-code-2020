package com.aoc.day5

case class BoardingPass(row: Int, column: Int, seatID: Int)

object BoardingPass {

  def apply(description: String): BoardingPass = {
    val binaryDescription = description.map {
      case 'F' | 'L' => 0
      case 'B' | 'R' => 1
    }.mkString

    val row = Integer.parseInt(binaryDescription.take(7), 2)
    val column = Integer.parseInt(binaryDescription.takeRight(3), 2)
    val seatID = row * 8 + column

    BoardingPass(row, column, seatID)
  }

}
