package j09_클래스;

public class J09_StudentMain {
	
	public static void main(String[] args) {
		// new 키워드 -> 생성자를 쓰기위한 키워드 new 생성자(); 한 세트  abstract , implements
		
		int a; // 스택영역은 무조건 초기화 작업을 한다 할당이 안된다. (메소드 안에서는)
		
//		System.out.println(a);
		
		J09_Student student1 = new J09_Student();
		J09_Student student2 = new J09_Student();
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println();
		
		student1.age = 30;
		student1.name = "java";
		
		
		student1.printInfo();
		student2.printInfo();
	}
}
