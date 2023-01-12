package j17_스태틱;

public class Student {

    private static final int CODE = 20230000;
    private static int ai = 1; // auto_increment 자동 증가

    private int studentCode;
    private String name;

    // 생성이 될 때 마다 studentCode 가 생성이 되는데
    // 그 생성 되는 코드는 상수값 20230000 고정 되어 있는 값에
    //ai 값을 더하게 되고 그후 static 으로 만든 변수인 ai는 공유되는 공간이기에
    //ai++ 을 하는경우 1에서 1이 더해진 2가 다음 생성 때 대입이 된다.
    public Student(String name) {
        studentCode = CODE + ai;
        ai++;
        this.name = name;
    }

    public static int getAutoIncrement() {
        System.out.println("현재 AI: " + ai);
//        System.out.println("학생이름: " + name); 스태틱 메소드에서 꼭 생성이 되어야 있는 변수를 썻기때문에 쓸 수 없다.
        return ai;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode=" + studentCode +
                ", name='" + name + '\'' +
                '}';
    }
}
