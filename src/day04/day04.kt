package day04

import readInput

fun main() {
    fun findFullyContained(sections: Array<Int>): Int {
        // the sections of the first elf fully contain the second one
        if (sections[0] <= sections[2]) {
            if (sections[1] >= sections[3]) {
                return 1
            }
        }
        // the second one fully contains the first
        if (sections[2] <= sections[0]) {
            if (sections[3] >= sections[1]) {
                return 1
            }
        }

        return 0
    }

    fun part1(input: List<String>): Int {
        var sum = 0

        input.forEach { sections ->
            sum += findFullyContained(sections
                    .split(',', '-')
                    .map { section ->
                        section.toInt()
                    }
                    .toTypedArray()
            )
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    println(part1(input))
//    println(part2(input))
}
