package com.aoc.day8

import com.aoc.InputReader

import scala.annotation.tailrec
import scala.collection.immutable.{HashSet, LinearSeq}
import scala.util.{Failure, Success, Try}

object GameConsole {

  def getAccumulatorBeforeInfiniteLoop(code: IndexedSeq[(String, Int)]): Try[Int] = {
    executeCode(code).map(_.accumulator)
  }

  def fixCode(code: IndexedSeq[(String, Int)]): Try[Int] = {
    @tailrec
    def fix(executedInstructions: LinearSeq[Int]): Try[Int] = {
      val index = executedInstructions.head

      val newResult = code(index) match {
        case ("nop", argument) => Some(executeCode(code.updated(index, ("jmp", argument))))
        case ("jmp", argument) => Some(executeCode(code.updated(index, ("nop", argument))))
        case _ => None
      }

      newResult match {
        case Some(Success(End(accumulator))) => Success(accumulator)
        case Some(Failure(exception)) => Failure(exception)
        case _ => fix(executedInstructions.tail)
      }
    }

    executeCode(code).flatMap {
      case End(accumulator) => Success(accumulator)
      case InfiniteLoop(_, executedInstructions) => fix(executedInstructions)
    }
  }

  private def executeCode(code: IndexedSeq[(String, Int)]): Try[Termination] = {
    @tailrec
    def execute(index: Int, executedInstructions: LinearSeq[Int], alreadyExecutedInstructions: Set[Int], accumulator: Int): Try[Termination] = {
      if (index >= code.length) Success(End(accumulator))
      else if (alreadyExecutedInstructions.contains(index)) Success(InfiniteLoop(accumulator, executedInstructions))
      else {
        val (operation, argument) = code(index)
        operation match {
          case "acc" =>
            execute(index + 1, index +: executedInstructions, alreadyExecutedInstructions + index, accumulator + argument)
          case "jmp" =>
            execute(index + argument, index +: executedInstructions, alreadyExecutedInstructions + index, accumulator)
          case "nop" =>
            execute(index + 1, index +: executedInstructions, alreadyExecutedInstructions + index, accumulator)
          case unknownOperation =>
            Failure(GameConsoleException(s"Unknown operation found in code at line '$index': '$unknownOperation'."))
        }
      }
    }

    execute(0, List.empty[Int], HashSet.empty[Int], 0)
  }

  def readCode(code: LinearSeq[String]): Try[IndexedSeq[(String, Int)]] = {
    val maybeInstructions = code.map { line =>
      line.split("""\s""").toList match {
        case operation :: argument :: Nil if argument.matches("""[+-]\d*""") => Right((operation, argument.toInt))
        case _ => Left(line)
      }
    }

    val (errors, instructions) = maybeInstructions.foldLeft((List.empty[String], Vector.empty[(String, Int)])) { case ((errors, instructions), maybeInstruction) =>
      maybeInstruction match {
        case Left(line) => (line +: errors, instructions)
        case Right(instruction) => (errors, instructions :+ instruction)
      }
    }

    if (errors.isEmpty) Success(instructions)
    else Failure(GameConsoleException(s"Cannot parse some instructions in code:\n'${errors.mkString("'\n'")}'"))
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-8").toList
    val code = readCode(input).get

    val firstAnswer = getAccumulatorBeforeInfiniteLoop(code).get
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = fixCode(code).get
    println(s"Second answer is '$secondAnswer'")
  }

}


