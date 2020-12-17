package com.aoc.day16

import com.aoc.InputReader

import scala.collection.immutable.{ArraySeq, HashMap, HashSet}

object TicketChecker {

  private val Rule = """(.*): (\d*)-(\d*) or (\d*)-(\d*)""".r

  def readNotes(notes: String): (Map[String, Int => Boolean], IndexedSeq[Int], Seq[IndexedSeq[Int]]) = {
    val splitNotes = notes.split("""(?m)^\s*$""").map(_.split("\n").filterNot(_.isEmpty))

    val rules = splitNotes(0).map {
      case Rule(field, firstValue, secondValue, thirdValue, fourthValue) =>
        val rule = (value: Int) =>
          (firstValue.toInt <= value && value <= secondValue.toInt) ||
            (thirdValue.toInt <= value && value <= fourthValue.toInt)
        field -> rule
    }.to(HashMap)

    val ticket = splitNotes(1).last.split(",").map(_.toInt).to(ArraySeq)

    val nearbyTickets = splitNotes(2).tail.map(_.split(",").map(_.toInt).to(ArraySeq))

    (rules, ticket, nearbyTickets)
  }

  def getScanningErrorRate(rules: Map[String, Int => Boolean], tickets: Seq[IndexedSeq[Int]]): Int = {
    val globalRule = getGlobalRule(rules)
    tickets.flatten.filterNot(globalRule).sum
  }

  def findFields(rules: Map[String, Int => Boolean], ticket: IndexedSeq[Int], tickets: Seq[IndexedSeq[Int]], fieldCharacteristic: String): Long = {
    val filteredTickets = removeInvalidTicket(rules, tickets)
    val valuesByFields = (0 until rules.size).map(index => index -> filteredTickets.map(_ (index)).to(ArraySeq))

    val possibleIndices = rules.map { case (ruleName, rule) =>
      ruleName -> valuesByFields.collect { case (field, values) if values.forall(rule) => field }
    }.toList

    val indexByFields = possibleIndices.sortBy(_._2.length).foldLeft(Map.empty[String, Option[Int]]) { case (fieldIndices, (rule, possibleIndices)) =>
      fieldIndices + (rule -> possibleIndices.find(index => !fieldIndices.values.to(HashSet).contains(Some(index))))
    }

    indexByFields.view.filterKeys(_.startsWith(fieldCharacteristic)).values.flatten.map(ticket(_).toLong).product
  }

  private def removeInvalidTicket(rules: Map[String, Int => Boolean], tickets: Seq[IndexedSeq[Int]]): Seq[IndexedSeq[Int]] = {
    val globalRule = getGlobalRule(rules)
    tickets.filter(_.forall(globalRule))
  }

  private def getGlobalRule(rules: Map[String, Int => Boolean]): Int => Boolean = {
    rules.values.reduce { (firstRule, secondRule) =>
      (value: Int) => firstRule(value) || secondRule(value)
    }
  }

  def main(args: Array[String]): Unit = {
    val input = InputReader.readFile("src/main/resources/input-16")
    val (rules, ticket, nearbyTickets) = readNotes(input)

    val firstAnswer = getScanningErrorRate(rules, nearbyTickets)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = findFields(rules, ticket, nearbyTickets, "departure")
    println(s"Second answer is '$secondAnswer'")
  }

}
