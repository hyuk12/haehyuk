package j10_생성자;

public class J10_Student {
	
	// 참조변수, 멤버변수, 레퍼런스변수
	String name;
	int age;
	
	J10_Student () {
		System.out.println("기본 생성자 호출");
	}
	
	J10_Student(int age) {
		System.out.println("나이는: " + age );
//		this.age = age;
	}
	
	J10_Student(String name) {
//		this.name = name;
	}
	
	J10_Student(String name, int age) {
//		this.name = name;
//		this.age = age;
	}
	
	void printInfo() {
		System.out.println("학생의 이름: " + name);
		System.out.println("학생의 나이: " + age);
	}
}
