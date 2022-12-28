package j01_출력;

public class Output1 {
	public static void main(String[] args) {
		System.out.print("이름: ");
		System.out.println("최해혁");
		System.out.print("나이: ");
		// 밑의 두개는 문자열인지 정수인지 ! 잘 구분해서 쓰기
		// 문자열에 더하기 연산을 하게 되면 어떤 형이든 문자열로 변환되서 추가된다.
		System.out.println("31"+1);
		System.out.println(31+1);
		System.out.println("이름: " + "최해혁");
	}
}
