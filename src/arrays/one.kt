package arrays

fun main() {
    print("Введите количество строк: ")
    val lines = readln().toInt()
    print("Введите количество столбцов: ")
    val columns = readln().toInt()
    val matrix = Array(columns) { IntArray(lines) {0} }

    val digits = emptySet<Char>().toMutableSet()

    for (i in 0 until columns) {
        for (j in 0 until lines) {
            matrix[i][j] = (100..999).random()
            digits += matrix[i][j].toString().toSet()
            print(matrix[i][j].toString() + "\t")
        }
        print("\n")
    }
    println("В массиве использовано ${digits.count()} различных цифр")
}

