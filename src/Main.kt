
fun initializeArray(columns: Int): IntArray {
    val array = IntArray(columns)
    for (i in array.indices) {
        println("Enter ${i+1} element: ")
        array[i] = readln().toInt()
    }
    return array
}
fun displayInvalidSize() = println("Error, the value can't be les or equal 0")

fun setup() : Boolean {
    println("Enter count of rows")
    val twoDArrayRows = readln().toInt()
    println("Enter count of columns")
    val twoDArrayColumns = readln().toInt()
    if(twoDArrayRows <= 0 || twoDArrayColumns <=0) {
        displayInvalidSize()
        return false
    }
    val twoDArray= Array(twoDArrayRows) {
        println("Fill ${it+1} row")
        initializeArray(twoDArrayColumns)
    }

    println("Enter size your simple array: ")
    val simpleArraySize = readln().toInt()
    if(simpleArraySize <=0) {
        displayInvalidSize()
        return false
    }
    val simpleArray = initializeArray(simpleArraySize)

    println("Select row, that you want to multiply: ")
    val selectedRow = readln().toInt() - 1
    if(selectedRow !in 0..twoDArrayRows - 1) {
        println("Error, matrix don't have row as: $selectedRow")
        return false
    }

    println("Your matrix is: ${twoDArray.contentDeepToString()}")
    println("Your input array is: ${simpleArray.joinToString()}")
    for(i in simpleArray.indices) {
        println("Result of multiplying ${simpleArray[i]} to sum of ${twoDArray[selectedRow].joinToString()} is : ${simpleArray[i] * twoDArray[selectedRow].sum()}")
    }
    return true
}

fun main() {
    if(!setup()) {
        main()
    }
}