package com.aoc.day12

import com.aoc.InputReader

import scala.collection.immutable.LinearSeq

object NavigationComputer {

  def execute(instructions: LinearSeq[(Char, Int)]): Int = {
    val ship = instructions.foldLeft(Ship(0, 0, East)) { case (ship, (action, value)) =>
      val correctedAction = if (action == 'F') ship.direction.charValue else action
      ship.update(correctedAction, value)
    }

    Math.abs(ship.east) + Math.abs(ship.north)
  }

  def executeWithWaypoint(instructions: LinearSeq[(Char, Int)]): Int = {
    val (_, ship) = instructions.foldLeft(Waypoint(10, 1), Ship(0, 0, East)) { case ((waypoint, ship), (action, value)) =>
      if (action == 'F') (waypoint, ship.update(waypoint, value))
      else (waypoint.update(action, value), ship)
    }

    Math.abs(ship.east) + Math.abs(ship.north)
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-12").toList
    val instructions = input.map { line =>
      (line.head, line.tail.toInt)
    }

    val firstAnswer = execute(instructions)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = executeWithWaypoint(instructions)
    println(s"Second answer is '$secondAnswer'")
  }

}
