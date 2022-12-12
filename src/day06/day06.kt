package day06

import readInputAsString

fun main() {
    fun part1(input: String, windowSize: Int): Int {
        input.windowed(windowSize, 1).forEachIndexed { index, window ->
            if (window.toCharArray().distinct().size == windowSize) {
                return index + windowSize
            }
        }
        throw Exception("No distinct code found")
    }

    fun part2(input: String): Int {
        return input.length
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsString("Day06_test")
    check(part1(testInput, 4) == 7)

    val input = readInputAsString("Day06")
    println(part1(input, 4))
//    println(part2(input))
}
