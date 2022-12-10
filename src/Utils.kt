import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

private fun getLocation(name: String): String {
    return "/" + name.replace("_test", "").lowercase()
}

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String): List<String> {
    return File("src${getLocation(name)}", "$name.txt").readLines()
}

fun readInputAsString(name: String): String {
    return File("src${getLocation(name)}", "$name.txt").readText()
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
        .toString(16)
        .padStart(32, '0')
