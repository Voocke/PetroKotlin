package functions
import kotlin.random.Random

fun main() {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"

    print("Введите сообщение: ")
    val message = readLine()!!.uppercase()

    print("Введите ключ: ")
    val key = readLine()!!.uppercase()

    print("Использовать типовую таблицу? (да/нет): ")
    val useDefault = readLine()!! == "да"

    val table = createTable(alphabet, useDefault)
    val extendedKey = extendKey(key, message.length)
    val encrypted = encrypt(message, extendedKey, table, alphabet)

    printResults(message, extendedKey, encrypted)
    printTable(table, alphabet)
}

fun createTable(alphabet: String, useDefault: Boolean): List<String> {
    val table = mutableListOf<String>()

    if (useDefault) {
        for (i in alphabet.indices) {
            var row = ""
            for (j in alphabet.indices) {
                val index = (j + i) % alphabet.length
                row += alphabet[index]
            }
            table.add(row)
        }
    } else {
        val chars = alphabet.toCharArray()
        for (i in chars.indices) {
            val randomIndex = Random.nextInt(chars.size)
            val temp = chars[i]
            chars[i] = chars[randomIndex]
            chars[randomIndex] = temp
        }
        val firstRow = String(chars)
        table.add(firstRow)

        val shifts = mutableListOf<Int>()
        (1 until alphabet.length).forEach { i ->
            var shift = Random.nextInt(1, alphabet.length)
            while (shifts.contains(shift)) {
                shift = Random.nextInt(1, alphabet.length)
            }
            shifts.add(shift)

            var row = ""
            for (j in firstRow.indices) {
                val index = (j + shift) % firstRow.length
                row += firstRow[index]
            }
            table.add(row)
        }
    }
    return table
}

fun extendKey(key: String, length: Int): String {
    var extendedKey = ""
    for (i in 0 until length) {
        extendedKey += key[i % key.length]
    }
    return extendedKey
}

fun encrypt(message: String, extendedKey: String, table: List<String>, alphabet: String): String {
    var encrypted = ""
    for (i in message.indices) {
        val rowIndex = alphabet.indexOf(extendedKey[i])
        val colIndex = alphabet.indexOf(message[i])
        encrypted += table[rowIndex][colIndex]
    }
    return encrypted
}

fun printResults(message: String, extendedKey: String, encrypted: String) {
    println("\nТекст:  $message")
    println("Ключ:   $extendedKey")
    println("Шифр:   $encrypted")
}

fun printTable(table: List<String>, alphabet: String) {
    println("\nТаблица Виженера:")
    print("   ")
    for (char in alphabet) {
        print("$char ")
    }
    println()

    for (i in table.indices) {
        print("${alphabet[i]} ")
        for (char in table[i]) {
            print("$char ")
        }
        println()
    }
}