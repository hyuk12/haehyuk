package j05_입력;

import java.util.Scanner;

public class Input1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		
		System.out.print("입력1: ");
		num1 = sc.nextInt();
		
		System.out.print("입력2: ");
		num2 = sc.nextInt();
		
		System.out.print("입력3: ");
		num3 = sc.nextInt();
		
		System.out.print("입력4: ");
		num4 = sc.nextInt();
		
		System.out.print("입력5: ");
		num5 = sc.nextInt();
		
		System.out.println("입력값: " + (num1 + num2 + num3 + num4 + num5));
	}
}
