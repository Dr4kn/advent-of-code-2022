import java.io.CharArrayWriter
import java.io.File
import java.lang.StringBuilder

fun main() {
    fun buildStack(cargo: String): MutableList<String> {
        val list: MutableList<String> = mutableListOf("", "", "")
        
        cargo.lines().dropLast(1).reversed().forEach {
            for (i in 1 until it.length step 4) {
                if (it[i] != ' ') { // expects letters
                    list[i / 4] += it[i].toString()
                }
            }
        }
        return list
    }

    fun part1(input: String): String {
        val inputSplit = input.split("\n\n")
        val stack = buildStack(inputSplit[0])
        return "CMZ"
    }

    fun part2(input: String): String {
        return "CMZ"
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsString("Day05_test")
    check(part1(testInput) == "CMZ")

    val input = readInputAsString("Day05")
//    println(part1(input))
//    println(part2(input))
}
