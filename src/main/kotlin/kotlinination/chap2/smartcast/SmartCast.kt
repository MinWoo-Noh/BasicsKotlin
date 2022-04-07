package kotlinination.chap2

import java.lang.IllegalArgumentException

// 2.3.5 스마트 캐스트 : 타입 검사와 캐스트를 조합
// (1+2)+4 간단한 산술식을 계산하는 함수를 만들어보자

interface Expr

// value 라는 프로퍼티만 존재하는 단순한 클래스로 Expr 인터페이스를 구현한다.
class Num(val value: Int) : Expr

// Expr 타입의 객체라면 어떤 것이나 sum 연산의 인자가 될 수 있다. 따라서 Num 이나
// 다른 Sum 이 인자로 올 수 없다.
class Sum(val left: Expr, val right: Expr) : Expr

// Expr interface 에는 두 가지 구현 클래스가 존재한다. 따라서 두가지의 경우를 고려해야 함.
// 어떤 식이 수라면 그 값을 반환한다. -> Num class
// 어떤 식이 합계라면 좌항과 우항의 값을 계산한 다음에 그 두 값을 합한 값을 반환한다. Sum class
/*fun eval(e: Expr): Int { // 1. java 식
    if(e is Num){ // is 는 변수타입을 검사하는 키워드
        //e의 타입이 Num인지 검사한 다음 컴파일러는 e의 타입을 Num 으로 해석한다.
        // 그렇기 때문에 Num의 value를 명시적 캐스팅 없이 e.value로 사용할 수 있다.
        // return e.value
        val n = e as Num // as 는 원하는 타입을 명시적으로 캐스팅 해주는 키워드이다.
        return n.value
    }
    if (e is Sum){
        // 변수 e에 대해 스마트 캐스트를 사용한다.
        return eval(e.right) + eval(e.left)
    }
    throw IllegalAccessException("Unknown expression")
}*/
// 2. kotlin 식
/*fun eval(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.right) + eval(e.left)
    } else {
        throw IllegalAccessException("Unknown expression")
    }*/
// 3. if 중첩 대신 when 사용
fun eval(e: Expr): Int =
    when (e) {
        is Num ->  // <----
            e.value      // 인자 타입을 검사하는 when 분기를  <--
        is Sum ->  // <----                                // 이 부분에서 스마트 캐스트가 쓰였다.
            eval(e.right) + eval(e.left) // <----------------
        else ->
            throw IllegalAccessException("Unknown expression")
    }

// 위 예제 처럼 class의 프로퍼티에 대해 스마트 캐스트를 사용한다면 그 프로퍼티는 반드시 val이어야 하며 커스텀
// 접근자를 사용한 것이어도 안된다.

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num : ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum:$left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
        // throw 던지다.
    }

fun main() {
//    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
//    println(eval(Sum(Num(1), Num(2))))

    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}