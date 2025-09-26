package arrays

val numToChar = mapOf(
    21 to 'А', 13 to 'Б', 4 to 'В', 20 to 'Г', 22 to 'Д',
    1 to 'Е', 25 to 'Ё', 12 to 'Ж', 24 to 'З', 14 to 'И',
    2 to 'Й', 28 to 'К', 9 to 'Л', 23 to 'М', 3 to 'Н',
    29 to 'О', 6 to 'П', 16 to 'Р', 15 to 'С', 11 to 'Т',
    26 to 'У', 5 to 'Ф', 30 to 'Х', 27 to 'Ц', 8 to 'Ч',
    18 to 'Ш', 10 to 'Щ', 33 to 'Ь', 31 to 'Ы', 32 to 'Ъ',
    19 to 'Э', 7 to 'Ю', 17 to 'Я',
)
val charToNum = mapOf(
    'А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20, 'Д' to 22,
    'Е' to 1, 'Ё' to 25, 'Ж' to 12, 'З' to 24, 'И' to 14,
    'Й' to 2, 'К' to 28, 'Л' to 9, 'М' to 23, 'Н' to 3,
    'О' to 29, 'П' to 6, 'Р' to 16, 'С' to 15, 'Т' to 11,
    'У' to 26, 'Ф' to 5, 'Х' to 30, 'Ц' to 27, 'Ч' to 8,
    'Ш' to 18, 'Щ' to 10, 'Ь' to 33, 'Ы' to 31, 'Ъ' to 32,
    'Э' to 19, 'Ю' to 7, 'Я' to 17,
)
fun main() {
    val text = "СООБЩЕНИЕ".toCharArray()
    print("Введите ключевое слово: ")
    var keyWord = readln().uppercase().toCharArray()

    //сопоставление слов
    if (text.size > keyWord.size){
        for (i in 0 until text.size - keyWord.size)
        keyWord = keyWord.plus(keyWord[i])
    }
    else if (text.size < keyWord.size){
           keyWord.dropLast(keyWord.size - text.size)
    }

    var result = emptyArray<Char>()
    var stepNum: Int

    for (i in 0 until text.size){
        stepNum = charToNum[text[i]]!!
        stepNum += charToNum[keyWord[i]]!!
        result += numToChar[stepNum%33]!!
    }

    result.forEach { print(it) }



}