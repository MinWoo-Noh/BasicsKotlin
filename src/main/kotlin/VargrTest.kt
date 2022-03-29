

// vararg 키워드를 사용하면 파라미터를 여러개 줄 수 있다.
// 가변인자
fun normalVarargs(vararg a : Int){
    for (num in a) {
        println(num)
    }
}

fun main() {
    normalVarargs(1)
    println()
    normalVarargs(1,2,3,4,5,6,7,8,9)
}