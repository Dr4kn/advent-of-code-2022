package day03

import readInput
import java.lang.Exception

fun main() {
    fun getDuplicateItem(backpack: String): Char {
        val firstCompartment = backpack
                .toCharArray(0, backpack.length / 2)
                .distinct()
        val secondCompartment = backpack
                .toCharArray(backpack.length / 2, backpack.length)
                .distinct()

        for (first in firstCompartment) {
            for (second in secondCompartment) {
                if (first == second) return first
            }
        }
        throw Exception("No match found")
    }

    fun getItemPriority(priority: Char): Int {
        return if (priority.isLowerCase()) {
            priority.minus('`')
        } else {
            priority.minus('@') + 26
        }
    }

    fun part1(input: List<String>): Int {
        var sum = 0

        input.forEach {
            val duplicate = getDuplicateItem(it)
            sum += getItemPriority(duplicate)
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println(part1(input))
//    println(part2(input))
}
