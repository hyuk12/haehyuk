package j09_클래스;

public class J09_User {
	
	String username;
	String password;
	String name;
	String email;
	
	J09_User() {}
	
	J09_User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	void printUserInfo() {
		System.out.println("아이디: " + username);
		System.out.println("비밀번호: " + password);
		System.out.println("이름: " + name);
		System.out.println("이메일: " + email);
		System.out.println();
	}
}
