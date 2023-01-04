package j09_클래스;

public class J09_Student {
	
	// 생성이 될 때 만약에 들어오는 값이 없다면 자동적으로 기본값이 할당이 된다.
	// 기본값을 설정해 줄 수 있다.
	String name;
	int age;
	
	J09_Student(){
		// 주소 값을 리턴하는 자료형 기본 생성자이기에 생략가능
		System.out.println("생성됨");
	}
	void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println();
	}
}
