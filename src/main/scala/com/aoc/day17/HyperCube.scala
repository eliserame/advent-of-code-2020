package com.aoc.day17

import scala.collection.immutable.HashSet

case class HyperCube(x: Int, y: Int, z: Int, w: Int) extends ConwayCube {

  override lazy val neighbours: Seq[HyperCube] = {
    val possibleX = HashSet(x - 1, x, x + 1)
    val possibleY = HashSet(y - 1, y, y + 1)
    val possibleZ = HashSet(z - 1, z, z + 1)
    val possibleW = HashSet(w - 1, w, w + 1)

    val hyperCubes = for {
      neighbourX <- possibleX
      neighbourY <- possibleY
      neighbourZ <- possibleZ
      neighbourW <- possibleW
    } yield HyperCube(neighbourX, neighbourY, neighbourZ, neighbourW)

    (hyperCubes - this).toList
  }

}
