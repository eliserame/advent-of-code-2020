package com.aoc.day15

import com.aoc.UnitSpec

class MemoryGameSpec extends UnitSpec {

  "MemoryGame" should "return 2020th number spoken given '0,3,6'" in {
    // Given
    val startingNumbers = Vector(0, 3, 6)
    val lastTurn = 2020

    // When
    val number = MemoryGame.play(startingNumbers, lastTurn)

    // Then
    number shouldBe 436
  }

  it should "return 2020th number spoken given '1,3,2'" in {
    // Given
    val startingNumbers = Vector(1, 3, 2)
    val lastTurn = 2020

    // When
    val number = MemoryGame.play(startingNumbers, lastTurn)

    // Then
    number shouldBe 1
  }

  it should "return 2020th number spoken given '2,1,3'" in {
    // Given
    val startingNumbers = Vector(2, 1, 3)

    val lastTurn = 2020
    val number = MemoryGame.play(startingNumbers, lastTurn)

    // Then
    number shouldBe 10
  }

  it should "return 2020th number spoken given '1,2,3'" in {
    // Given
    val startingNumbers = Vector(1, 2, 3)
    val lastTurn = 2020

    // When
    val number = MemoryGame.play(startingNumbers, lastTurn)

    // Then
    number shouldBe 27
  }

  it should "return 2020th number spoken given '2,3,1'" in {
    // Given
    val startingNumbers = Vector(2, 3, 1)
    val lastTurn = 2020

    // When
    val number = MemoryGame.play(startingNumbers, lastTurn)

    // Then
    number shouldBe 78
  }

  it should "return 2020th number spoken given '3,2,1'" in {
    // Given
    val startingNumbers = Vector(3, 2, 1)
    val lastTurn = 2020

    // When
    val number = MemoryGame.play(startingNumbers, lastTurn)

    // Then
    number shouldBe 438
  }

  it should "return 2020th number spoken given '3,1,2'" in {
    // Given
    val startingNumbers = Vector(3, 1, 2)
    val lastTurn = 2020

    // When
    val number = MemoryGame.play(startingNumbers, lastTurn)

    // Then
    number shouldBe 1836
  }

  it should "return 30000000th number spoken given '0,3,6'" in {
    // Given
    val startingNumbers = Vector(0, 3, 6)
    val lastTurn = 30000000

    // When
    val number = MemoryGame.play(startingNumbers, lastTurn)

    // Then
    number shouldBe 175594
  }
}
