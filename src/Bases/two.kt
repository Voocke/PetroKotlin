package Bases

fun main() {
    print("Введите строку: ")
    var str = readlnOrNull() ?: "" //AASADDSS
    str = str.toCharArray().sorted().joinToString("")

    var result = ""
    var count = 0
    for (i in 0 .. str.length - 1) { //A
        for (j in 0 .. str.length - 1){ //A
            if (str[i] in result){
                break
            }
            else if (str[i] == str[j])
                count++
        }
        if (str[i] !in result) {
            result += "${str[i]} - $count\n"
            count = 0
        }
    }
    println(result)
}