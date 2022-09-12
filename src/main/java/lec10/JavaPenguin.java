package lec10;

public final class JavaPenguin extends JavaAnimal implements JavaFlyable, JavaSwimable{

    private final int wingCount;

    public JavaPenguin(String species) {
        super(species, 2);
        this.wingCount = 2;
    }

    @Override
    public void move() {
        System.out.println("퓅귄이 움직입니다 ~");
    }

    @Override
    public int getLegCount() {
        return super.legCount + wingCount;
    }

    @Override
    public void act() {
        JavaSwimable.super.act();
        JavaFlyable.super.act();
    }
}
