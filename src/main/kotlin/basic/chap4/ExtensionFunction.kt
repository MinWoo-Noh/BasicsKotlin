package basic.chap4

fun main() {
    val source = "Hello Word"
    val target = "kotlin"

    println(source.getLongString(target))
}

// 확장함수
fun String.getLongString(target : String) : String =
    if (this.length > target.length) this else target