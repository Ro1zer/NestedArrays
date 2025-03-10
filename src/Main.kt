/**
 * 17.Помножити кожний елемент масиву С[i]m на суму елементів відповідного
 * рядка матриці A[i,j]m,n.
 */
fun initializeTwoDArray(): Array<IntArray> {
    println("Enter count of rows in this matrix:")
    val rows = readln().toInt()
    val twoDArray = Array(rows) { initializeArray() }

    return twoDArray
}

fun initializeArray(): IntArray {
    println("Enter count of columns:")
    val columns = readln().toInt()
    val array = IntArray(columns)

    println("Enter elements for this row:")
    for (i in array.indices) {
        array[i] = readln().toInt()
    }

    return array
}

fun main() {
    val twoDArray = initializeTwoDArray()
    println("Your matrix is: ${twoDArray.contentDeepToString()}")

    val simpleArray = initializeArray()
    println("Your input array is: ${simpleArray.joinToString()}")

    for(i in simpleArray.indices) {
        for(j in twoDArray.indices) {
            println("Result of ${simpleArray[i]} multiplied to sum of ${twoDArray[j].joinToString()} elements is : ${simpleArray[i] * twoDArray[j].sum()}")
        }
    }
}