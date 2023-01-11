package j16_Object;

import java.util.Objects;

public class SubStudent {
    private String name;
    private int age;

    public SubStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
