package com.aoc.day18

import com.aoc.InputReader

import javax.script.ScriptEngineManager

object Calculator {

  private val Engine = {
    val scriptEngine = new ScriptEngineManager().getEngineByName("scala")
    scriptEngine.eval("import com.aoc.day18.Number")
    scriptEngine
  }

  private val Number = """(\d)""".r
  private val Operator = """([+|*])""".r
  private val Sum = """\+""".r
  private val Product = """\*""".r

  def evaluateWithSamePrecedence(expression: String): Long = {
    val updatedExpression = expression.foldLeft(List("")) {
      case (updatedExpression, character) => character match {
        case Number(value) => s"Number($value)" +: updatedExpression
        case Operator(value) => s"|$value|" +: updatedExpression
        case otherCharacter => s"$otherCharacter" +: updatedExpression
      }
    }.reverse.mkString(" ")

    evaluate(updatedExpression)
  }

  def evaluateWithDifferentPrecedence(expression: String): Long = {
    val updatedExpression = expression.foldLeft(List("")) {
      case (updatedExpression, character) => character match {
        case Number(value) => s"Number($value)" +: updatedExpression
        case Sum() => s"|+|" +: updatedExpression
        case Product() => "product" +: updatedExpression
        case otherCharacter => s"$otherCharacter" +: updatedExpression
      }
    }.reverse.mkString(" ")

    evaluate(updatedExpression)
  }

  private def evaluate(expression: String): Long = {
    val result = Engine.eval(expression)
    result.asInstanceOf[Number].value
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-18")

    val firstAnswer = input.map(evaluateWithSamePrecedence).sum
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = input.map(evaluateWithDifferentPrecedence).sum
    println(s"Second answer is '$secondAnswer'")
  }

}
