package com.aoc.day3

import com.aoc.InputReader

object TobogganSlope {

  def countTrees(area: Area, slope: Slope): Long = {
    val xCoordinates = 0 until (area.length * slope.right) by slope.right
    val yCoordinates = 0 until (area.length * slope.down) by slope.down
    val positions = xCoordinates.zip(yCoordinates)

    positions.count(position => area.isTree(position._1, position._2))
  }

  def multiplyTreesPerSlope(area: Area, slopes: List[Slope]): Long = {
    slopes.map(countTrees(area, _)).product
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-3").toList
    val area = Area(input)

    val slope = Slope(3, 1)
    val firstAnswer = countTrees(area, slope)
    println(s"First answer is '$firstAnswer'")

    val slopes = List(Slope(1, 1), Slope(3, 1), Slope(5, 1), Slope(7, 1), Slope(1, 2))
    val secondAnswer = multiplyTreesPerSlope(area, slopes)
    println(s"Second answer is '$secondAnswer'")
  }

}
