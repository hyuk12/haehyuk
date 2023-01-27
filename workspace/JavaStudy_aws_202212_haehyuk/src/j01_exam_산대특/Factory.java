package j01_exam_산대특;

class Factory2 {
    private String factoryName;

    private static Factory2 instance;

    public static Factory2 getInstance() {
        if (instance == null) {
            instance = new Factory2();
        }
        return instance;
    }
    private Factory2() {}
}

public class Factory {

}
