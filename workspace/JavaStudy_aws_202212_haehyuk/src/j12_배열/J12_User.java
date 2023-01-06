package j12_배열;

// 정보를 담는 객체 - >  Entity 객체
// 실행을 담당하는 객체 (기능을 담당하는 객체) -> 서비스 객체
public class J12_User {
	private String username;	// 사용자이름(아이디, 계정)
	private String password;	// 사용자비밀번호
	private String name;		// 실제이름(성명)
	private String email;		// 이메일
	
	public J12_User() {} 		// ctrl + spacebar
	
	// alt + shift + s -> generated constructor using fields
	public J12_User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	// alt + shift + s -> generated Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// alt + shift + s -> generated toString(); 정보에는 클래스명, 변수에 어떤 값이 담겨 있는지 표현해준다. 
	//	이전까지 했던 printInfo 메서드와 비슷한 개념
	
	@Override
	public String toString() {
		return "J12_User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}
	
	
	
	
}
