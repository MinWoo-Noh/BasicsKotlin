package kotlinination.chap2.ex_enum

enum class Color(var r: Int, val g: Int, val b: Int) { // 상수 프로퍼티 정의
    // 상수 정의 및 프로퍼티 값 지정
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255), INDIGO(
        75,
        0,
        130
    ),
    VIOLET(238, 130, 238); // enum class 의 마지막 상수에는 ;을 찍어줘야한다.

    fun rab() = (r * 256 + g) * 256 + b // enum class 안에서 메서드 정의

}

// when의 분기 조건에 여러 다른 택체 사용하기
fun mix(c1: Color, c2: Color) =
// setOf( 1,2,3 과 setOf(3,2,1) 은 같다
    /*
    //sampleStart
        val set1 = setOf(1, 2, 3)
        val set2 = setOf(3, 2, 1)

        // setOf는 요소의 반복 순서를 유지합니다.
        println(set1) // [1, 2, 3]
        println(set2) // [3, 2, 1]
     */
    when (setOf(c1, c2)) { // 인자로 아무 객체나 사용 가능
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    } // fun mix(c1: Color, c2: Color) { ...} 과 fun mix(c1: Color, c2: Color) = ... 조심

// 가독성은 떨어지지만 mix(...) 성능 향상
// when (setOf(c1, c2)) {...} 이 자주 호출된다면 불필요한 가비지 객체가
fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

// when 을 사용해 올바른 enum 값 찾기
fun getMnemonic(color: Color) =
    // 각 구문에 break 를 넣지 않아도 됨
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

// enum 상수 값을 임포트해서 enum 클래스 수식자 없이 enum 사용하기
fun getWarmth(color: Color) = when (color) {
    // 한 분기안에 여러값 사용할 경우 ,로 분리
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}


fun main() {
//    println(Color.BLUE.rab());
//    println(getMnemonic(Color.BLUE))
//    println(getWarmth(Color.ORANGE))
    println(mix(Color.BLUE, Color.YELLOW))
    println(mixOptimized(Color.BLUE, Color.YELLOW))
}