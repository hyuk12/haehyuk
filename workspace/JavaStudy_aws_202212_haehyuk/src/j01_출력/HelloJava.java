package j01_출력;

import j17_스태틱.싱글톤.Kia;

public class HelloJava {
	// 프로그램의 시작점
	public static void main(String[] args) {
		// tab 들여쓰기 코드의 가독성을 높인다.
        // 주석: 코드 내부에 메모를 할 때 사용을 한다.
        // 컴파일시에 무시된다.
        // 한줄 주석
        /*
        	여러줄 주석
        	1
        	2
        	3
        */
		
		/**
		 *  클래스, 메소드 등의 정보를 설명하기 위한 주석
		 */
		// print 와 println 줄바꿈이 되는 것과 안되는 것 
		// System.out < 콘솔 
		// 
		
		System.out.println("Hello World!"); // 한 줄의 문자열을 출력 후 줄 바꿈 하여라.
		System.out.print("이름: 최해혁\n");
		System.out.print("주소: 부산광역시 부산진구 전포동\n");
		System.out.print("나이: 31\n");
		System.out.print("연락처: 010-3922-3637\n");
		System.out.print("수업: AWS기반 공공빅데이터 활용 웹개발자 양성\n");

		Kia.getInstance().printCompanyName();
	}
}
