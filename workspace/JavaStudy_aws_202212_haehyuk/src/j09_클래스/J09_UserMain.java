package j09_클래스;

public class J09_UserMain {
	
	public static void main(String[] args) {
		
		J09_User userA = new J09_User("hong12", "1212", "홍길동", "hong12@gmail.com");
		J09_User userB = new J09_User();
		
//		userA.username = "honggildong12";
//		userA.password = "1234";
//		userA.name = "홍길동";
//		userA.email = "hong12@gmail.com";
//		
		userB.username = "sunsin12";
		userB.password = "1234";
		userB.name = "이순신";
		userB.email = "sunsin12@gmail.com";
		
		userA.printUserInfo();
		userB.printUserInfo();
		
		
	}

}
