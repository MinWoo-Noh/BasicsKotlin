package chap5

fun main() {

    println("Enter The score : ")
    // 콘솔로부터 한 줄 입력 받아들인다.
    // !! 은 무조건 널이 아니라는걸 명시 될 수 있으면 안쓰는게 좋지만, 빠르게 테스트할때는 써볼 수 있다.
    val score = readLine()!!.toDouble()
    var grade : Char = 'F'

    if (score >= 90.0){
        grade = 'A'
//    } else if (score >=80 && score <=89.9) {
    } else if (score in 80.0..89.9) { // kotlin 에서 사용되는 범위 연산자 ~~ in 시작값..마지막값
        grade = 'B'
//    } else if (score >=70 && score <=79.9) {
    } else if (score in 70.0..79.9) {
        grade = 'C'
    }

    println("score: $score, grade: $grade")
}