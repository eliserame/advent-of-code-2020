package com.aoc.day13

import com.aoc.UnitSpec

class ShuttleBusServiceSpec extends UnitSpec {

  "ShuttleBusService" should "return ID of the next bus multiplied by number of minutes to wait" in {
    // Given
    val notes = List(
      "939",
      "7,13,x,x,59,x,31,19"
    )

    // When
    val result = ShuttleBusService.findEarliestBus(notes)

    // Then
    result shouldBe 295
  }

  it should "return timestamp corresponding to contest conditions with buses '17,x,13,19'" in {
    // Given
    val buses = List("17,x,13,19")

    // When
    val timestamp = ShuttleBusService.findTimestampForContest(buses)

    // Then
    timestamp shouldBe 3417
  }

  it should "return timestamp corresponding to contest conditions with buses '67,7,59,61'" in {
    // Given
    val buses = List("67,7,59,61")

    // When
    val timestamp = ShuttleBusService.findTimestampForContest(buses)

    // Then
    timestamp shouldBe 754018
  }

  it should "return timestamp corresponding to contest conditions with buses '67,x,7,59,61'" in {
    // Given
    val buses = List("67,x,7,59,61")

    // When
    val timestamp = ShuttleBusService.findTimestampForContest(buses)

    // Then
    timestamp shouldBe 779210
  }

  it should "return timestamp corresponding to contest conditions with buses '67,7,x,59,61'" in {
    // Given
    val buses = List("67,7,x,59,61")

    // When
    val timestamp = ShuttleBusService.findTimestampForContest(buses)

    // Then
    timestamp shouldBe 1261476
  }

  it should "return timestamp corresponding to contest conditions with buses '1789,37,47,1889'" in {
    // Given
    val buses = List("1789,37,47,1889")

    // When
    val timestamp = ShuttleBusService.findTimestampForContest(buses)

    // Then
    timestamp shouldBe 1202161486
  }

  it should "return timestamp corresponding to contest conditions with buses '7,13,x,x,59,x,31,19'" in {
    // Given
    val buses = List("7,13,x,x,59,x,31,19")

    // When
    val timestamp = ShuttleBusService.findTimestampForContest(buses)

    // Then
    timestamp shouldBe 1068781
  }

}
