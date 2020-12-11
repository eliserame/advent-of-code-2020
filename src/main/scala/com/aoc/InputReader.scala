package com.aoc

import scala.io.Source

object InputReader {

  def readLines(path: String): Seq[String] = {
    val source = Source.fromFile(path)
    val lines = source.getLines().toSeq
    source.close()

    lines
  }

  def readFile(path: String): String = {
    readLines(path).mkString("\n")
  }

}
