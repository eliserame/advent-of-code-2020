package com.aoc.day1

import com.aoc.InputReader

object ExpenseReport {

  private val Year = 2020

  def fixTwoValues(expenseReport: Set[Int]): Option[Int] = {
    val maybeMatchingValue = expenseReport.find(element => expenseReport.contains(Year - element))

    maybeMatchingValue.map(matchingValue => matchingValue * (Year - matchingValue))
  }

  def fixThreeValues(expenseReport: Set[Int]): Option[Int] = {
    val maybeMatchingValues = expenseReport.subsets(3).find(_.sum == Year)
    maybeMatchingValues.map(_.product)
  }


  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-1").map(_.toInt).toSet

    val maybeFirstAnswer = ExpenseReport.fixTwoValues(input)
    maybeFirstAnswer match {
      case None => println("Error: no answer found !")
      case Some(answer) => println(s"First answer is '$answer'")
    }

    val maybeSecondAnswer = ExpenseReport.fixThreeValues(input)
    maybeSecondAnswer match {
      case None => println("Error: no answer found !")
      case Some(answer) => println(s"Second answer is '$answer'")
    }
  }

}
