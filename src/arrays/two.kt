package arrays

fun main() {
    val arr:Array<IntArray> = arrayOf(
        intArrayOf(5, 9, 6, 7, 2),
        intArrayOf(9, 8, 4, 5, 3),
        intArrayOf(6, 4, 3, 8, 7),
        intArrayOf(7, 5, 8, 4, 8),
        intArrayOf(2, 3, 7, 8, 1),
    )

    var isSymmetrical = true
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            print(arr[i][j].toString() + "\t")
            if (arr[i][j] != arr[j][i])
                isSymmetrical = false
        }
        print("\n")
    }
    print("Данный массив ${if (isSymmetrical) "является" 
    else "не является"} симметричным относительно главной диагонали")
}