package j18_제네릭;

public class TestData<T, E> {

    private T data1;
    // 래퍼클래스 자료형 Wrapper Class
    private E data2;

    public TestData(T data1, E data2){
        this.data1 = data1;
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "data1='" + data1 + '\'' +
                ", data2=" + data2 +
                '}';
    }
}
