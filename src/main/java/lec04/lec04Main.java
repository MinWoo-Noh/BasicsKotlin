package lec04;

public class lec04Main {

    public static void main(String[] args) {
        JavaMoney money01 = new JavaMoney(2_000L);
        JavaMoney money02 = new JavaMoney(1_000L);

        if (money01.compareTo(money02) > 1){
            System.out.println("Money1 아 Money2 보다 금액이 작습니다.");
        }

        System.out.println(money01.plus(money02));
    }
}
