package basic.chap5

fun main() {
//    retFunc()
//    println(getMessage(101))
    labelBreak1()
}

// inline 으로 선언되지 않음 함수는 람다식 함수에서 return 을 사용할 수 없다 return @label 과 같이 라벨(label) 표기와 함쎄 가용해야한다.
// 라벨이란 코드에서 특정한 위치를 임의로 표시한 것으로, @ 기호 뒤에 이름을 붙여서 사용한다.
inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

/*
라벨을 사용하는 이유. 람다식은 라벨을 사용하지않으면 비지역 반환이 일어나 return 문 에서 바로 반환된다.
 */
// 라벨 표현 1
//fun retFunc() {
//    println("Start fo Func")
//    inlineLambda(12,3) lit@{a, b -> // 1. 람다식 블록의 시작 부분에 라벨을 지정함
//        val result = a + b
//        if (result > 10) return@lit // 2 라벨을 사용한 블록의 끝부분으로 반환
//        println("return: $result")
//    } // 3 이 부분으로 빠저나간다.
//    println("end of Func") // 3 이부분이 실행됨
//    // 만일 라벨과 함께 특정 값을 반환하려면 다음과 같이 표현 할수 있다.
//    // @a 1
//    // 라벨 @a 에 해당하는 블록에서 값 1을 반환하게 된다.
//}

// 라벨 표현 2 (생략) // 암묵적 라벨
//fun retFunc() {
//    println("Start fo Func")
//    inlineLambda(12,3) {a, b -> // 이 부분 라벨 생략
//        val result = a + b
//        if (result > 10) return@inlineLambda // 람다식 이름을 적어주면 중괄호 앞의 라벨이 생략 가능하다.
//        println("return: $result")
//    } // 3 이 부분으로 빠저나간다.
//    println("end of Func")
//}

// 람다식 말고 일반 익명함수를 사용하면 비지역반환이 일어나지 않는다.
fun retFunc() {
    println("Start fo Func")
    inlineLambda(12,3, fun(a, b){
        val result = a + b
        if (result > 10) return
        println("return: $result")
    }) // inlineLambda() 함수의 끝
    println("end of Func")
}

val getMessage = lambda@ {num : Int ->
    // ! 연산자는 범위안에 없을경우를 나타냄
    // num 이 1~100 범위에 없을 경우
    if (num !in 1..100) {
        return@lambda "Error" // 레이블을 통한 반환
    }
    "Sucess" // 람다의 마지막은 자동으로 리턴된다. (마지막 식이 반환됨)
}

fun labelBreak1(){
    println("labelBreak")
    for (i in 1..5){
        second@ for (j in 1..5) {
            if (j == 3) break
            println("after for j")
        }
        println("after for i")
    }
}
/*
결과
after for j
after for j
after for i
after for j
after for j
after for i
after for j
after for j
after for i
after for j
after for j
after for i
after for j
after for j
after for i
 */

fun labelBreak2(){
    println("labelBreak")
    first@ for (i in 1..5){
        second@ for (j in 1..5) {
            if (j == 3) break@first
            println("after for j")
        }
        println("after for i")
    }
}
/*
labelBreak
after for j
after for j
 */