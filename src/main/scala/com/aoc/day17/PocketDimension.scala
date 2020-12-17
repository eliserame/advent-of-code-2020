package com.aoc.day17

import com.aoc.InputReader

import scala.collection.immutable.HashSet

object PocketDimension {

  def execute3D(initialState: Seq[String]): Int = {
    val initialActiveCubes = initialState.zipWithIndex.foldLeft(List.empty[Cube]) { case (cubes, (row, y)) =>
      cubes ++ row.zipWithIndex.collect { case ('#', x) => Cube(x, y, 0) }
    }

    execute(initialActiveCubes)
  }

  def execute4D(initialState: Seq[String]): Int = {
    val initialActiveHyperCubes = initialState.zipWithIndex.foldLeft(List.empty[HyperCube]) { case (hyperCubes, (row, y)) =>
      hyperCubes ++ row.zipWithIndex.collect { case ('#', x) => HyperCube(x, y, 0, 0) }
    }

    execute(initialActiveHyperCubes)
  }

  private def execute(cubes: Seq[ConwayCube]): Int = {
    (1 to 6).foldLeft(cubes.to(HashSet)) { case (activeCubes, _) =>
      val updatedActiveCubes = activeCubes.filter { cube =>
        val activeNeighbours = cube.neighbours.count(activeCubes.contains)
        activeNeighbours == 2 || activeNeighbours == 3
      }

      val newActiveCubes = (activeCubes.flatMap(_.neighbours) -- activeCubes).filter { cube =>
        cube.neighbours.count(activeCubes.contains) == 3
      }

      updatedActiveCubes ++ newActiveCubes
    }.size
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-17")

    val firstAnswer = execute3D(input)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = execute4D(input)
    println(s"Second answer is '$secondAnswer'")
  }

}
