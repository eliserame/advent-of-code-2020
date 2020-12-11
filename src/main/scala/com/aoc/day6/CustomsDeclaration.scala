package com.aoc.day6

import com.aoc.InputReader

object CustomsDeclaration {

  def sumAnyone(forms: Seq[String]): Int = {
    val yesAnswers = forms.map(_.filter(_.isLetter).toSet)
    yesAnswers.map(_.size).sum
  }

  def sumEveryone(forms: Seq[String]): Int = {
    val answersByGroup = forms.map(_.split("\n").filterNot(_.isEmpty).map(_.toSet))
    val countYesAnswersByGroup = answersByGroup.map(_.reduce(_ intersect _).size)

    countYesAnswersByGroup.sum
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readFile("src/main/resources/input-6")
    val forms = input.split("""(?m)^\s*$""")

    val firstAnswer = sumAnyone(forms)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = sumEveryone(forms)
    println(s"Second answer is '$secondAnswer'")
  }

}
