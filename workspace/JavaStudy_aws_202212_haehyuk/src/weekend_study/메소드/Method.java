package weekend_study.메소드;

public class Method {

    // 메소드는 뭘까?
    // 약간 그 또하나의 클래스를 생성하지 않고도 쓸 수 있는 기능?

    // 클래스는 뭘까? 하나의 집

    // 메소드는 클래스랑 관련이없어 함수라고도불려 입력과 출력이있다. 들어오는게 있고 나가는게 있어
    // 필수적이진 않아. 클래스안에 있어야만 메소드다 클래스지향이자나 객체지향 함수가 모두 메소드라고불린다.

    // 클래스는 변수와 메소드의 집합이야 객체지
    //입력되는 값 : 매개변수

    // 오버로딩

    public static void call1(int y, int x, String name) {
        // void return 형이 없다.
        // 이부분이 출력부분
         System.out.println("메소드를 호출했습니다.");
         return;
    }
    // 메소드 종료

    public static void call1(String name, int x, int y) {
        // void return 형이 없다.
        // 이부분이 출력부분
        System.out.println("메소드를 호출했습니다.");

    }

    public static String call2() {
        String result = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                result += "*";
            }
            result += "\n";
        }
        return result;
    }

    // 반환형이 있으면 return 값이랑 무조건 같아야한다.
    public static String call3(int year, int month, int day) {
        return year + " 년 " + month + " 월 " + day + " 일";
    }

    public static void main(String[] args) {
        String star1 = call2();
        System.out.println(star1);

        String todayDate = call3(2023, 01, 23);
        System.out.println(todayDate);
    }
}
