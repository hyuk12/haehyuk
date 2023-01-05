package j03_형변환;

public class Casting2 {
	public static void main(String[] args) {
		char char_a = 'a';
		int num = (int)char_a; // (int) 생략가능 묵시적 형 변환 업캐스팅 상위의 자료형으로 변환
		
		char char_b = (char) (num + 1); // 다운 캐스팅 상위의 자료형이 하위로 내려가는 변환 무조건 명시적 형 변환
		System.out.println(char_b);
	}
}
