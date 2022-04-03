package chap4

fun main() {
    val num = 3
//    val str = num.strPlus("Kotlin") // 일반 표현법
    val str = num strPlus "Kotlin" // 중위 표현법

    println(str)
}

// Int 를 확장해서 strPlus() 함수가 하나 더 추가되었다.
infix fun Int.strPlus(x : String) : String { // infix 로 선언되므로 중위 함수
    return "$x version $this"
}