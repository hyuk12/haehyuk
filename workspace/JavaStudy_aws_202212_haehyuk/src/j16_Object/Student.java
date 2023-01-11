package j16_Object;

import java.util.Objects;

public class Student {

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        super(); // -> 우리는 상속을 받은 적이 없지만  최상위 클래스인 Object 는 모든 클래스가 생성이 될 때 상속이 된 채로 생성이 된다.
        // extends Object 가 생략이 되어 있는 것이다.
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "이름: " + name + "\n나이: " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if(!(obj.getClass() == Student.class)){
            return false;
        }

        Student s = (Student) obj;
        return name.equals(s.name) && age == s.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
