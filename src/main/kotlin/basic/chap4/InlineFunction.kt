package basic.chap4

inline fun shortFunc(a: Int, crossinline out: (Int) -> Unit) {
// inline fun shortFunc(a: Int, noinline out: (Int) -> Unit) { // 경우에따라 inline을 하고싶지 않을 경우 noinline 키워드 사용
    println("Hello")
    out(a)
    println("GoodBye")
}

fun main() {
    // inline 함수는 이 함수가 호출되는 곳에 내용을 모두 복사해 넣어
    // 함수의 분기 없이 처리 되기때문에 코드의 성능을 높일 수 있다.
    // (대게 내용은 짧게, 람다식 매개변수를 가지고 있는 함수 형태를 권장한다.)
    //shortFunc(3, { a -> println("a: $a") })
    // 인자가 하나인 경우 람다식 생량 후 인자를 it으로 대체할 수 있다.
    //shortFunc(3, { println("a: $it") })
    // 해당 함수에 마지막 파라미터가 람다식으로 구성되어 있으면 {} 를 밖으로 뺄 수 있다.
    shortFunc(3) {
        println("a: $it")
        //return // 실수로 리턴문을 사용시 shorFunc() 의 println 과 out()이 실행되고 함수를 out 및 shortFunc 까지 빠저나가게된다, 이것을 비 지역반환이라고 한다.
        // 인런경우를 막기위해(return 사용) shortFunc(a: Int, crossinline out: (Int) -> Unit) {...} crossinline(비 지역 반환을 금지하는 것) 키워드를 널어준다.
        // (crossinline 키워드를 적을 시 return 사용 금지)
    }
}