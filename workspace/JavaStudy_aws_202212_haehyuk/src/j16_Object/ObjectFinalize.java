package j16_Object;

class Test {
    private int num;

    public Test(int num) {
        this.num = num;
        System.out.println(num + "생성");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(num + "객체 소멸");
    }
}

public class ObjectFinalize {

    public static void main(String[] args) {
        Test test = null;

        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            test = new Test(i);

            test = null;
            System.gc();
        }
    }
}
