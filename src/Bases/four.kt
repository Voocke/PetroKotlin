package Bases

fun main() {
    print("Введите число x: ")
    val x = readln().toDouble()
    print("Введите число y: ")
    val y = readln().toDouble()
    print("Введите символ операции (Символами операции могут быть:" +
            " / — деление, * — умножение, + — сложение, - — вычитание): ")
    val symbol = readlnOrNull()
    var result = 0.0
    when (symbol){
        "/" -> result = x / y
        "*" -> result = x * y
        "+" -> result = x + y
        "-" -> result = x - y
        else -> print("Некорректный ввод")
    }
    print("Пример $x $symbol $y равен: $result")
}
