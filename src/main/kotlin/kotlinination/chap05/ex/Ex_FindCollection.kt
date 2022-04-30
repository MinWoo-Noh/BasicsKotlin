package kotlinination.chap05.ex

data class Person(val name: String, val age : Int)

fun findTheOldest(people : List<Person>){

    var maxAge = 0 // 가장 많은 나이를 저장
    var theOldest : Person? = null // 가장 연장자인 사람을 저장
    for (person in people){
        if (person.age > maxAge){ // 현재까지 발견한 최 연장자보다 더 나이가 많은 사람을 찾으면 최대값을 바꾼다.
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main() {
    val person = listOf(Person("A", 29), Person("B", 31))
    //findTheOldest(person)
    // findTheOldest() 메소드를 직접 구현하지 않아도, kotlin 에서는 라이브러리 함수를 사용하면 된다.
    println(person.maxByOrNull { it.age }) // 나이 프로퍼티를 비교해서 값이 가장 큰 원소 찾기
}

