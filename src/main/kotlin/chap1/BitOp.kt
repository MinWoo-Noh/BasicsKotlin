package chap1

fun main() {
    val x = 4 // (10) == 0100 (2)
    val y = 0b000_1010 //(2) == 5(10)
    val z = 0x0f // (16) == 0b000_1111(2) == 15(10)

    println("x shl 2 -> ${x.shl(2)}") // 16(10) 0001_000 (2)
    println("x inv -> ${x.inv()}") // 0b000_0100 -> 0b111_1011
}