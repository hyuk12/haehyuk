package j18_제네릭;

public class Main2 {

    public CMRespDto<?> response(CMRespDto<?> cmRespDto) {
        System.out.println("[응답데이터]");
        System.out.println(cmRespDto);
        return cmRespDto;
    }

    public static void main(String[] args) {
        Main2 main = new Main2();

        CMRespDto<String> hello = new CMRespDto<>(200, "성공", "안녕하세요.");

        CMRespDto<Integer> score = new CMRespDto<>(200, "성공", 85);

        System.out.println("hello");
        System.out.println(main.response(hello));

        System.out.println("score");
        System.out.println(main.response(score));


        // response 메소드가 실행이 되면 안녕하세요.
    }
}
