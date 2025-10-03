package bases

fun main() {
    print("Введите число: ")
    val num = readln().toInt()
    val binary = num.toString(2)
    println("$num в двоичной системе = $binary")
}