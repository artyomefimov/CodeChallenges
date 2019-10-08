/**
 * https://coderbyte.com/editor/guest:Eight%20Queens:Java
 * Have the function EightQueens(strArr) read strArr which will be an array consisting of the locations of eight Queens on a standard 8x8 chess board with no other pieces on the board.
 * The structure of strArr will be the following: ["(x,y)", "(x,y)", ...] where (x,y) represents the position of the current queen on the chessboard
 * (x and y will both range from 1 to 8 where 1,1 is the bottom-left of the chessboard and 8,8 is the top-right).
 * Your program should determine if all of the queens are placed in such a way where none of them are attacking each other.
 * If this is true for the given input, return the string true otherwise return the first queen in the list that is attacking another piece in the same format it was provided.
 * For example: if strArr is ["(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)", "(5,8)"] then your program should return the string true.
 */

fun main() {
    println(eightQueens(arrayOf("(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)", "(5,8)")))
    println(eightQueens(arrayOf("(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)", "(7,7)", "(5,8)")))
    println(eightQueens(arrayOf("(2,1)", "(5,3)", "(6,3)", "(8,4)", "(3,4)", "(1,8)", "(7,7)", "(5,8)")))
}

private fun eightQueens(inputArray: Array<String>): String {
    val queens = parseQueens(inputArray)
    var attackedQueens: List<Queen>
    queens.forEach { queen ->
        attackedQueens = queens.filter { areNotTheSame(it, queen) && (areOnTheSameHorizontal(it, queen) || areOnTheSameVertical(it, queen) || areOnTheSameDiagonal(it, queen)) }
        if (attackedQueens.isNotEmpty()) {
            return "(${queen.x},${queen.y})"
        }
    }
    return "true"
}

private fun parseQueens(inputArray: Array<String>): List<Queen> {
    val list = mutableListOf<Queen>()
    inputArray.forEach {
        list.add(Queen(
                it.substring(it.indexOf('(') + 1, it.indexOf(',')).toInt(),
                it.substring(it.indexOf(',') + 1, it.indexOf(')')).toInt()
        ))
    }
    return list
}

private fun areNotTheSame(queen1: Queen, queen2: Queen) = queen1 != queen2

private fun areOnTheSameHorizontal(queen1: Queen, queen2: Queen) = queen1.x == queen2.x

private fun areOnTheSameVertical(queen1: Queen, queen2: Queen) = queen1.y == queen2.y

private fun areOnTheSameDiagonal(queen1: Queen, queen2: Queen) = (queen1.x - queen1.y) == (queen2.x - queen2.y)

private data class Queen(val x: Int, val y: Int)