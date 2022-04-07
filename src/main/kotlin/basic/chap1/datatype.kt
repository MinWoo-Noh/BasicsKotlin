package basic.chap1

fun main() {

//    val name: String = "minu"
//    var age: Int = 0
//    age = 32
//    println("name $name, age $age")

//    val a = 1
//    val str1 = "a = $a"
//    val str2 = "a = ${a + 2}"
//    println("str: \"$str1\",str2 : \"$str2\"")

    var str1 : String?
    str1 = null

    val len = str1?.length ?: -1
    println("str: $str1, length : $len")

    var a : Any = 1
    a = 20L
    println(a.javaClass)
}