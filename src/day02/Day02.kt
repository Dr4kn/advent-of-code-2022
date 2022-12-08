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
        if (you == elf) { // draw
            return you + 3
        }

        if (you == 1 && elf == 3) { // Rock defeats Scissors
            return you + 6
        }

        if (you == 2 && elf == 1) { // Paper defeats Rock
            return you + 6
        }

        if (you == 3 && elf == 2) { // Scissors defeats Paper
            return you + 6
        }

        return you // loss
    }

    fun decideValue(elf: Int, you: Int): Int {
        if (you == 1) { // loss
            return when (elf) {
                1 -> 3
                2 -> 1
                3 -> 2
                else -> throw Exception("Not a valid number")
            }
        }

        if (you == 2) { // draw
            return when (elf) {
                1 -> 1
                2 -> 2
                3 -> 3
                else -> throw Exception("Not a valid number")
            }
        }

        if (you == 3) { // win
            return when (elf) {
                1 -> 2
                2 -> 3
                3 -> 1
                else -> throw Exception("Not a valid number")
            }
        }

        throw Exception("Not a valid decision")
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
        var sum = 0
        input.forEach {
            val players = it.split(" ")
            val elf = convertToValue(players[0])
            val you = convertToValue(players[1])
            sum += scoring(elf, decideValue(elf, you))

        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

