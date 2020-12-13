package com.aoc.day12

case class Waypoint(east: Int, north: Int) {

  def update(action: Char, value: Int): Waypoint = action match {
    case 'N' => this.copy(north = north + value)
    case 'S' => this.copy(north = north - value)
    case 'E' => this.copy(east = east + value)
    case 'W' => this.copy(east = east - value)
    case 'L' => this.rotate(value)
    case 'R' => this.rotate(-value)
  }

  private def rotate(value: Int): Waypoint = {
    val angle = Math.toRadians(value)
    val newEast = (east * Math.cos(angle) - north * Math.sin(angle)).round.toInt
    val newNorth = (east * Math.sin(angle) + north * Math.cos(angle)).round.toInt

    Waypoint(newEast, newNorth)
  }

}
