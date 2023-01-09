package j12_배열;

import java.util.Scanner;

// 서비스 클래스 (기능 , 로직등)
public class J12_UserService {
	
	private Scanner scanner;
	private J12_UserRepository repository;
	
	
	public J12_UserService(J12_UserRepository repository) {
		scanner = new Scanner(System.in);
		this.repository = repository;
		
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
		String username = null;
		String password = null;
		String name = null;
		String email = null;
		
		System.out.println("========<< 회원 등록 >>========");
		System.out.print("사용자 이름: ");
		username = scanner.nextLine();
		
		System.out.print("사용자 비번: ");
		password = scanner.nextLine();
		
		System.out.print("사용자 성명: ");
		name = scanner.nextLine();
		
		System.out.print("사용자 메일: ");
		email = scanner.nextLine();
				
		System.out.println("===============================");
		
		J12_User user = new J12_User(username, password, name, email);
		repository.saveUser(user);
	}
	
	private void showUser() {
		J12_User user = null;
		
		System.out.println("============<<회원 조회>>============");
		user = verifyUsername();
		
//		System.out.println("사용자이름 입력: ");
//		username = scanner.nextLine();
//		
//		user = repository.findUserByUsername(username);
		
		if(user == null) {
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		}
		
		System.out.println(user.toString());
		System.out.println("====================================");
	}
	
	private J12_User verifyUsername() {
		String username = null;
		System.out.println("사용자이름: ");
		username = scanner.nextLine();
		return repository.findUserByUsername(username);
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
				showUser();
			}else if(select == '4') {
				updateUser();
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
		
		return flag;
	}
	
	private void updateUser() {
		J12_User user = verifyUsername();
		
		if(user == null) {
			System.out.println("존재하지 않는 사용자 이름입니다.");
			return;
		}
		
		boolean updateLoopFlag = true;
		char select = '\0';
		
		while(updateLoopFlag) {
			
			showUpdateMenu(user);
			select = inputSelect("수정");
			updateLoopFlag = updateMain(user, select);
			
			
		}
	}
	
	private void showUpdateMenu(J12_User user) {
		System.out.println("==========<< 수정 메뉴 >>===========");
		System.out.println("사용자이름 : " + user.getUsername());
		System.out.println("====================================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("====================================");
		System.out.println("b. 뒤로가기");
		System.out.println();
	}
	
	private boolean updateMain(J12_User user, char select) {
		
		boolean flag = true;
		
		if(isBack(select)) {
			flag = false;
			
		}else if(select == '1') {
			updatePassword(user);
		}else if(select == '2') {
			updateName(user);
		}else if(select == '3') {
			updateEmail(user);
		}else {
			System.out.println(getSelectedErrorMessage());
		}
		return flag;
	}

	
	private void updatePassword(J12_User user) {
		String oldPassword = null; 
		String newPassword = null; 
		String newPasswordCheck = null;
		
		System.out.println("============<<비번 변경>>============");
		
		System.out.println("기존의 비밀번호를 입력하세요");
		oldPassword = scanner.nextLine();
		
		if(!compareVeriable(user.getPassword(), oldPassword)) {
			System.out.println("비밀번호 서로 일치하지 않습니다");
			return;
		}
		
		System.out.print("새로운 비밀번호를 입력하세요: ");
		newPassword = scanner.nextLine();
		System.out.print("새로운 비밀번호를 확인해주세요: ");
		newPasswordCheck = scanner.nextLine();
		
		if(!compareVeriable(newPassword, newPasswordCheck)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		user.setPassword(newPassword);
		System.out.println("비밀번호 변경 완료");
	}
	
	
	
	private void updateName(J12_User user) {
		String oldName = null; 
		String newName = null; 
		String confirmName = null;
		
		System.out.println("============<<이름 변경>>============");
		
		System.out.println("기존의 이름을 입력하세요");
		oldName = scanner.nextLine();
		
		if(!compareVeriable(user.getName(), oldName)) {
			System.out.println("이름이 서로 일치하지 않습니다");
			return;
		}
		
		System.out.print("새로운 이름을 입력하세요: ");
		newName = scanner.nextLine();
		System.out.print("새로운 이름을 확인해주세요: ");
		confirmName = scanner.nextLine();
		
		if(compareVeriable(newName, confirmName)) {
			System.out.println("이름이 일치하지 않습니다.");
			return;
		}
		
		user.setName(newName);
		System.out.println("이름 변경 완료");
	}
	
	private void updateEmail(J12_User user) {
		String oldEmail = null; 
		String newEmail = null; 
		String confirmEmail = null;
		
		System.out.println("============<<메일 변경>>============");
		
		System.out.println("기존의 이메일을 입력하세요");
		oldEmail = scanner.nextLine();
		
		if(!compareVeriable(user.getEmail(), oldEmail)) {
			System.out.println("이메일이 서로 일치하지 않습니다");
			return;
		}
		
		System.out.print("새로운 이메일을 입력하세요: ");
		newEmail = scanner.nextLine();
		System.out.print("새로운 이메일을 확인해주세요: ");
		confirmEmail = scanner.nextLine();
		
		if(compareVeriable(newEmail, confirmEmail)) {
			System.out.println("이메일이 일치하지 않습니다.");
			return;
		}
		
		user.setEmail(newEmail);
		System.out.println("이메일 변경 완료");
	}
	
	private boolean compareVeriable(String preVeriable, String nextVeriable) {
		return preVeriable.equals(nextVeriable);
	}
	
	private boolean isBack(char select) {
		return select == 'b' || select == 'B';
	}
	
	
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	private String getSelectedErrorMessage() {
		return "###<<< 잘못된 입력입니다, 다시 입력하세요. >>>###";
	}
}
