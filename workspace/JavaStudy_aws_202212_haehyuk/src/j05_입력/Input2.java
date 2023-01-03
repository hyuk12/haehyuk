package j05_입력;

import java.util.Scanner;

public class Input2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = null;
		String str2 = null;
		
		int number1 = 0;
		double number2 = 0;
		
		System.out.println("문자열1: ");
		str1 = sc.nextLine();
		
		System.out.println("문자열2: ");
		str2 = sc.next();
		
		System.out.println("정수: ");
		number1 = sc.nextInt();
		
		System.out.println("실수: ");
		number2 = sc.nextDouble();
		
		System.out.println("문자열1: " + str1);
		System.out.println("문자열2: " + str2);
		System.out.println("정수: " + number1);
		System.out.println("실수: " + number2);
		
	}
}
