package j17_스태틱.싱글톤;


import j17_스태틱.싱글톤.Singletone;

public class SingletoneMain {
    public static void main(String[] args) {
        Singletone a = Singletone.getInstance();
        Singletone b = Singletone.getInstance();

        System.out.println(a);
        System.out.println(b);

        if (a == b) {
            System.out.println(true);
        }
    }
}
