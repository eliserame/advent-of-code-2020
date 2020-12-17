package com.aoc.day16

import com.aoc.UnitSpec

class TicketCheckerSpec extends UnitSpec {

  "TicketChecker" should "return rules, ticket and nearby tickets" in {
    // Given
    val notes =
      """class: 1-3 or 5-7
        |row: 6-11 or 33-44
        |seat: 13-40 or 45-50
        |
        |your ticket:
        |7,1,14
        |
        |nearby tickets:
        |7,3,47
        |40,4,50
        |55,2,20
        |38,6,12""".stripMargin

    // When
    val (rules, ticket, nearbyTickets) = TicketChecker.readNotes(notes)

    // Then
    rules should have size 3
    rules("class")(3) shouldBe true
    rules("class")(42) shouldBe false
    rules("row")(3) shouldBe false
    rules("row")(42) shouldBe true
    rules("seat")(13) shouldBe true
    rules("seat")(42) shouldBe false

    ticket shouldBe List(7, 1, 14)

    nearbyTickets shouldBe List(
      List(7, 3, 47),
      List(40, 4, 50),
      List(55, 2, 20),
      List(38, 6, 12)
    )
  }

  it should "return scanning error rate" in {
    // Given
    val (rules, _, nearbyTickets) = TicketChecker.readNotes(
      """class: 1-3 or 5-7
        |row: 6-11 or 33-44
        |seat: 13-40 or 45-50
        |
        |your ticket:
        |7,1,14
        |
        |nearby tickets:
        |7,3,47
        |40,4,50
        |55,2,20
        |38,6,12""".stripMargin)

    // When
    val scanningErrorRate = TicketChecker.getScanningErrorRate(rules, nearbyTickets)

    // Then
    scanningErrorRate shouldBe 71
  }

  it should "product of values on ticket corresponding to fields matching characteristic" in {
    // Given
    val (rules, ticket, nearbyTickets) = TicketChecker.readNotes(
      """class: 0-1 or 4-19
        |row: 0-5 or 8-19
        |seat: 0-13 or 16-19
        |
        |your ticket:
        |11,12,13
        |
        |nearby tickets:
        |3,9,18
        |15,1,5
        |5,14,9""".stripMargin)
    val characteristic = "seat"

    // When
    val result = TicketChecker.findFields(rules, ticket, nearbyTickets, characteristic)

    // Then
    result shouldBe 13
  }

}
