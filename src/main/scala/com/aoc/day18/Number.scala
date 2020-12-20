package com.aoc.day18

case class Number(value: Long) {

  def |+|(right: Number): Number = {
    Number(this.value + right.value)
  }

  def |*|(right: Number): Number = {
    Number(this.value * right.value)
  }

  def product(right: Number): Number =
    Number(this.value * right.value)

}


