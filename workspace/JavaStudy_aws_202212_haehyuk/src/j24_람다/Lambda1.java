package j24_람다;

public class Lambda1 {

    public static void main(String[] args) {

        Instrument ins = new Instrument() {
            @Override
            public String play(String instrument) {
                return instrument + "를 연주합니다.";
            }
        };

        // 매개 변수의 자료형을 생략할 수 있다.
        // 매개변수의 이름을 바꿔줄 수 있다.
        Instrument ins2 = (itm) -> {
            return itm + "를 연주합니다.";
        };

        // 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다.
        Instrument ins3 = itm -> {
            return itm + "를 연주합니다.";
        };

        // 실행하는 명령문이 하나라면 구현부의 중괄호를 생략할 수 있다.
        // 이때 리턴자료형이 정해져 있으면 생략가능하다.
        Instrument ins4 = itm -> itm + "를 연주합니다.";


        /*
         *      람다를 쓰는 이유
         *
         *      람다를 쓰게 되면 메인 메소드에서 사용하는 지역변수들을 람다식 안에서 사용이 가능하다.
         *      코드가 간결 해진다.
         *      한번만 정의해서 쓰기위해서 쓴다 (익명 클래스와 동일)
         */


        int result = 10 + 20;
        Instrument instrument = itm -> itm + "를 연주합니다." + ins.play(itm);

        System.out.println(ins.play("피아노"));
        System.out.println(instrument.play("기타"));

    }
}
