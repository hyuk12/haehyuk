package j11_접근지정자;

import j11_접근지정자.default1.J11_StudentDefault;
// 클래스에 public 이 붙어있기에 임포트가 가능하다.

public class J11_StudentMain {

	public static void main(String[] args) {
		J11_Student student1 = new J11_Student();
		System.out.println(student1);
		
		student1.setName("홍길");
		
		student1.printInfo();
		
//		J11_StudentDefault s2 = new J11_StudentDefault();
//		s2.setName("이순신");
//		System.out.println(s2.getName());
//		s2.printInfo();
//	
		
		
	}
}
