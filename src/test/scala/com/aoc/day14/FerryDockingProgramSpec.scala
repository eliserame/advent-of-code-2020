package com.aoc.day14

import com.aoc.UnitSpec

class FerryDockingProgramSpec extends UnitSpec {

  "FerryDockingProgram" should "return sum of values in memory after its initialisation" in {
    // Given
    val program = List(
      "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
      "mem[8] = 11",
      "mem[7] = 101",
      "mem[8] = 0"
    )

    // When
    val sum = FerryDockingProgram.initialize(program)

    // Then
    sum shouldBe 165
  }

  it should "return sum of values in memory after its version 2 initialisation" in {
    // Given
    val program = List(
      "mask = 000000000000000000000000000000X1001X",
      "mem[42] = 100",
      "mask = 00000000000000000000000000000000X0XX",
      "mem[26] = 1"
    )

    // When
    val sum = FerryDockingProgram.initializeVersion2(program)

    // Then
    sum shouldBe 208
  }

}
