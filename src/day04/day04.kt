package day04

import readInput

fun main() {
    fun stringToIntArray(sections: String): Array<Int> {
        return sections
                .split(',', '-')
                .map { section ->
                    section.toInt()
                }
                .toTypedArray()
    }

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
            sum += findFullyContained(stringToIntArray(sections))
        }
        return sum
    }

    fun findOverlap(sections: Array<Int>): Int {
        val start1 = sections[0]
        val end1 = sections[1]
        val start2 = sections[2]
        val end2 = sections[3]

        if (start1 < start2) {
            if (end1 >= start2) {
                return 1
            }
        }

        if (start2 < start1) {
            if (end2 >= start1) {
                return 1
            }
        }

        if (start1 == start2) {
            return 1
        }

        if (end1 == end2) {
            return 1
        }

        return 0
    }

    fun part2(input: List<String>): Int {
        var sum = 0

        input.forEach { sections ->
            sum += findOverlap(stringToIntArray(sections))
        }

        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
