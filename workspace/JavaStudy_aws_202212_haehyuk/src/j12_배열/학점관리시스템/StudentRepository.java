package j12_배열.학점관리시스템;

import java.util.Arrays;

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
	
	private Student[] extendArray(int length) {
		Student[] newArray = new Student[studentTable.length + length];
		transferArray(studentTable, newArray);
		return newArray;
	}
	
	//배열 길이 하나 늘리기
	private void extendArrayOne() {
		Student[] newArray = new Student[studentTable.length + 1];
		transferArray(studentTable, newArray);
		studentTable = newArray;
	}
	
	private void transferArray(Student[] oldArray, Student[] newArray) {
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
	}

	@Override
	public String toString() {
		return  Arrays.toString(studentTable) ;
	}
	
	
	
	
}
