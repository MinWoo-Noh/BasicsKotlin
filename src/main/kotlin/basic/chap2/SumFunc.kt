package basic.chap2

fun sum(a: Int, b: Int = 5) = a + b // Top-level 함수

fun max(a : Int, b : Int) = if (a > b) a else b

fun outFunc(name : String) = println("Name $name");

fun main() { // Top-level 함수
    val result1 = sum(2,3)

    val a = 3
    val b = 5

    val result2 = max(a, b)

    val result3 = sum(3)
    outFunc("kildong")
    println(result1)
    println(result2)
    println(result3)

}