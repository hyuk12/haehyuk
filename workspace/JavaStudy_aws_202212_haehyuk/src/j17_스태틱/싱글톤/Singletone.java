package j17_스태틱.싱글톤;

public class Singletone {
    private static class SingletoneHave {
        private static final Singletone INSTANCE = new Singletone();
    }

    public static Singletone getInstance() {
        return SingletoneHave.INSTANCE;
    }
}
