package day02

import readInput
import java.lang.Exception

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

fun getSymbol(letter: String): Int {
    return when (letter) {
        "A", "X" -> 1 // Rock
        "B", "Y" -> 2 // Paper
        "C", "Z" -> 3 // Scissors
        else -> throw Exception("Not a valid Symbol")
    }
}

