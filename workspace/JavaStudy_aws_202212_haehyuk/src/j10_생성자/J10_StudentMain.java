package j10_생성자;

public class J10_StudentMain {

	public static void main(String[] args) {
		J10_Student student1 = new J10_Student();
		J10_Student student2 = new J10_Student(20);
		J10_Student student3 = new J10_Student("이순신");
		J10_Student student4 = new J10_Student("이순신", 20);
		
		student1.printInfo();
		student2.printInfo();
		student3.printInfo();
		student4.printInfo();
		
	}
}
