package j05_입력;

import java.util.Scanner;

public class Input3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		int age = 0;
		String address = null;
		String phoneNumber = null;
		
		System.out.print("이름: ");
		name = sc.next();
		
		System.out.print("나이: ");
		age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("주소: ");
		address = sc.nextLine();
		
		System.out.print("연락처: ");
		phoneNumber = sc.next();
		
		System.out.println("사용자의 이름은 " + name + "이고 나이는 " + age + "살입니다.\n주소는 " 
		+ address + "에 거주중입니다.\n연락처는 " + phoneNumber + " 입니다.");
	}
}
