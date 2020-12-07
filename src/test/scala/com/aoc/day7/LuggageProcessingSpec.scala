package com.aoc.day7

import com.aoc.UnitSpec

class LuggageProcessingSpec extends UnitSpec {

  "LuggageProcessing" should "count number of different colored bags that can contain at least one shiny gold bag" in {
    // Given
    val rules = List(
      "light red bags contain 1 bright white bag, 2 muted yellow bags.",
      "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
      "bright white bags contain 1 shiny gold bag.",
      "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
      "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
      "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
      "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
      "faded blue bags contain no other bags.",
      "dotted black bags contain no other bags."
    )
    val colour = "shiny gold"

    // When
    val result = LuggageProcessing.countOutermostBags(rules, colour)

    // Then
    result shouldBe 4
  }

  it should "count number of different colored bags that a shiny gold bag should contain" in {
    // Given
    val rules = List(
      "light red bags contain 1 bright white bag, 2 muted yellow bags.",
      "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
      "bright white bags contain 1 shiny gold bag.",
      "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
      "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
      "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
      "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
      "faded blue bags contain no other bags.",
      "dotted black bags contain no other bags."
    )
    val colour = "shiny gold"

    // When
    val result = LuggageProcessing.countInnerBags(rules, colour)

    // Then
    result shouldBe 32
  }

  it should "count number of different colored bags that a shiny gold bag should contain with different rules" in {
    // Given
    val rules = List(
      "shiny gold bags contain 2 dark red bags.",
      "dark red bags contain 2 dark orange bags.",
      "dark orange bags contain 2 dark yellow bags.",
      "dark yellow bags contain 2 dark green bags.",
      "dark green bags contain 2 dark blue bags.",
      "dark blue bags contain 2 dark violet bags.",
      "dark violet bags contain no other bags."
    )
    val colour = "shiny gold"

    // When
    val result = LuggageProcessing.countInnerBags(rules, colour)

    // Then
    result shouldBe 126
  }

}
