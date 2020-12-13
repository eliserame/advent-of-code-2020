package com.aoc.day6

import com.aoc.InputReader

import scala.collection.immutable.LinearSeq

object CustomsDeclaration {

  def sumAnyone(forms: LinearSeq[String]): Int = {
    val yesAnswers = forms.map(_.filter(_.isLetter).toSet)
    yesAnswers.map(_.size).sum
  }

  def sumEveryone(forms: LinearSeq[String]): Int = {
    val answersByGroup = forms.map(_.split("\n").filterNot(_.isEmpty).map(_.toSet))
    val countYesAnswersByGroup = answersByGroup.map(_.reduce(_ intersect _).size)

    countYesAnswersByGroup.sum
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readFile("src/main/resources/input-6")
    val forms = input.split("""(?m)^\s*$""").toList

    val firstAnswer = sumAnyone(forms)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = sumEveryone(forms)
    println(s"Second answer is '$secondAnswer'")
  }

}
