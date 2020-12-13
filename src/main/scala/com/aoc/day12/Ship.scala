package com.aoc.day12

case class Ship(east: Int, north: Int, direction: Direction) {

  def update(action: Char, value: Int): Ship = action match {
    case 'N' => this.copy(north = north + value)
    case 'S' => this.copy(north = north - value)
    case 'E' => this.copy(east = east + value)
    case 'W' => this.copy(east = east - value)
    case 'L' => this.copy(direction = direction.update(value))
    case 'R' => this.copy(direction = direction.update(-value))
  }

  def update(waypoint: Waypoint, value: Int): Ship = {
    val newEast = east + waypoint.east * value
    val newNorth = north + waypoint.north * value

    this.copy(east = newEast, north = newNorth)
  }

}
