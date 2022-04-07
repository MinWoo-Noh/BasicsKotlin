package basic.chap5

fun main() {
    val a = 17
    val b = 7

    val max = if (a > b) {
        println("a $a")
        a // true 일 경우 max 에 할당
    } else {
        println("b $b")
        b // false 일 경우 max 에 할당
    }
    println("max $max")
}