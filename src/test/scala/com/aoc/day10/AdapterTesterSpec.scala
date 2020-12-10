package com.aoc.day10

import com.aoc.UnitSpec

class AdapterTesterSpec extends UnitSpec {

  "AdapterTester" should "return product of 1 jolt and 3 jolt differences when we use all adapters" in {
    // Given
    val adapters = Vector(
      0,
      28,
      33,
      18,
      42,
      31,
      14,
      46,
      20,
      48,
      47,
      24,
      23,
      49,
      45,
      19,
      38,
      39,
      11,
      1,
      32,
      25,
      35,
      8,
      17,
      7,
      9,
      4,
      2,
      34,
      10,
      3
    ).sorted

    // When
    val product = AdapterTester.useAllAdapters(adapters)

    // Then
    product shouldBe 220
  }

  it should "return number of distinct arrangements" in {
    // Given
    val adapters = Vector(
      0,
      28,
      33,
      18,
      42,
      31,
      14,
      46,
      20,
      48,
      47,
      24,
      23,
      49,
      45,
      19,
      38,
      39,
      11,
      1,
      32,
      25,
      35,
      8,
      17,
      7,
      9,
      4,
      2,
      34,
      10,
      3
    ).sorted

    // When
    val arrangements = AdapterTester.countArrangements(adapters)

    // Then
    arrangements shouldBe 19208
  }


}
