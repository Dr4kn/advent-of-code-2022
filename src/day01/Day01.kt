package day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var maxValue = 0
        var currentValue = 0

        input.forEach { value ->
            if (value == "") {
                if (currentValue > maxValue) {
                    maxValue = currentValue
                }
                currentValue = 0
            } else {
                currentValue += value.toInt()
            }
        }
        return maxValue
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
