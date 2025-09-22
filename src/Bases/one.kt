package Bases

fun main(){
    print("Введите строку: ")
    val str = readlnOrNull() ?: "" //AAADSSSRRTTHAAAA

    var result = ""
    var count = 1

    for (i in 0 .. str.length - 1) { //A
        if (i == str.length-1){
            result += "${str[i]}" +
                    " ${if(count > 1) count else continue}"
            break
        }
        if (str[i] == str[i + 1])//A2
            count++
        else {
            result += "${str[i]}" +
                    " ${if(count > 1) count else continue}"
            count = 1
        }
    }
    println(result)
}

