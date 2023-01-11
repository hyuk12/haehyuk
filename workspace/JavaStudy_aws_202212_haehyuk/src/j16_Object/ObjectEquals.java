package j16_Object;

public class ObjectEquals {

    public static void main(String[] args) {
        String name1 = "김유신";
        String name2 = "김유신";
        String name3 = new String("김유신");

        // 실제로 String 은 클래스기 때문에 new String(""); 으로 생성을 해주어야 하지만 이미 리터럴으로 문자열이 정해져 있어 저렇게 가능하다.
        // 이러해서 String은 주소로 비교하지 않고 이러한 오류를 없애기 위해 .equals를 이용한다.

        System.out.println(name1);
        System.out.println(name2);

        // == 비교는 주소 비교이다.
        System.out.println(name1 == name2);
        System.out.println(name3 == name2);
        System.out.println(name1.equals(name3));

        Student s1 = new Student("김유신", 45);
        Student s2 = new Student("김유신", 45);
        SubStudent s3 = new SubStudent("김유신", 45);

        System.out.println(s1 == s2); // true 위의 String 값을 == 비교로 했을 때 위의 코드같은 느낌이다.
        System.out.println(s1.equals(s3)); // true 위의 String 값을 == 비교로 했을 때 위의 코드같은 느낌이다.
    }
}
