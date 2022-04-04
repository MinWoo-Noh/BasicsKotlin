package chap5

fun main() {

    println("Enter The score : ")
    // 콘솔로부터 한 줄 입력 받아들인다.
    // !! 은 무조건 널이 아니라는걸 명시 될 수 있으면 안쓰는게 좋지만, 빠르게 테스트할때는 써볼 수 있다.
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

    // 방법 1
    when (score) {
        in 90.0..100.0 -> grade = 'A'
        in 80.0..89.9 -> grade = 'B'
        in 70.0..79.9 -> grade = 'C'
        else -> grade = 'F'
    }

    // 방법 2
    grade = when (score) {
        in 90.0..100.0 -> 'A'
        in 80.0..89.9 -> 'B'
        in 70.0..79.9 -> 'C'
        else -> 'F'
    }

    // 방법 3
    when {
        score >= 90.0 -> grade = 'A'
        score in 80.0..89.9 -> grade = 'B'
        score in 70.0..79.9 -> grade = 'C'
        score < 70.0 -> grade = 'F'
    }

    println("score: $score, grade: $grade")
}