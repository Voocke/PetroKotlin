package functions

import kotlin.random.Random

val items = mapOf(1 to "камень", 2 to "ножницы", 3 to "бумага")
fun main() {
    println("===Камень-Ножницы-Бумага===")
    game()
}

fun game() {
    val pcChoice = Random.Default.nextInt(1,3)
    print("\n1 - это камень, 2 - ножницы, 3 - бумага\nВыбор: ")
    val personChoice = readln().toInt()
    if (0 < personChoice && personChoice < 4)
        println(isWin(pcChoice, personChoice))
    else game()
    playAgain()
}
//1 - это камень, 2 - ножницы, 3 - бумага
fun isWin(pcChoice : Int, personChoice : Int) : String {
    println("\nВыбор компьютера: ${items[pcChoice]}\nВаш выбор: ${items[personChoice]}\n")
    return if (pcChoice == personChoice)
        "Ничья"
    else{
        if (pcChoice == 1 && personChoice == 2)
            "Вы проиграли"
        else if (pcChoice == 2 && personChoice == 3)
            "Вы проиграли"
        else if (pcChoice == 3 && personChoice == 1)
            "Вы проиграли"
        else
            "Вы выиграли"
    }
}

fun playAgain() {
    println("Сыграть снова?\n1. Да\n2. Закончить")
    val choice = readln().toInt()
    when (choice) {
        1 -> game()
        2 -> return
        else -> playAgain()
    }
}
