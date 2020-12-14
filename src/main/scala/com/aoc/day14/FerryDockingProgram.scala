package com.aoc.day14

import com.aoc.InputReader

import scala.annotation.tailrec
import scala.collection.immutable.{HashMap, LinearSeq}

object FerryDockingProgram {

  private val MaskInstruction = """mask = (.*)""".r
  private val MemoryInstruction = """mem\[(\d*)] = (\d*)""".r

  def initialize(program: LinearSeq[String]): BigInt = {
    val (memory, _) = program.foldLeft((HashMap.empty[BigInt, BigInt], (BigInt(0), BigInt(0)))) {
      case ((memory, (positionMask, valueMask)), instruction) =>
        instruction match {
          case MaskInstruction(newMask) =>
            val newPositionMask = BigInt(newMask.replaceAll("0", "1").replaceAll("X", "0"), 2)
            val newValueMask = BigInt(newMask.replaceAll("X", "0"), 2)
            (memory, (newPositionMask, newValueMask))
          case MemoryInstruction(address, value) =>
            val newMemory = memory.updated(BigInt(address), BigInt(value) & ~positionMask ^ valueMask & positionMask)
            (newMemory, (positionMask, valueMask))
        }
    }

    memory.values.sum
  }

  def initializeVersion2(program: LinearSeq[String]): BigInt = {
    val (memory, _) = program.foldLeft((HashMap.empty[BigInt, BigInt], "")) { case ((memory, mask), instruction) =>
      instruction match {
        case MaskInstruction(newMask) => (memory, newMask)
        case MemoryInstruction(address, value) =>
          val addresses = getAddresses(BigInt(address).toString(2), mask)
          val newMemory = addresses.foldLeft(memory) { case (currentMemory, address) => currentMemory.updated(address, BigInt(value)) }
          (newMemory, mask)
      }
    }

    memory.values.sum
  }

  private def getAddresses(address: String, mask: String): LinearSeq[BigInt] = {

    @tailrec
    def buildAddresses(addresses: LinearSeq[LinearSeq[Char]], bits: LinearSeq[(Char, Char)]): LinearSeq[LinearSeq[Char]] = {
      if (bits.isEmpty) addresses
      else {
        val newAddresses = bits.head match {
          case (bit, '0') => addresses.map(bit +: _)
          case (_, '1') => addresses.map('1' +: _)
          case _ => addresses.map('0' +: _) ++ addresses.map('1' +: _)
        }

        buildAddresses(newAddresses, bits.tail)
      }
    }

    val bits = (List.fill(mask.length - address.length)('0') ::: address.toList).zip(mask)
    val addresses = buildAddresses(List(Nil), bits)
    addresses.map(bits => BigInt(bits.mkString, 2))
  }


  def main(args: Array[String]): Unit = {
    val input = InputReader.readLines("src/main/resources/input-14").toList

    val firstAnswer = initialize(input)
    println(s"First answer is '$firstAnswer'")

    val secondAnswer = initializeVersion2(input)
    println(s"Second answer is '$secondAnswer'")
  }

}
