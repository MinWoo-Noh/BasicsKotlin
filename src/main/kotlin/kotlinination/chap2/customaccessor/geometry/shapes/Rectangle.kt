package kotlinination.chap2.customaccessor.geometry.shapes

import java.util.*


class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean = height == width
//        get() {
//            return height == width
//        }
}

fun createRandomRectangle() : Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

