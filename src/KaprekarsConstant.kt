/**
 * https://coderbyte.com/editor/Kaprekars%20Constant:Java
 * Have the function KaprekarsConstant(num) take the num parameter being passed which will be a 4-digit number with at least two distinct digits.
 * Your program should perform the following routine on the number: Arrange the digits in descending order and in ascending order (adding zeroes to fit it to a 4-digit number),
 * and subtract the smaller number from the bigger number. Then repeat the previous step. Performing this routine will always cause you to reach a fixed number: 6174.
 * Then performing the routine on 6174 will always give you 6174 (7641 - 1467 = 6174). Your program should return the number of times this routine must be performed until 6174 is reached.
 * For example: if num is 3524 your program should return 3 because of the following steps:
 * (1) 5432 - 2345 = 3087, (2) 8730 - 0378 = 8352, (3) 8532 - 2358 = 6174.
 */

fun main() {
    println(kaprekarsConstant(3524))
    println(kaprekarsConstant(2111))
    println(kaprekarsConstant(9831))
}

private fun kaprekarsConstant(num: Int): Int {
    var result = num
    var count = 0
    while (result != 6174) {
        val descAndAsc = getDescendingAndAscendingNumbers(result)
        result = descAndAsc.first - descAndAsc.second
        count++
    }
    return count
}

private fun getDescendingAndAscendingNumbers(num: Int): Pair<Int, Int> {
    val digits = mutableListOf<Int>()
    num.toString().forEach {
        digits.add(it.toString().toInt())
    }

    if (digits.size < 4) {
        for (i in digits.size + 1..4) {
            digits.add(0)
        }
    }

    val sortedDescending = digits.sortedDescending().toString()
    val sortedAscending = digits.sorted().toString()

    return transformToInt(sortedDescending) to transformToInt(sortedAscending)
}

private fun transformToInt(string: String): Int {
    val digitsWithCommaAndSpace = removeBrackets(string)
    val sb = StringBuilder()

    digitsWithCommaAndSpace.split(", ").forEach {
        sb.append(it)
    }
    return sb.toString().toInt()
}

private fun removeBrackets(string: String): String = string.substring(1, string.length - 1)