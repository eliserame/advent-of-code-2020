package com.aoc.day10

import com.aoc.InputReader

import scala.annotation.tailrec
import scala.collection.immutable.{ArraySeq, HashMap}

object AdapterTester {

  def useAllAdapters(adapters: IndexedSeq[Int]): Int = {
    val (oneJoltDifferences, threeJoltsDifferences) = adapters.sliding(2).foldLeft((0, 1)) {
      case ((oneJolt, threeJolts), slice) =>
        slice(1) - slice(0) match {
          case 1 => (oneJolt + 1, threeJolts)
          case 3 => (oneJolt, threeJolts + 1)
          case _ => (oneJolt, threeJolts)
        }
    }

    oneJoltDifferences * threeJoltsDifferences
  }

  def countArrangements(adapters: IndexedSeq[Int]): Long = {
    val nonNecessaryAdapters = adapters.sliding(3).foldLeft(List.empty[Int]) { case (nonNecessaryAdapters, slice) =>
      if (slice(1) - slice(0) < 3 && slice(2) - slice(1) < 3) slice(1) +: nonNecessaryAdapters
      else nonNecessaryAdapters
    }.to(ArraySeq)

    @tailrec
    def getSizeOfSetsOfAdjacentElements(index: Int, sizes: Map[Int, Int]): Map[Int, Int] = {
      val firstElement = nonNecessaryAdapters(index)
      lazy val secondElement = nonNecessaryAdapters(index + 1)
      lazy val thirdElement = nonNecessaryAdapters(index + 2)

      val size = {
        if (index + 2 < nonNecessaryAdapters.length && firstElement - secondElement == 1)
          if (index + 3 < nonNecessaryAdapters.length && secondElement - thirdElement == 1) 3
          else 2
        else 1
      }

      val updatedSizes = sizes.updated(size, sizes(size) + 1)
      if (index >= nonNecessaryAdapters.length - 1) updatedSizes
      else getSizeOfSetsOfAdjacentElements(index + size, updatedSizes)
    }

    val sizeOfGroupOfNonNecessaryAdapters = getSizeOfSetsOfAdjacentElements(0, HashMap(1 -> 0, 2 -> 0, 3 -> 0))
    val sizeOneSubsets = Math.pow(Math.pow(2, 1), sizeOfGroupOfNonNecessaryAdapters(1))
    val sizeTwoSubsets = Math.pow(Math.pow(2, 2), sizeOfGroupOfNonNecessaryAdapters(2))
    val sizeThreeSubsets = Math.pow(Math.pow(2, 3) - 1, sizeOfGroupOfNonNecessaryAdapters(3))

    (sizeOneSubsets * sizeTwoSubsets * sizeThreeSubsets).toLong
  }


  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-10")
    val adapters = input.map(_.toInt).to(Vector)
    val sortedAdapters = 0 +: adapters.sorted

    val firstAnswer = useAllAdapters(sortedAdapters)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = countArrangements(sortedAdapters)
    println(s"Second answer is '$secondAnswer'")
  }

}
