package com.aoc.day15

import scala.annotation.tailrec

object MemoryGame {

  def play(startingNumbers: IndexedSeq[Int], lastTurn: Int): Int = {
    @tailrec
    def playTurn(turn: Int, lastNumber: Int, numbers: Map[Int, Int]): Int = {
      if (turn >= lastTurn) lastNumber
      else {
        numbers.get(lastNumber) match {
          case None => playTurn(turn + 1, 0, numbers + (lastNumber -> turn))
          case Some(age) => playTurn(turn + 1, turn - age, numbers + (lastNumber -> turn))
        }
      }
    }

    val numbers = startingNumbers.zipWithIndex.map { case (value, index) => value -> (index + 1) }.toMap
    val firstTurn = startingNumbers.length
    val lastNumber = startingNumbers.last

    playTurn(firstTurn, lastNumber, numbers)
  }

  def main(args: Array[String]): Unit = {
    val input = Vector(2,0,1,9,5,19)

    val firstAnswer = play(input, 2020)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = play(input, 30000000)
    println(s"Second answer is '$secondAnswer'")
  }

}
