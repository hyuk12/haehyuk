package j21_예외;

import java.util.Arrays;
import java.util.List;

public class ThrowsException {

    public static void printList(List<String> list, int size) throws IndexOutOfBoundsException {

        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "]" +  list.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args)  {
        String[] names = {"Jones", "Hackers", "James", "John"};

        try {
            throw new ClassCastException();
//            printList(Arrays.asList(names),5);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            System.out.println("무조건 실행");
        }
        System.out.println("프로그램 정상 종료");
    }
}
