package com.aoc.day6

import com.aoc.UnitSpec

class CustomsDeclarationSpec extends UnitSpec {

  "CustomsDeclaration" should "return sum of counts of questions to which anyone answered yes by group" in {
    // Given
    val forms = List(
      "abc",
      """a
        |b
        |c""".stripMargin,
      """ab
        |ac""".stripMargin,
      """a
        |a
        |a
        |a""".stripMargin,
      "b"
    )

    // When
    val sum = CustomsDeclaration.sumAnyone(forms)

    // Then
    sum shouldBe 11
  }

  it should "return sum of counts of questions to which everyone answered yes by group" in {
    // Given
    val forms = List(
      "abc",
      """a
        |b
        |c""".stripMargin,
      """ab
        |ac""".stripMargin,
      """a
        |a
        |a
        |a""".stripMargin,
      "b"
    )

    // When
    val sum = CustomsDeclaration.sumEveryone(forms)

    // Then
    sum shouldBe 6
  }

}
