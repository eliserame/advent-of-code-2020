package com.aoc

import scala.io.Source

object InputReader {

  def apply(path: String): Iterable[String] = {
    val source = Source.fromFile(path)
    val lines = source.getLines().to(Iterable)
    source.close()

    lines
  }

}
