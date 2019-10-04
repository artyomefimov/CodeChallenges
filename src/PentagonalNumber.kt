/**
 * https://coderbyte.com/editor/guest:Pentagonal%20Number:Java
 */

fun main() {
    println(pentagonalNumber(2))
    println(pentagonalNumber(3))
    println(pentagonalNumber(4))
    println(pentagonalNumber(5))
    println(pentagonalNumber(6))
}

private fun pentagonalNumber(iteration: Int): Int {
    if (iteration == 1) return 1
    return 5 + ((iteration - 2) * 5) + pentagonalNumber(iteration -1)
}