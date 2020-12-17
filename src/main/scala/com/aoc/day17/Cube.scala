package com.aoc.day17

import scala.collection.immutable.HashSet

case class Cube(x: Int, y: Int, z: Int) extends ConwayCube {

  override lazy val neighbours: Seq[Cube] = {
    val possibleX = HashSet(x - 1, x, x + 1)
    val possibleY = HashSet(y - 1, y, y + 1)
    val possibleZ = HashSet(z - 1, z, z + 1)

    val cubes = for {
      neighbourX <- possibleX
      neighbourY <- possibleY
      neighbourZ <- possibleZ
    } yield Cube(neighbourX, neighbourY, neighbourZ)

    (cubes - this).toList
  }
}
