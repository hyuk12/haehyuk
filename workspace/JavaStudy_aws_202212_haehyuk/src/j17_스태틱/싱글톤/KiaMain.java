package j17_스태틱.싱글톤;

public class KiaMain {

    public static void main(String[] args) {
        Kia kia = Kia.getInstance();

        kia.printCompanyName();
    }
}
