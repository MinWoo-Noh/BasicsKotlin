package kotlinination.chap2.whenfor

// 피즈버즈 게임 3으로 나누어 떨어지면 "피즈"
//  5로 나누어 떨어지면 "버즈" 둘다 나눠지면 "피즈버즈"

fun fizzBuzz(i : Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> i


}

fun main() {
    // i 는 1부터 100까지 1씩 증가됨
    for (i in 1..100){
        println(fizzBuzz(i))
    }

    //  증가 값을 갖고 범위 이터레이션(iteration : (계산, 컴퓨터 처리 저절차의)반복 하기
    /*
    step : 증가 값 step 을 갖는 이터레이션
     */
    for (i in 100 downTo 1 step 2){
        println(fizzBuzz(i))
    }
}