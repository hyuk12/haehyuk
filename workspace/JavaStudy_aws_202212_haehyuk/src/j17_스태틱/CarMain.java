package j17_스태틱;

public class CarMain {

    public static void main(String[] args) {

        Car[] cars = new Car[5];

        cars[0] = new Car("아반떼");
        cars[1] = new Car("소나타");
        cars[2] = new Car("산타페");
        cars[3] = new Car("제네시스");
        cars[4] = new Car("그랜져");

        for (Car c : cars) {
            System.out.println(c);
        }
    }
}
