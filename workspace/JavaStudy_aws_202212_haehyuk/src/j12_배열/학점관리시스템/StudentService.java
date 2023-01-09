package j12_배열.학점관리시스템;

import java.util.Scanner;



public class StudentService {

	
	private final Scanner scanner;
	private final StudentRepository repository;
	private Student student;

	public StudentService(Student student, StudentRepository repository) {

		scanner = new Scanner(System.in);
		this.student = student;
		this.repository = repository ;

	}

	// run 을 했을 때 학생의 이름, 학생의 점수를 입력받는다.
	// 입력 받은 정보로 A,B,C,D,F 학점으로 나누어 출력하는 시스템

	public void run() {
		boolean loopFlag = true;
		char select = '\0';

		while(loopFlag) {
			showGradeTransferSystemView();
			select = inputSelected("학점 관리 시스템");
			loopFlag = mainMenu(select);
		}
	}

	public void stop() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중....(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}

	private void showGradeTransferSystemView() {
		System.out.println("======== << 학점 관리 시스템 >> ========");
		System.out.println("1. 학생 이름, 점수 입력: ");
		System.out.println("2. 학생 이름, 점수 확인: ");
		System.out.println("3. 학생 이름, 학점 확인: ");
		System.out.println("========================================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}

	private char inputSelected(String menuName) {
		System.out.print(menuName + "메뉴 선택: ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();
		return select;
	}

	private void showStudent() {
		Student[] students = repository.getStudent();
		
		System.out.println("=====<<학생 정보 조회>>=====");
		
		for(Student student : students) {
			System.out.println(student.toString());
		}
		
		System.out.println("============================");
	}

	private void registerStudent() {
		
		
		System.out.println("학생 이름: ");
		student.setName(scanner.nextLine());

		System.out.println("점수 입력: ");
		student.setScore(scanner.nextInt());
		scanner.nextLine();

		repository.saveStudent(student);

	}
	
	private void scoreToGrade(String name, int score) {
		
		name = student.getName();
		score = student.getScore();

		if(score < 0 || score > 100) {
			System.out.println("학점 변환이 어렵습니다, 다시 입력해주세요.");
		}else if(score > 89) {
			System.out.println(name + " 학생의 학점은 A학점입니다");
		}else if(score > 79) {
			System.out.println(name + " 학생의 학점은 B학점입니다");
		}else if(score > 69) {
			System.out.println(name + " 학생의 학점은 C학점입니다");
		}else if(score > 59) {
			System.out.println(name + " 학생의 학점은 D학점입니다");
		}else {
			System.out.println(name + " 학생의 학점은 F학점입니다");
		}
	}

	private boolean mainMenu(char select) {
		boolean flag = true;
		Student student = new Student();
		
		String name = student.getName();
		int score = student.getScore();

		if(isExit(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				registerStudent();

			}else if(select == '2') {
				showStudent();
			}else if(select == '3') {
				scoreToGrade(name, score);
			}
			else {
				System.out.println(errorMessage());
			}
			System.out.println();
		}
		return flag;
	}

	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}

	private String errorMessage() {
		return "### <<< 번호를 다시 입력해주세요. >>> ###";
	}

}
