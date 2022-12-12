package day05

import readInputAsString
import java.util.NoSuchElementException

fun main() {
    fun buildInstructionSet(instructions: String): List<List<Int>> {
        return instructions
                .replace("(move )|(from )|(to )".toRegex(), "")
                .lines().map {
                    it.split(" ").map { number ->
                        number.toInt() - 1
                    }
                }
    }


    fun buildStack(cargo: String): MutableList<MutableList<Char>> {
        val list: MutableList<MutableList<Char>> =
                MutableList(cargo.lines().max().length + 1) {
                    mutableListOf()
                }

        cargo.lines().dropLast(1).reversed().forEach {
            for (i in 1 until it.length step 4) {
                if (it[i] != ' ') { // expects letters
                    list[i / 4].add(it[i])
                }
            }
        }
        return list
    }

    fun getResult(stack: MutableList<MutableList<Char>>): String {
        var firstCrates = ""
        stack.forEach {
            try {
                firstCrates += it.last()
            } catch (e: NoSuchElementException) { // MutableArrays are at least of size 12
                return@forEach
            }
        }
        return firstCrates
    }


    fun part1(input: String): String {
        val inputSplit = input.split("\n\n")
        val stack = buildStack(inputSplit[0])
        val instructions = buildInstructionSet(inputSplit[1])

        instructions.forEach { list ->
            for (i in 0..list[0]) {
                stack[list[2]].add(stack[list[1]].last())
                stack[list[1]].removeLast()
            }
        }
        return getResult(stack)
    }

    fun part2(input: String): String {
        val inputSplit = input.split("\n\n")
        val stack = buildStack(inputSplit[0])
        val instructions = buildInstructionSet(inputSplit[1])

        instructions.forEach { list ->
            if (list[0] == 0) {
                stack[list[2]].add(stack[list[1]].last())
                stack[list[1]].removeLast()
            } else {
                for ((offset, i) in (stack[list[1]].size - list[0] - 1 until stack[list[1]].size).withIndex()) {
                    stack[list[2]].add(stack[list[1]][i - offset])
                    stack[list[1]].removeAt(i - offset)
                }
            }
        }
        return getResult(stack)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsString("Day05_test")
    check(part1(testInput) == "CMZ")

    val input = readInputAsString("Day05")
    println(part1(input))
    println(part2(input))
}
