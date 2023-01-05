package j11_접근지정자;

public class J11_Student {
	
	private String name;
	private int age;
	
	
	
	public J11_Student() {}

	public J11_Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
}
