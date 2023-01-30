package j22_익명클래스;

public class Main {

    public static void main(String[] args) {

        Calculator c1 = new Addition();

        Calculator c2 = new Calculator() {
            @Override
            public int calc(int x, int y) {
                return x - y;
            }
        };

        Calculator c3 = (x, y) -> x / y;
        
        System.out.println(c1.calc(1,2));
        System.out.println(c3.calc(10,2));

    }
}
