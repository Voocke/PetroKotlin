package bases

import kotlin.math.abs

fun main() {
    print("Введите число n: ")
    val n = readLine()?.toIntOrNull()

    print("Введите основание степени x: ")
    val x = readLine()?.toIntOrNull()

    if (n == null || x == null || x == 0 || x == 1 || x == -1) {
        println("Некорректный ввод или невозможно определить показатель.")
        return
    }

    var y = 0
    var result = 1
    val isNegativeN = n < 0
    val absN = abs(n)
    val absX = abs(x)

    while (result < absN) {
        result *= absX
        y++
    }

    if (result == absN) {
        if ((x < 0 && y % 2 == 1 && isNegativeN) || (x > 0 && !isNegativeN) || (x < 0 && !isNegativeN && y % 2 == 0)) {
            println("Результат: y = $y")
        } else {
            println("Целочисленный показатель не существует")
        }
    } else {
        println("Целочисленный показатель не существует")
    }
}
