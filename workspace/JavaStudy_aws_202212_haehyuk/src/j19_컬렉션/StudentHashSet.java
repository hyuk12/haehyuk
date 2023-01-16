package j19_컬렉션;



import java.util.HashSet;
import java.util.Set;

public class StudentHashSet {

    private static Student searchStudent(Set<Student> students, String searchName) {
        Student student = null;

        for (Student value : students) {
            if (value.getName().equals(searchName)){
                student = value;
                break;
            }
        }
        return student;
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<Student>();

        students.add(new Student("John", 20));
        students.add(new Student("Marry", 23));
        students.add(new Student("James", 22));
        students.add(new Student("Bob", 24));

        System.out.println(students);

        Student student = searchStudent(students, "John");

        if (student == null) {
            System.out.println("검색실패!");
        }else {
            System.out.println("검색성공! " + student);
        }
    }
}
