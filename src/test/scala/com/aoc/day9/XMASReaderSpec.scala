package com.aoc.day9

import com.aoc.UnitSpec

import scala.collection.immutable.ArraySeq

class XMASReaderSpec extends UnitSpec {

  "XMASReader" should "find first number which is not a sum of any two of the 25 immediately previous numbers" in {
    // Given
    val code = ArraySeq(
      35L,
      20L,
      15L,
      25L,
      47L,
      40L,
      62L,
      55L,
      65L,
      95L,
      102L,
      117L,
      150L,
      182L,
      127L,
      219L,
      299L,
      277L,
      309L,
      576L
    )
    val preambleLength = 5

    // When
    val invalidNumber = XMASReader.findInvalidNumberWeakness(code, preambleLength)

    // Then
    invalidNumber shouldBe 127
  }

  it should "find encryption weakness" in {
    // Given
    val code = ArraySeq(
      35L,
      20L,
      15L,
      25L,
      47L,
      40L,
      62L,
      55L,
      65L,
      95L,
      102L,
      117L,
      150L,
      182L,
      127L,
      219L,
      299L,
      277L,
      309L,
      576L
    )
    val invalidNumber = 127

    // When
    val encryptionWeakness = XMASReader.findEncryptionWeakness(code, invalidNumber)

    // Then
    encryptionWeakness shouldBe 62
  }

}
