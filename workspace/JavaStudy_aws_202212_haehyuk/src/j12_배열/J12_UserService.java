package j12_배열;

import java.util.Scanner;

// 서비스 클래스 (기능 , 로직등)
public class J12_UserService {
	
	private Scanner scanner;
	private J12_UserRepository repository;
	private J12_User user;
	public J12_UserService(J12_User user, J12_UserRepository repository) {
		scanner = new Scanner(System.in);
		this.repository = repository;
		this.user = user;
	}
	
	public void run() {
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
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
	
	private char inputSelect(String menuName) {
		System.out.print(menuName + "메뉴 선택: ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();
		return select;
	}
	
	private void showMainMenu() {
		System.out.println("========<< 메인메뉴 >>========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==============================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	private void showUsers() {
		J12_User[] users = repository.getUserTable();
		
		System.out.println("========<< 회원 전체 조회 >>========");
		
		for(J12_User user : users) {
			System.out.println(user.toString());
		}
		
		System.out.println("====================================");
	}
	
	
	private void registerUser() {
		
		
		System.out.println("========<< 회원 등록 >>========");
		System.out.println("사용자 이름: ");
		user.setUsername(scanner.nextLine());
		
		System.out.println("사용자 비번: ");
		user.setPassword(scanner.nextLine());
		
		System.out.println("사용자 성명: ");
		user.setName(scanner.nextLine());
		
		System.out.println("사용자 메일: ");
		user.setEmail(scanner.nextLine());
				
		System.out.println("===============================");
		
		repository.saveUser(user);
	}
	
	private void findByUsernamePrint() {
		System.out.println("사용자이름 입력: ");
		System.out.println(repository.findUserByUsername(scanner.nextLine()));
	}
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				showUsers();
			}else if(select == '2') {
				registerUser();
			}else if(select == '3') {
				findByUsernamePrint();
			}else if(select == '4') {
				updateMainView();
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
		
		return flag;
	}
	
	private void updateMainView() {
		
		boolean updateLoopFlag = true;
		char select = '\0';
		
		while(updateLoopFlag) {
			
			
			updateUserCheck();
			updateShowMainMenu();
			select = inputSelect("수정");
			updateLoopFlag = updateMain(select);
			
			
		}
	}
	
	private void updateUserCheck() {
		String checkUsername = null;
		System.out.println("수정 할 사용자 이름을 입력하세요: ");
		
		checkUsername = repository.findUserByUsername(scanner.nextLine()).getUsername();
		
		System.out.println("==========<< 수정 메뉴 >>===========");
		if(checkUsername.equals(user.getUsername())) {
			System.out.println("사용자이름 : " + user.getUsername());
		}else {
			System.out.println("해당 사용자이름은 존재하지 않는 사용자 이름입니다.");
		}
		
		System.out.println("====================================");
	}
	
	
	private void updateShowMainMenu() {
		System.out.println("====================================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("====================================");
		System.out.println("b. 뒤로가기");
		System.out.println();
	}
	
	private boolean updateMain(char select) {
		
		boolean flag = true;
		
		if(backMenu(select)) {
			flag = false;
			
		}else if(select == '1') {
			updatePassword();
		}else if(select == '2') {
			updateName();
		}else if(select == '3') {
			updateEmail();
		}else {
			System.out.println(getSelectedErrorMessage());
		}
		return flag;
	}

	
	private void updatePassword() {
		String oldPassword ; 
		
		System.out.println("기존의 비밀번호를 입력하세요");
		oldPassword = scanner.nextLine();
		
		if(user.getPassword().equals(oldPassword)) {
			String newPassword; 
			String newPasswordCheck;
			
			System.out.print("새로운 비밀번호를 입력하세요: ");
			newPassword = scanner.nextLine();
			
			
			System.out.print("새로운 비밀번호를 확인해주세요: ");
			newPasswordCheck = scanner.nextLine();
			
			System.out.println();
			
			if(newPassword.equals(newPasswordCheck) && !newPassword.equals(oldPassword)) {
				user.setPassword(newPassword);
				System.out.println("비밀번호 변경완료!");
				return;
			}else {
				System.out.println("비밀번호 서로 일치하지 않습니다");
				return;
				
			}
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
	}
	
	
	private void updateName() {
		String oldName; 
		

		System.out.println("기존의 이름을 입력하세요");
		oldName = scanner.nextLine();
		
		if(user.getName().equals(oldName)) {
			String newName; 
			String newNameCheck;
			
			System.out.print("새로운 이름을 입력하세요: ");
			newName = scanner.nextLine();
			
			
			System.out.print("새로운 이름을 확인해주세요: ");
			newNameCheck = scanner.nextLine();
			
			System.out.println();
			
			if(newName.equals(newNameCheck) && !newName.equals(oldName)) {
				user.setName(newName);
				System.out.println("이름 변경완료!");
				return;
			}else {
				System.out.println("이름이 서로 일치하지 않습니다");
				return;
				
			}
		}else {
			System.out.println("이름이 일치하지 않습니다.");
			return;
		}
	}
	
	private void updateEmail() {
		String oldEmail; 
		
		System.out.println("기존의 이메일을 입력하세요");
		oldEmail = scanner.nextLine();
		
		if(user.getEmail().equals(oldEmail)) {
			String newEmail; 
			String newEmailCheck;
			
			System.out.print("새로운 이메일을 입력하세요: ");
			newEmail = scanner.nextLine();
			System.out.println();
			
			System.out.print("새로운 이메일을 확인해주세요: ");
			newEmailCheck = scanner.nextLine();
			
			System.out.println();
			
			if(newEmail.equals(newEmailCheck) && !newEmail.equals(oldEmail)) {
				user.setEmail(newEmail);
				System.out.println("이메일 변경완료!");
				return;
			}else {
				System.out.println("이메일이 서로 일치하지 않습니다");
				return;
				
			}
		}else {
			System.out.println("이메일이 일치하지 않습니다.");
			return;
		}
	}
	
	private boolean backMenu(char select) {
		return select == 'b' || select == 'B';
	}
	
	
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	private String getSelectedErrorMessage() {
		return "###<<< 잘못된 입력입니다, 다시 입력하세요. >>>###";
	}
}
