package day06

import readInputAsString

fun main() {
    fun part1(input: String): Int {
        return input.length
    }

    fun part2(input: String): Int {
        return input.length
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsString("Day06_test")
    check(part1(testInput) == 7)

    val input = readInputAsString("Day06")
    println(part1(input))
    println(part2(input))
}
