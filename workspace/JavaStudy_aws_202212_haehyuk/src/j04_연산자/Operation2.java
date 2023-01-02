package j04_연산자;

public class Operation2 {
	public static void main(String[] args) {
		int num = 10;
		
		num = num + 1;
//		++num; 해당 라인에서 바로 1을 더해서 변수에 대입(선 증가)
//		num++; 해당 라인에서 1을 더 하지만 변수에 대입은 되어있지 않다 (후 증가)
		
		System.out.println(num++);
		System.out.println(num);
	}
}
