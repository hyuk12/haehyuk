package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayList {
	
	public static void updateYear(
			List<Student> students,
			String searchName,
			int newYear) {
		
		for (Student student : students)
			if (student.getName().equals(searchName)) {
				student.setYear(newYear);
				return;
			}
		System.out.println("검색 실패!");	
	}
	
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student("홍길동", 1));
		studentList.add(new Student("김유신", 2));
		studentList.add(new Student("손흥민", 3));
		studentList.add(new Student("장보고", 4));
		
		System.out.println(studentList);
		
		System.out.println(studentList.get(0).getName());
		System.out.println(studentList.get(0).getYear());
		System.out.println(studentList.get(1).getName());
		System.out.println(studentList.get(1).getYear());
		
		// 이름이 searchName 인 학생을 찾아서 학년을 4학년으로 바꿔라
		// 만약 searchName 과 동일한 이름이 없으면 "검색실패!" 메세지출력
		
		// 선형 탐색  반복이 진행하고 없으면 다음 조건을 실행하라
		String searchName = "손민";
		boolean flag = true;
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			
			if(student.getName().equals(searchName)) {
				student.setYear(4);
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("검색 실패!");
		}
		System.out.println(studentList);
		
		
//		for(Student su : studentList) {
//			
//			if(su.getName().equals(searchName)) {
//				su.setYear(4);
//				flag = false;
//				break;
//			}
//		}
//		if(flag) {
//			System.out.println();
//			System.out.println("검색 실패!");	
//		}
//		System.out.println(studentList);
		
		updateYear(studentList, "홍길동", 3);
		System.out.println(studentList);
		
		
		
	}
}
