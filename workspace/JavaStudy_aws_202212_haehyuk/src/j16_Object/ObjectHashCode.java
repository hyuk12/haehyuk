package j16_Object;

public class ObjectHashCode {

    public static void main(String[] args) {
        Student s1 = new Student("홍길동", 30);
        Student s2 = new Student("홍길동", 30);
        SubStudent s3 = new SubStudent("홍길동", 30);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1.hashCode() == s3.hashCode());
    }
}
