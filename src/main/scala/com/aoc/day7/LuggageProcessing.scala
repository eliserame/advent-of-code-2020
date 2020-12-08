package com.aoc.day7

import com.aoc.InputReader

import scala.annotation.tailrec
import scala.collection.immutable.{HashMap, HashSet, LinearSeq}

object LuggageProcessing {

  private val EmptyBag = """contain no other bags""".r.unanchored
  private val FullBag = """(.*) bags contain (.*)\.""".r

  def countOutermostBags(rules: Iterable[String], colour: String): Int = {
    val innerBag = """\d+ (.*?) bags?,?""".r

    val outerBagsByColour = rules.foldLeft(HashMap.empty[String, HashSet[String]]) {
      case (bags, rule) => rule match {
        case EmptyBag() => bags
        case FullBag(outerBag, content) =>
          innerBag.findAllMatchIn(content).flatMap(_.subgroups).foldLeft(bags) { case (currentBags, bag) =>
            currentBags + (bag -> (currentBags.getOrElse(bag, HashSet.empty[String]) + outerBag))
          }
      }
    }

    @tailrec
    def searchOutermostBags(innerBags: LinearSeq[String], outermostBags: Set[String]): Set[String] = {
      if (innerBags.isEmpty) outermostBags
      else {
        val bag = innerBags.head
        val newOutermostBags = outerBagsByColour.getOrElse(bag, HashSet.empty[String]) -- outermostBags
        searchOutermostBags(innerBags.tail ++ newOutermostBags, outermostBags ++ newOutermostBags)
      }
    }

    searchOutermostBags(List(colour), HashSet.empty[String]).size
  }

  def countInnerBags(rules: Iterable[String], colour: String): Int = {
    val innerBag = """(\d+?) (.*?) bags?,?""".r

    val innerBagsByColour = rules.foldLeft(HashMap.empty[String, List[(String, Int)]]) {
      case (bags, rule) => rule match {
        case EmptyBag() => bags
        case FullBag(outerBag, content) =>
          val innerBags = innerBag.findAllMatchIn(content).foldLeft(List.empty[(String, Int)]) { case (bags, bagDescription) =>
            (bagDescription.group(2) -> bagDescription.group(1).toInt) +: bags
          }
          bags + (outerBag -> innerBags)
      }
    }

    @tailrec
    def searchInnerBags(outerBags: LinearSeq[(String, Int)], innerBags: LinearSeq[(String, Int)]): LinearSeq[(String, Int)] = {
      if (outerBags.isEmpty) innerBags
      else {
        val (outerBag, numberOfOuterBag) = outerBags.head
        val newInnerBags = innerBagsByColour.getOrElse(outerBag, Nil).map { case (bag, number) => bag -> numberOfOuterBag * number }
        searchInnerBags(outerBags.tail ++ newInnerBags, (outerBag, numberOfOuterBag) +: innerBags)
      }
    }

    searchInnerBags(List((colour, 1)), Nil).map(_._2).sum - 1
  }


  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-7")

    val firstAnswer = countOutermostBags(input, "shiny gold")
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = countInnerBags(input, "shiny gold")
    println(s"Second answer is '$secondAnswer'")
  }

}
