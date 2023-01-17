package j21_예외;

public class CustomErrorException extends RuntimeException {

    public CustomErrorException() {
        System.out.println("내가 만든 국희~");
    }

    public CustomErrorException(String message) {
        super(message);
    }
}
