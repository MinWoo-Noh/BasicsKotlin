package basic.chap2

/*
목표: 하나 이상의 실수를 받아서 모든 실수의 합의 평균을 구하고 출력 하려고 합니다.

다음 조건을 만족하는 함수를 구현해 보세요!

초기값을 위한 인자는 Float형
초기값은 두번째 부터 나열된 인자의 최종 평균 결과에 더함
초기값에 아무런 인자를 입력하지 않으면 0을 기본 사용 (파라미터로 아무것도 넘기이 않을때를 말함)
두번째부터 받아들일 인자는 가변형 인자로 모두 실수형 Float
반환값은 모든 인자의 평균값으로 마찬가지로 실수형 Double

fun avgFunc(initial: ____(1)______, _____(2)_____ numbers: Float): Double {
    var result = 0f
    for (num in numbers) {
        ________(3)_________
    }
    println("result: $result, numbers.size: ${numbers.size}")
    val avg = __________(4)____________
    return ________(5)_________
}

fun main() {
    val result = avgFunc(5f, 100f, 90f, 80f)  // 첫번째 인자: 초기값, 이후 인자는 가변인자
    println("avg result: $result")
}
 */

fun avgFunc(initial: Float = 0f ,vararg numbers: Float): Double {
    var result = 0f
    for (num in numbers) {
        result+=num
    }
    println("result: $result, numbers.size: ${numbers.size}")
    val avg = (result/numbers.size)
            return avg.toDouble()
}

fun main() {
    val result = avgFunc(5f, 100f, 90f, 80f)  // 첫번째 인자: 초기값, 이후 인자는 가변인자
    println("avg result: $result")
}