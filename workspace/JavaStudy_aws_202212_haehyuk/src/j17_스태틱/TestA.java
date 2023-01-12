package j17_스태틱;

public class TestA {

    private static int num;

    public static void setNum(int num) {
        TestA.num = num;
    }

    public static int getNum (){
        return num;
    }
}
