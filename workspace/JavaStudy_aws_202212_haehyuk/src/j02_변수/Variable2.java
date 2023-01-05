package j02_변수;

public class Variable2 {
	public static void main(String[] args) {
		// 문자형의 변수 선언과 초기화 
		// 문자열과 혼돈 하지 않는다 문자형은 항상 값에 작은 따옴표만 사용가능하다.
		
		// 본래 문자형은 숫자로 이루어져 있고 자바에서 문자형으로 표기가 될 뿐 숫자가 나오는 것이 맞다
		// 문자형은 아스키 코드를 따른다. 영어권에선 아스키 코드로 가능했지만 한글과 한문등 다른언어를 표기하기엔 불가능
		// 그래서 유니코드라는 것이 나왔다. 자바는 그래서 2byte이다.
		char firstName1 = '해';
		char firstName2 = '혁';
		
		char alphabetA = 'A';
		
		System.out.println("최" + firstName1 + firstName2);
		System.out.println("alphabetA: " +alphabetA);
		
		System.out.println(alphabetA + 'B');// 아스키코드
		System.out.println('\uAC00'); // 유니코드
		
		System.out.println(firstName1 + 0);
	}
}
