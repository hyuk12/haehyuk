package j12_배열.학점관리시스템;

public class StudentRepository {

	private Student[] studentTable;
	
	public StudentRepository(Student[] student) {
		this.studentTable = student;
	}
	
	public Student[] getStudent() {
		return studentTable;
	}

	// 저장하기
	public void saveStudent(Student student) {
		extendArrayOne();
		studentTable[studentTable.length - 1] = student;
	}
	
	//배열 길이 하나 늘리기
	private Student[] extendArrayOne() {
		Student[] newArray = new Student[studentTable.length + 1];
		transferArray(studentTable, newArray);
		return newArray;
	}
	
	private Student[] transferArray(Student[] oldArray, Student[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		return newArray;
	}
	
	
}
