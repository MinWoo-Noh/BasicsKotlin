package basic.chap6

/*람다 복습*/

// 사용 예
val sum: (Int, Int) -> Int = { x, y -> x + y }
val mul = { x: Int, y: Int -> x + y }
val add: (Int) -> Int = { it + 1 } // 매개 변수가 하나일때에는 it 으로 대체 가능

// 여러 개의 식이 있는 경우
val isPositive: (Int) -> Boolean = {
    val isPositive = it > 0
    isPositive // 마지막 표현식이 반환됨
}

val isPositiveLabel: (Int) -> Boolean = number@{
    val isPositive = it > 0
    return@number isPositive // 라벨을 사용해 반환됨
}

/* 고차함수
* 개념 : 함수의 매개변수로, 함수를 받거나 함수 자체를 반환할 수 있는 함수
*/
fun high(name: String, body: (Int) -> Int): Int { // 람다식은 일종의 함수이다!
    print("name : $name")
    val x = 0
    return body(x)
}

fun highNoArg(body: (Int) -> Int): Int {
    val x = 0
    return body(x)
}

fun inc(x: Int): Int {
    return x
}

// 함수를 이용한 람다식
//val result1 = high("Sean", { x -> inc(x + 3) })
//// 중괄호 바깥으로 빼내고 생략
//val result2 = high("Sean"){ x -> inc(x + 3) }
//// 매개변수 없이 함수의 이름만 사용할 때 [참조형 방식으로 람다식이 아닌 일반 함수를 사용하려면 먼저 인자가 같을 때 사용할 수 있다. 이때 ::함수명과 같은 형태로 사용]
//val result3 = high("Kim", ::inc)
//// 람다식 자체를 넘겨 준 형태
//val result4 = high("Sean") { x -> (x + 3) }
//// 매개변수가 한 개인 경우 생략
//val result5 = high("Sean") {it + 3}
//// 만일 일반 매개변수가 없고 람다식이 유일한 인자라면 다음과 같이 표현 가능
//val result6 = highNoArg{it + 3}


/*
클로저
- 람다식으로 표현된 내부 함수에서 외부 범위에 선언된 변수에 접슨할 수 있는 개념
- 람다식 안에 있는 외부 변수는 값을 유지하기 위해 람다가 포획(capture)한 변수
 */
fun main() {
    val calc = Calc()
    var result = 0; // 외부의 변수
    calc.addNum(2, 3) { x, y -> result = x + y } // 클로저
    println(result)
}

class Calc {

    fun filteredNames (length : Int){
        val names = arrayListOf("kim","hong","hwang","jeon")
        val filterResult = names.filter {
            it.length == length // 바깐의 length 에 접근함
        }
    }

    fun addNum(a: Int, b: Int, add: (Int, Int) -> Unit) { // 람다식 add 에는 반환값이 없다.
        add(a, b)
    }
}