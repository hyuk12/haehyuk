package j08_메소드;

public class Method1 {
	
	public static int sum(int x, int y) {
		int result = x + y;
		return result;
	}
	
	public static void main(String[] args) {
		
		int a1 = 10;
		int b1 = 20;
		
		int a2 = 20;
		int b2 = 30;
		
		int a3 = 30;
		int b3 = 40;
		
		int total1 = 0;
		int total2 = 0;
		int total3 = 0;
		
		total1 = a1 + b1;
		total2 = a2 + b2;
		total3 = sum(a3, b3);
		
		
		System.out.println(total1);
		System.out.println(total2);
		System.out.println(total3);
	}
}
