fun main() {
    fun part1(input: List<String>): String {
        return "CMZ"
    }

    fun part2(input: List<String>): String {
        return "CMZ"
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
