package arrays

var mainWordsArr = emptyArray<String>()
var tempWordsList: MutableList<String> = mutableListOf()
var charArr: List<Char> = emptyList()
var resultArr = emptyArray<String>()

fun main() {
    println("1. Использовать заготовленный массив\n2. Ввести свой")
    val choice = readln().toIntOrNull()?: 1
    if (choice == 1) {
        mainWordsArr = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
        check()
    }
    else if (choice == 2) {
        inputWords()
        check()
    }
}

fun inputWords() {
    print("Введите слова в массив ('q' для выхода): ")
    while (true){
        val input = readln().trim().lowercase()
        if (input == "q"){
            return
        }
        else
            mainWordsArr += input
    }
}

fun check() {
    tempWordsList = mainWordsArr.toMutableList()

    for (i in mainWordsArr.indices){
        charArr = mainWordsArr[i].toCharArray().sorted()
        resultArr = emptyArray()
        for (j in tempWordsList.indices){
            if (tempWordsList[j].toCharArray().sorted() == charArr){
                resultArr += tempWordsList[j]
            }
        }
        tempWordsList = tempWordsList.minus(resultArr).toMutableList()
        if (!resultArr.isEmpty())
            println(resultArr.contentToString())
    }
}