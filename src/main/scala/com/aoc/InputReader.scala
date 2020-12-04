package com.aoc

import scala.io.Source

object InputReader {

  def readLines(path: String): Iterable[String] = {
    val source = Source.fromFile(path)
    val lines = source.getLines().to(Iterable)
    source.close()

    lines
  }

  def readFile(path: String): String = {
    readLines(path).mkString("\n")
  }

}
