package j15_인터페이스;

// 인터페이스의 안의 메소드는 무조건 추상메소드이다. 그래서  abstract 예약어가 붙지않는다.
// 추상 클래스와 달리 생성자나 구현객체 자체를 쓸 수 없다.
// 일반 변수를 가질 수 없다. 상수는 가질 수 있다.
public interface Calculator {

    // final 을 생략 할 수 있다. 일반 변수를 선언 할 수 없기 때문에!!
    public int ERROR = -9999999;

    public double plus(double x, double y);

    public double minus(double x, double y);

    // default 를 쓰면 일반 메소드를 선언할 수 있다.
    public default double multiplication(double x, double y) {
        return x * y;
    };

    public double division(double x, double y);
}
