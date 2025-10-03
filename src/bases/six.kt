package bases

fun main () {
    print("Введите первую цифру: ")
    val x = readln()
    print("Введите вторую цифру: ")
    val y = readln()

    var num = x+y
    if (num.toInt() % 2 == 0){
        print(num)
        return
    }
    num = y+x
    if (num.toInt() % 2 == 0){
        print(num)
        return
    }
    else
        print("Создать число невозможно")

}