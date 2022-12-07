package day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var maxValue = 0
        var currentValue = 0

        input.forEachIndexed { index, value ->
            if (value != "") {
                currentValue += value.toInt()
            }

            if (value == "" || index == input.size - 1) {
                if (currentValue > maxValue) {
                    maxValue = currentValue
                }
                currentValue = 0
            }
        }
        return maxValue
    }

    fun part2(input: List<String>): Int {
        var currentValue = 0
        val topThree: IntArray = intArrayOf(0, 0, 0)

        input.forEachIndexed { index, value ->
            if (value != "") {
                currentValue += value.toInt()
            }

            if (value == "" || index == input.size - 1) {
                if (currentValue > topThree[0]) {
                    topThree[0] = currentValue
                    topThree.sort()
                }
                currentValue = 0
            }
        }
        return topThree.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)


    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
