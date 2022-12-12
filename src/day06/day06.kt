package day06

import readInputAsString

fun main() {
    fun findStarMarker(input: String, windowSize: Int): Int {
        input.windowed(windowSize, 1).forEachIndexed { index, window ->
            if (window.toCharArray().distinct().size == windowSize) {
                return index + windowSize
            }
        }
        throw Exception("No distinct code found")
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsString("Day06_test")
    check(findStarMarker(testInput, 4) == 7)
    check(findStarMarker(testInput, 14) == 19)

    val input = readInputAsString("Day06")
    println(findStarMarker(input, 4))
    println(findStarMarker(input, 14))
}
