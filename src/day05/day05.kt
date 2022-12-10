import java.lang.NumberFormatException

fun main() {
    fun numberOfStacks(input: List<String>): Int {
        input.forEach { string ->
            if (string[1].isDigit()) {
                return (string.length / 4) + 1
            }
        }
        return 0
    }

    fun parseInput(input: List<String>) {
        print(numberOfStacks(input))
    }

    fun part1(input: List<String>): String {
        // cargo
        // cargoCrane
        parseInput(input)
        return "CMZ"
    }

    fun part2(input: List<String>): String {
        return "CMZ"
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")

    val input = readInput("Day05")
//    println(part1(input))
//    println(part2(input))
}
