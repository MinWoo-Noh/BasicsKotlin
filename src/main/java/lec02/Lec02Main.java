package lec02;

public class Lec02Main {
    public static void main(String[] args) {

    }

    // 이 코드는 안전한 코드일까?
    // 아니다. 왜냐하면 str 에 null 이 들어올수 있기 때문이다.
    // 즉, null 처리를 해 주어야한다.
    public boolean startsWithA(String str) {
        return str.startsWith("A");
    }

    // 위 의 경우를 예외처리하는 방법은 3가지가 있을것이다.

    // 1.  Exception 을 발생 시키는 방법
    public boolean startsWithA1(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null이 들어왔습니다.");
        }
        return str.startsWith("A");
    }

    // 2. null 을 반환하는 방법
    public Boolean startsWithA2(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith("A");
    }

    // null 경우에 false 로 간주해서 false 를 반환하는 방법.
    public Boolean startsWithA3(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("A");
    }
}
