package com.aoc.day1

import com.aoc.UnitSpec

import scala.collection.immutable.HashSet

class ExpenseReportSpec extends UnitSpec {

  "ExpenseReport" should "return the two entries that sum to 2020 and multiply them" in {
    // Given
    val expenseReport = HashSet(1721, 979, 366, 299, 675, 1456)

    // When
    val result = ExpenseReport.fixTwoValues(expenseReport)

    // Then
    result.value shouldBe 514579
  }

  "ExpenseReport" should "return the three entries that sum to 2020 and multiply them" in {
    // Given
    val expenseReport = HashSet(1721, 979, 366, 299, 675, 1456)

    // When
    val result = ExpenseReport.fixThreeValues(expenseReport)

    // Then
    result.value shouldBe 241861950
  }

}
