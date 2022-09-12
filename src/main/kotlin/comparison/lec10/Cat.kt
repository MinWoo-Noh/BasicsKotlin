package comparison.lec10

class Cat(
    species: String
) : Animal(species, 4) {
// extends 키워드를 사용하지 않고 : 을 사용
// kotlin 에서는 어떤 클래스를 상속 받을때 상위 클래스의 생성자를 바로 호출해 주어야한다.
    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }

}