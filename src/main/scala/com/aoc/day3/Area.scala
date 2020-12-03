package com.aoc.day3

import scala.collection.immutable.HashSet

case class Area(width: Int, length: Int, trees: Set[(Int, Int)]) {

  def isTree(x: Int, y: Int): Boolean = {
    if (y > length) false
    else trees.contains((x % width, y))
  }

}

object Area {

  def apply(description: Seq[String]): Area = {
    val width = description.head.length
    val (length, trees) = description.foldLeft((0, HashSet.empty[(Int, Int)])) { case ((rowIndex, currentTrees), row) =>
      val treesInRow = currentTrees ++ row.zipWithIndex.filter(_._1 == '#').map(tree => (tree._2, rowIndex))
      (rowIndex + 1, treesInRow)
    }

    Area(width, length, trees)
  }

}
