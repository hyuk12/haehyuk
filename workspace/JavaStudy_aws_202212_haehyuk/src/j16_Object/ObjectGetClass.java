package j16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {

    public static void main(String[] args) {
        Student student = new Student("홍길동", 37);



        System.out.println(student.getClass());
        System.out.println(Student.class);

        // 다른패키지에도 같은 이름의 클래스가 있을수 있다. 그래서 패키지까지 표현한다.
        System.out.println(student.getClass().getName());

        Class<?> studentClass = student.getClass();

        // 클래스 이름만.
        System.out.println(studentClass.getSimpleName());

        // getDeclared 가 붙으면 지정자가 무엇이든 들고오고 그냥 get 뒤에 오는 것은 public 이어야만 들고 올수 있다.
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println();

        Method[] methods = studentClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
