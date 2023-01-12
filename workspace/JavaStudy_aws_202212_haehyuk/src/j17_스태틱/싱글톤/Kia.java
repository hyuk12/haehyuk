package j17_스태틱.싱글톤;

public class Kia {
    // 기본적인 싱글톤 틀
    private static Kia instance = null;

    private Kia() {}

    public static Kia getInstance() {
        if (instance == null) {
            instance = new Kia();
        }
        return instance;
    }

    public void printCompanyName () {
        System.out.println(getClass().getSimpleName());
    }
}
