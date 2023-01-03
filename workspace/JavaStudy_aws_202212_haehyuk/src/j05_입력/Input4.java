package j05_입력;

import java.util.Scanner;

public class Input4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		int max = 0;
		int min = 0;
		
		System.out.print("정수 3개 입력: ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		max = a;
		max = b > max ? b : max;
		max = c > max ? c : max;
				
		
		min = a;
		min = b < min ? b : min;
		min = c < min ? c : min;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
				
		System.out.println("최댓값: " + max);		
	    System.out.println("최솟값: " + min);
	}
}
