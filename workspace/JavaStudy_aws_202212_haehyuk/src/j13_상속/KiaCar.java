package j13_상속;

public class KiaCar extends Car{

    public KiaCar() {
        super(); // 생략가능.
        System.out.println("자식");
    }

    @Override
    public int discountPrice(int percentage) {
        return super.discountPrice(percentage);
    }

    public void test() {
        KiaCar kc = this;
        //자기 자신의 주소를 받아서 쓰고 싶을 때 쓴다.
    }
}
