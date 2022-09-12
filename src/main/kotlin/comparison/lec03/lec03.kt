package comparison.lec03

import lec03.Person

// java 의 경우
/*
int number1 = 4;
long number2 = number1;

int Type 이 long 타입으로 암시적으로 변경이 된다.
java 에서는 더 큰 타입으로 암시적 변경이 가능하다.
*/
// kotlin 의 Type 는 암시적 타입 변경이 불가능하다.
// to 변환 타입을 사용해야한다.
/*
val  number1 = 3
val  number2 : Long = number1.toLong()
*/

fun main() {
    printerAgeIfPerson(null)
}
//fun printerAgeIfPerson(obj: Any){
//    if (obj is Person){
////        val person = obj as Person
////        println(person.age)
//        // 위 코드를 스마트 캐스트하면
//        println(obj.age)
//    }
//}
fun printerAgeIfPerson(obj: Any?){ // ? :: 매개값으로 null 들어올 수 도 있다.
    val person = obj as? Person // as :: 스마트 캐스팅. obj 를 Person 으로 간주한다는 뜻.
    println(person?.age) // ?. :: 세이프콜 (null 이면 null 을 반환)
}



