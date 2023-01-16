package j21_예외;

public class ArrayException {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};

        try {
            throw new NullPointerException();
//            for (int i = 0; i < 6; i++) {
//                System.out.println(nums[i]);
//            }
            // 예외가 있을 수도 있는 부분
        }catch (ArrayIndexOutOfBoundsException e) {
            // else if 처럼 낮은 부분부터 최상위로 올라와야한다.
            System.out.println("배열의 크기가 다릅니다.");
        }catch (NullPointerException e) {
            System.out.println("Null 예외처리를 함");
        }catch (Exception e) {
            System.out.println("예상 못한 예외처리를 함");
        }finally {
            System.out.println("프로그램 정상 종료");
        }

    }
}
