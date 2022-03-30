package chap3

fun highFunex(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
    return sum(a, b)
}

fun main() {
    val result = highFunex(1, 3) { x, y -> x + y }
    println(result)
}