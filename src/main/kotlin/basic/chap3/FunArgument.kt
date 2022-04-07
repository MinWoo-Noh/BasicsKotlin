package basic.chap3

// 함수의 표현

// return 문이 1개 일 경우 반환 타입을({}는 = 으로 수정)생략 할 수 있다.
fun sum(a: Int, b: Int) = a + b

fun mul(a: Int, b: Int): Int {
    return a * b
}

// 함수의 반환타입이 함수????
fun funcFun(a: Int, b: Int) = sum(a, b)

fun main() {

    val result = sum(10, 10)
    val result2 = mul(sum(10, 5), 10) // 함수를 인자형태로 사용 ( 고차함수)
    val result3 = funcFun(2, 3)

    println("result: $result, result2: $result2, result3: $result3")
}