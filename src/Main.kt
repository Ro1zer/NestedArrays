/**
 * Помножити кожний елемент масиву С[i]m на суму елементів відповідного
 * рядка матриці A[i,j]m,n.
 */
fun initializeArray(size: Int): IntArray {
    val array = IntArray(size)
    for (i in array.indices) {
        println("Enter ${i + 1} element")
        array[i] = readln().toInt()
    }
    return array
}

fun setSize(): Int {
    val size = readln().toInt()
    return if (size <= 0) {
        println("Error, value can't be 0 or less, but was: $size")
        setSize()
    } else size
}

fun initializeTwoDArray(): Array<IntArray> {
    println("Enter count of rows")
    val twoDArrayRows = setSize()
    println("Enter count of columns")
    val twoDArrayColumns = setSize()
    return Array(twoDArrayRows) {
        println("Fill ${it + 1} row")
        initializeArray(twoDArrayColumns)
    }
}

fun initializeSimpleArray(): IntArray {
    println("Enter size of your array")
    return initializeArray(setSize())
}

fun isHasRow(twoDArray: Array<IntArray>): Int {
    println("Select row, that you want to multiply")
    for (i in twoDArray.indices) println("Row ${i + 1}: ${twoDArray[i].joinToString()}")
    val row = readln().toInt() - 1
    return if (row !in 0..twoDArray.size) {
        println("Error, matrix don't have row as $row")
        isHasRow(twoDArray)
    } else row
}

fun display(twoDArray: Array<IntArray>, simpleArray: IntArray, inputRow: Int) {
    println("Your matrix is: ${twoDArray.contentDeepToString()}")
    println("Your input array is: ${simpleArray.joinToString()}")
    for (i in simpleArray.indices) {
        println("Result of multiplying ${simpleArray[i]} to sum of ${twoDArray[inputRow].joinToString()} is: ${simpleArray[i] * twoDArray[inputRow].sum()}")
    }
}

fun main() {
    val twoDArray = initializeTwoDArray()
    val simpleArray = initializeSimpleArray()
    val inputRow = isHasRow(twoDArray)
    display(twoDArray, simpleArray, inputRow)
}