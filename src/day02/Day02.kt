package day02

import readInput
import java.lang.Exception

fun main() {
    fun convertToValue(letter: String): Int {
        return when (letter) {
            "A", "X" -> 1 // Rock
            "B", "Y" -> 2 // Paper
            "C", "Z" -> 3 // Scissors
            else -> throw Exception("Not a valid Symbol")
        }
    }

    fun scoring(elf: Int, you: Int): Int {
        if (you == elf) {
            return you + 3
        }

        if (you == 1 && elf == 3) {
            return you + 6
        }

        if (you == 2 && elf == 1) {
            return you + 6
        }

        if (you == 3 && elf == 2) {
            return you + 6
        }

        return you
    }

    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach {
            val players = it.split(" ")

            sum += scoring(convertToValue(players[0]), convertToValue(players[1]))
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println(part1(input))
//    println(part2(input))
}

