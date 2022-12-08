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

    fun findBadge(backpacks: Array<List<Char>>): Char {
        for (badge1 in backpacks[0]) {
            for (badge2 in backpacks[1]) {
                if (badge1 != badge2) continue

                for (badge3 in backpacks[2]) {
                    if (badge1 == badge3) {
                        return badge1
                    }
                }
            }
        }
        throw Exception("There is no common badge")
    }

    fun part2(input: List<String>): Int {
        val group = arrayOf(listOf(' '), listOf(' '), listOf(' '))
        var sum = 0

        input.forEachIndexed { index, backpack ->
            val distinctBackpack: List<Char> = backpack.toCharArray().distinct()
            group[index % 3] = distinctBackpack


            if (index % 3 == 2) {
                sum += getItemPriority(findBadge(group))
            }
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
