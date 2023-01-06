package j12_배열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;

		
		
		N = sc.nextInt();
		
		int[] a = new int[N];
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		long max = 0;
		long sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
			sum = sum + a[i];
		}
		
		double answer = 0.0;
		
		answer = sum * 100.0 / max / N;
		
		System.out.println(answer); 
	}
}
