package j17_스태틱.싱글톤;

public class Singletone {
    private static class SingletoneMetohd {
        private static final Singletone INSTANCE = new Singletone();
    }

    public static Singletone getInstance() {
        return SingletoneMetohd.INSTANCE;
    }
}
