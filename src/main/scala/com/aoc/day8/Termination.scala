package com.aoc.day8

import scala.collection.immutable.LinearSeq

trait Termination {
  def accumulator: Int
}

case class InfiniteLoop(accumulator: Int, executedInstructions: LinearSeq[Int]) extends Termination

case class End(accumulator: Int) extends Termination
