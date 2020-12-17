package com.aoc.day9

import com.aoc.InputReader

import scala.annotation.tailrec
import scala.collection.immutable.{ArraySeq, HashSet}

object XMASReader {

  def findInvalidNumberWeakness(code: IndexedSeq[Long], preambleLength: Int): Long = {
    @tailrec
    def checkSum(index: Int, window: Iterator[Set[Long]]): Long = {
      val number = code(index)
      val previousNumbers = window.next()

      if (previousNumbers.subsets(2).map(_.sum).contains(number))
        checkSum(index + 1, window)
      else number
    }

    val window = code.sliding(preambleLength).map(_.to(HashSet))
    checkSum(preambleLength, window)
  }

  def findEncryptionWeakness(code: IndexedSeq[Long], invalidNumber: Long): Long = {
    @tailrec
    def searchSumElements(start: Int, end: Int): IndexedSeq[Long] = {
      val sumElements = code.slice(start, end)
      sumElements.sum match {
        case `invalidNumber` => sumElements
        case sum if sum < invalidNumber => searchSumElements(start, end + 1)
        case _ if (end - start) == 1 => searchSumElements(start + 1, end + 1)
        case _ => searchSumElements(start + 1, end)
      }
    }

    val sumElements = searchSumElements(0, 1).sorted
    sumElements.head + sumElements.last
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-9")
    val code = input.map(_.toLong).to(ArraySeq)

    val firstAnswer = findInvalidNumberWeakness(code, 25)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = findEncryptionWeakness(code, firstAnswer)
    println(s"Second answer is '$secondAnswer'")
  }

}
