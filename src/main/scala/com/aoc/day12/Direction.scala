package com.aoc.day12

trait Direction {

  def charValue: Char

  protected def degrees: Int

  def update(value: Int): Direction = Direction(degrees + value)

}

case object East extends Direction {

  val charValue = 'E'

  protected val degrees = 0

}

case object North extends Direction {

  val charValue = 'N'

  protected val degrees = 90

}

case object West extends Direction {

  val charValue = 'W'

  protected val degrees = 180

}

case object South extends Direction {

  val charValue = 'S'

  protected val degrees = 270

}

object Direction {

  def apply(degrees: Int): Direction = degrees % 360 match {
    case 0 => East
    case 90 | -270 => North
    case 180 | -180 => West
    case 270 | -90 => South
  }

}
