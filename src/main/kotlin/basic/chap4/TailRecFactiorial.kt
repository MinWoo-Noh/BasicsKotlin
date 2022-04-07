package basic.chap4

fun main() {
    val number = 5
    println("Factorial : $number -> ${factorial(number)}")
}

// 꼬리 재귀함수 (스텍오버플로우 바질)
tailrec fun factorial(n: Int, run: Int = 1): Long {
    return if (n == 1) run.toLong() else factorial(n - 1, run * n)
}