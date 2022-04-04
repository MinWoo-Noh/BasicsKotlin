package chap5

fun main() {

    // 5-> 12345 -> 23451 -> 34512..

    do {
        println("Enter the number: ")
        val input = readLine()!!.toInt()

//        for (i in 0..(input - 1)){
        for (i in 0 until input){ // until 키워드는 -1 하는 효과가 있다.
            for (j in 0 until input){
                print((i+j)% input + 1)
            }
            println()
        }

    }while (input != 0)
}