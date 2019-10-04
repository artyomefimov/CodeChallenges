import kotlin.text.StringBuilder

/**
 * Have the function AlphabetSoup(str) take the str string parameter being passed and return the string with the letters in alphabetical order (ie. hello becomes ehllo).
 * Assume numbers and punctuation symbols will not be included in the string.
 */

private val alphabet = HashMap<Char, Int>().apply {
    var letter = 'a'
    for (i in 1..26)
        put(letter++, i)
}

fun main() {
    println(makeASoup("hello"))
    println(makeASoup("coderbyte"))
    println(makeASoup("hooplah"))
    println(makeASoup("AlphabetSoup"))
}

private fun makeASoup(str: String): String {
    val charArray = str.toLowerCase().toCharArray()
    val alphabetIndexesOfInputStringLetters = mutableListOf<Int>().apply {
        charArray.forEach { letter -> this.add(alphabet[letter]!!) }
        sort()
    }

    val stringBuilder = StringBuilder()

    alphabetIndexesOfInputStringLetters.forEach { alphabetIndex ->
        stringBuilder.append(getLetterByAlphabetIndex(alphabetIndex))
    }

    return stringBuilder.toString()
}

private fun getLetterByAlphabetIndex(alphabetIndex: Int): Char =
        alphabet.filterValues { it == alphabetIndex }.keys.elementAt(0)