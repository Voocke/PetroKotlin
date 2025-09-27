package arrays
var firstArr = mutableListOf<Int>()
var secondArr = mutableListOf<Int>()
var whichArr = 0
var count = 0
fun main() {
    inputNums()

    var resultArr = emptyArray<Int>()

    val tempSecondArr = secondArr.toMutableList()

    for (i in firstArr.indices) {
        for (j in tempSecondArr.indices) {
            if (firstArr[i] == tempSecondArr[j]) {
                resultArr += firstArr[i]
                tempSecondArr.removeAt(j)
                break
            }
        }
    }
    resultArr = resultArr.sorted().toTypedArray()
    println("Пересечение: ${resultArr.contentToString()}")
}
fun inputNums() {
    if (count < 2)
    println("Введите числа для ${if (whichArr == 0) "первого" else "второго"}" +
            " массива (по 1 за раз, 'q' для прекращения ввода): ")
    while (true){
        if (count == 2){
            return
        }
        val input = readln().trim().lowercase()

        if (input == "q"){
            count++
            whichArr++
            inputNums()
        }
        else {
            if (whichArr == 0)
                firstArr += input.toIntOrNull()?: 0
            else if (whichArr == 1)
                secondArr += input.toIntOrNull()?: 0
        }
    }
}