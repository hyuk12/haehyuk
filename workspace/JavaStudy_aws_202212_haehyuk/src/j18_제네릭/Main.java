package j18_제네릭;

public class Main {

    public static void main(String[] args) {
        TestData<String, Integer> td = new TestData<String, Integer>("홍길동", 100);
        TestData<String, Double> td2 = new TestData<String, Double>( "홍길동", 100.07);

        System.out.println(td);
        System.out.println(td2);
    }
}
