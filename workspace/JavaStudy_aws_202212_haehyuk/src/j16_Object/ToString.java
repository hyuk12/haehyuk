package j16_Object;

public class ToString {

    public static void main(String[] args) {
//        Object obj = new Object();
//
//        System.out.println(obj);
//
//        String str = obj.toString();
////        String str2 = obj;
//
//        System.out.println(str);

        Student student1 = new Student("홍길동", 29);
        Student student2 = new Student("이순신", 35);
        Student student3 = new Student("김유신", 23);
        Student student4 = new Student("강감찬", 15);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

        System.out.println();

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());
    }
}
