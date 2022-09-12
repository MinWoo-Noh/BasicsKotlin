package comparison.lec04

import lec04.JavaMoney

/*
 1. 비굥연산자와 동등성, 동일성

 돈등성(Equality) : 두 갹채의 값이 같은가?
 동일성(Identity) : 완전히 동일한 객체인가?!즉 주소가 같은가?!
 --------------------------------------------------
 2. 비교 연산자와 동등성, 동일성
    - java 에서는 동일성에 == 를 사용, 동등성에 equals 를 직접 호출
    - kotlin 에서는 동일성에 === 를 사용, 등덩선에 == 를 호출
    == 를 사용하면 간접적으로 equals 를 호출해준다.
 */
fun main() {
    val money1 = JavaMoney(2_000)
    val money2 = JavaMoney(1_000)

    if (money1 > money2) {
        println("Money1이 Money2 보다 금액이 큽니다.")
    }
}