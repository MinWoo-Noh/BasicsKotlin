package comparison.lec10

class Penguin(
    species : String
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount : Int = 2

    override fun move() {
        println("팽귄이 움직입니다.")
    }

    // 프로퍼티에대한 오버라이드를할 떄는 추상 프로퍼티가 아니라면, 상속받을때 open 을 꼭 붙여야한다.
    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

}