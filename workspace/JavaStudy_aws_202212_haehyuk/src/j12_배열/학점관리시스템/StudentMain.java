package j12_배열.학점관리시스템;



public class StudentMain {

	public static void main(String[] args) {

		Student[] students = new Student[0];
		
		StudentRepository repository = new StudentRepository(students);
		
		StudentService service = new StudentService(repository);
		
		service.run();
		service.stop();
	}
}
