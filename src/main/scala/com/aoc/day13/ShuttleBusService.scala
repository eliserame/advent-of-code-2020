package com.aoc.day13

import com.aoc.InputReader

import scala.annotation.tailrec
import scala.collection.immutable.LinearSeq
import scala.util.Try

object ShuttleBusService {

  def findEarliestBus(notes: LinearSeq[String]): Int = {
    val depart = notes.head.toInt
    val buses = notes.tail.flatMap(_.split(",").flatMap(value => Try(value.toInt).toOption)).toList
    val (busId, busDepart) = buses.map(bus => (bus, (depart / bus + 1) * bus)).minBy(_._2)
    busId * (busDepart - depart)
  }

  def findTimestampForContest(notes: LinearSeq[String]): Long = {
    val buses = notes
      .flatMap(_.split(","))
      .zipWithIndex
      .flatMap { case (id, position) => Try(id.toInt -> position).toOption }
      .sortBy(-_._1)

    @tailrec
    def searchTimestamp(cycles: Long, factor: Long, buses: LinearSeq[(Int, Int)]): Long = {
      val (firstBus, firstBusPosition) = buses.head
      val timestamp = firstBus * cycles - firstBusPosition
      if (buses.tail.isEmpty) timestamp
      else {
        val (secondBus, secondBusPosition) = buses.tail.head
        if ((timestamp + secondBusPosition) % secondBus != 0) searchTimestamp(cycles + factor, factor, buses)
        else searchTimestamp((timestamp + secondBusPosition) / secondBus, factor * firstBus, buses.tail)
      }
    }

    searchTimestamp(1, 1, buses)
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-13").toList

    val firstAnswer = findEarliestBus(input)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = findTimestampForContest(input.tail)
    println(s"Second answer is '$secondAnswer'")
  }

}
