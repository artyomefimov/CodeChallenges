/**
 * https://coderbyte.com/editor/guest:Maximal%20Square:Java
 * Have the function MaximalSquare(strArr) take the strArr parameter being passed which will be a 2D matrix of 0 and 1's,
 * and determine the area of the largest square submatrix that contains all 1's.
 * A square submatrix is one of equal width and height,
 * and your program should return the area of the largest submatrix that contains only 1's.
 */

// todo попробовать способ с регуляркой
fun main() {
    square(arrayOf("0111", "1111", "1111", "1111"))
}

private fun square(inputArray: Array<String>) {
    val list = processRows(inputArray)
    println(list) // todo список со списками позиций единиц в каждой строке
}

private fun processRows(inputArray: Array<String>): List<List<Int>> {
    val list = mutableListOf<List<Int>>()
    inputArray.forEach { row ->
        val oneIndexes = mutableListOf<Int>()
        row.toCharArray().forEachIndexed { charIndex, char ->
            if (char == '1')
                oneIndexes.add(charIndex)
        }
        list.add(oneIndexes)
    }
    return list
}

//private fun maximalSquare(inputArray: Array<String>): Int {
//    if (inputArray.isEmpty()) return 0
//
//    var rows = HashMap<Int, List<String>>()
//    inputArray.forEachIndexed { rowNumber, row ->
//        val sequentialIndexes = mutableListOf<Int>()
//
//        countSequentialOnes(row, sequentialIndexes)
//
//        if (sequentialIndexes.size == 1) {
//            rows[1] = listOf(row)
//            return@forEachIndexed
//        }
//
//        var isMatches: Boolean
//        val matchedNeighbours = mutableListOf<String>()
//        inputArray.forEachIndexed { i, neighbour ->
//            isMatches = true
//            sequentialIndexes.forEach { index ->
//                if ((neighbour.elementAt(index) != '1') and ((i == rowNumber + 1) or (i == rowNumber - 1))) {
//                    isMatches = false
//                }
//            }
//            if (isMatches) matchedNeighbours.add(neighbour)
//        }
//    }
//    return 0
//}
//
//private fun countSequentialOnes(row: String, indexes: MutableList<Int>) {
//    for (i in 0 until row.length)
//        if (row.elementAt(i) == '1')
//            indexes.add(i)
//        else
//            indexes.clear()
//}
//
//private fun getNeighboursOfCurrentRow(rowNumber: Int, inputArray: Array<String>): MutableList<String> {
//    return mutableListOf<String>().apply {
//        when (rowNumber) {
//            0 -> add(inputArray[rowNumber + 1])
//            inputArray.size - 1 -> add(inputArray[rowNumber - 1])
//            else -> {
//                add(inputArray[rowNumber + 1])
//                add(inputArray[rowNumber - 1])
//            }
//        }
//    }
//}