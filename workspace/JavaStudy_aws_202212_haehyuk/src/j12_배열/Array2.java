package j12_배열;


public class Array2 {
	
	public static void printNames(String[] names) {
		for(int i = 0; i < names.length; i++) {
			System.out.println("이름[" + (i + 1) + "]: " + names[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		String[] names = new String[3];
		
		// 선언방식 1번째 들어갈 값이 정확하지 않을 때 , 들어갈 공간이 확실할 때 크기를 지정한다.
		names[0] = "홍길동";
		names[1] = "김유신";
		names[2] = "이순신";
		
		// 들어갈 값이 정확할 때 크기를 지정하지 않는다
		String[] names2 = new String[] {"장보고", "세종대왕", "이을용"};
		
		// 배열의 초기화와 선언에서만 인정을 한다.
		String[] names3 = {"설기현", "박지성", "이천수", "손흥민"};
		
		printNames(names);
		printNames(new String[] {"이정재", "원빈", "장동건"});
		printNames(names3);
		
		
	}
}
