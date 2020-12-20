package com.aoc.day18

import com.aoc.UnitSpec

class NumberSpec extends UnitSpec {

  "Number" should "be evaluated using operators with same precedence" in {
    // Given
    val a = Number(5)
    val b = Number(4)
    val c = Number(3)

    // When
    val result = a |+| b |*| c

    // Then
    result.value shouldBe 27
  }

  it should "respect parenthesis" in {
    // Given
    val a = Number(5)
    val b = Number(4)
    val c = Number(3)

    // When
    val result = a |*| (b |+| c)

    // Then
    result.value shouldBe 35
  }

}
