package comparison.lec02

import lec02.Person

fun main() {

    val str: String? = "ABC"
    // println(str.length) // 오류나는 이유 : null이 들어갈 수 있는 변수에 대해서는 .을 바로쓸 수 없다.
    println(str?.length) // ?. (세이프 콜)은 null 이지 않은 경우에만 호출해 줘 라는 뜻이다. (null 미면 결우 null 이다.)
    println(str?.length ?: 0) // ?: (엘비스 연산자)는 앞 의 연산 결과가 null 이면 뒤의 값을 사용한다.

    val person = Person("공부하는 개발자")
    // startWithA(person.name) // 오류 아는 이유는 java 코드에서 (lec02/Person.java) Person 의 getName  함수의 어노테이션이 @Nullable(Null 이 될 수 있다.) 가 붙어있기때문이다.
                            // startWithA 함수의 매개값은 Null 이 들어갈 수 없디때문에 java 코드에서 @NotNull(Null 이 될 수 없다) 을 써 주면 오류가 사라진다.
    // 만약, java 코드에서 null 관련 어노테이션이 없다면, 일단 코드는 실행이 되지만 컴파일 단에서 NPE 가 날 수 있다.
}

// 이 함수는 매개값 Type 에 ? 가 안 붙어있기때문에 무조건 null 이 아니여야한다.
fun startWithA(str : String) : Boolean {
    return str.startsWith("A")
}
/*
// Type 에 ? 를 붙여주는 이유는 java code 를 kotlin 으로 변경하기 때문
fun startsWithA1(str: String?): Boolean { // Boolean 에 ? 안붙여 주는 이유는 java 에서도
// null 이 들어갈 수 없는 boolean Type 이기때문에 붙여주지 않는다.(함수의 타입을 말하는것 즉, 나가는 return)
    if (str == null) {
        throw IllegalArgumentException("Null이 들어왔습니다.")
    }
    return str.startsWith("A")
} */
// startsWithA1 함수를 kotlin 스럽게 수정
fun startsWithA1(str: String?): Boolean { // Boolean 에 ? 안붙여 주는 이유는 java 에서도
// null 이 들어갈 수 없는 boolean Type 이기때문에 붙여주지 않는다.(함수의 타입을 말하는것 즉, 나가는 return)
    return str?.startsWith("A") ?: throw IllegalArgumentException("Null이 들어왔습니다.")
}

fun startsWithA2(str: String?): Boolean? {
//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")
    // kotlin 스럽게 수정
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")
    // kotlin 스럽게 수정
    return str?.startsWith("A") ?: false
}

// 어떤 경우에도 null 일 수 없을경우
fun startsWith(str: String?) : Boolean {
    return str!!.startsWith("A")
}

