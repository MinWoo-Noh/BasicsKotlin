# 코틀린 표준 라이브러이

- 람다식의 접근방법
    - it : 복사
    - this : 참조 (자기자신)
    
- let() 활용
  - let()함수는 함수를 호출하는 객체 T를 이어지는 block의 인자로 넘기고 block의 결과값 R을 반환합니다.
    
~~~kotlin
// 표준 함수의 정의
public inline fun <T, R> T.let(block: (T) -> R): R { ... return block(this) }
~~~

- T나 R과 같은 문자(형식 매개변수)는 let( ) 확장 함수를 사용하기 위해 어떤 자료형이더라도 사용할 수 있도록 일반화한 문자이다.
- 예를 들면 정수형, 문자열, 특정 클래스의 객체등에 let()함수를 확장 함수로서 사용할 수 있다.

~~~kotlin
    val score: Int? = 32
...
    // let을 사용해 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it") } // ①
        val str = score.let { it.toString() } // ②
        println(str)
    }
~~~

let은 특정 선언 변수를 T요소로 받아 결정되었는데 여기서는 널 가능한 정수형 변수이다. 

이 변수는 다시 Int의 객체라고도 말할 수 있다. 

여기에 let 함수로 확장함으로서 필요한 score를 it으로 받아서 후처리 하며 이것의 결과를 다시 반환해 str에 할당하게 되는 것이다.


- null 가능성 있는 객체에서 let() 활용하기

let을 세이프 콜(?.)과 함께 사용하면 if (null != obj)와 같은 null 검사 부분을 대체할 수 있다.

~~~kotlin
obj?.let { // obj가 null이 아닐 경우 작업 수행 (Safe calls + let 사용)
    Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
}
~~~
이 코드는 obj가 널이 아닌 경우에만 let 블록 구문을 수행하고 널이면 아무런 일도 하지 않게 되므로 널 예외인 NPE를 방지할 수 있다.

체이닝을 사용할 때 let() 활용하기

체이닝이란 여러 메서드 혹은 함수를 연속적으로 호출하는 기법이다. 당연히 다음과 같이 let()함수를 체이닝 형태로 사용할 수 있다.
~~~kotlin
var a = 1
var b = 2

a = a.let { it + 2 }.let {
    val i = it + b
    i  // 마지막 식 반환
}
println(a) //5
~~~
코드에서처럼 첫 번째 a.let {...} 블록의 처리 결과를 다시한번 let {...} 블록으로 넘겨서 처리할 수 있다. 

이때 블록의 마지막 식이 반환된다. 

코드의 가독성을 고려한다면 너무 많은 let을 사용하는 것은 권장되지 않는다.