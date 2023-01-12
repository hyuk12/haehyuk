package j17_스태틱;

public class StudentMain {

    public static void main(String[] args) {
        Student[] students = new Student[5];
//        Teacher[] teachers = new Teacher[5];

        students[0] = new Student("홍길동");
        students[1] = new Student("김유신");
        students[2] = new Student("강감찬");
        students[3] = new Student("이순신");
        students[4] = new Student("장보고");

//        teachers[0] = new Teacher("세종대왕");
//        teachers[1] = new Teacher("율곡이이");
//        teachers[2] = new Teacher("퇴계이황");
//        teachers[3] = new Teacher("신사임당");
//        teachers[4] = new Teacher("정약용");

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
//            System.out.println(teachers[i]);
//            System.out.println();
        }

        System.out.println();

        int j = 0;
        for (Student student : students) {
            System.out.println(student);
//            System.out.println(teachers[j]);
//            System.out.println();
            j++;
        }

        int autoIncrement = Student.getAutoIncrement();
        System.out.println(autoIncrement);
    }
}
