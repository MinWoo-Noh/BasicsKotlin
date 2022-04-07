package basic.chap4

var global = 10

fun main() { // 최상위함수

    fun localFunc1(){ // 지역함수 선언
        println("localFunc1")
    }

    global = 15
    val local1 = 15

    println("globa $global")
    localFunc1() // 지역함수 사용
    userFunc() // 사용자함수 사용

    println("final - global : $global, local1 : $local1")
}

// 사용자가 만든 최상위 레벨의 함수 선언 (최상위레벨 함수는 내부적으로 static final 로 정의되 객체 생성없이 메모리 상에 존재할 수 있다.
fun userFunc() {
    global = 20
    val local1 = 20
    println("userFunc - global: $global, locall : $local1")
}