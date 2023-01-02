package j04_연산자;

public class Operation6 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 	시험 성적을 학점으로 계산하는 프로그램
		 * 	
		 * 	정수 자료형 score 변수 선언
		 * 	88 점으로 초기화
		 * 
		 * 	문자 자료형 grade 변수 선언
		 * 
		 * 	조건 
		 * 	score 가 0점보다 작거나 100점보다 크면  X를 출력
		 * 	score 가 90에서 100점이면 A학점
		 * 	score 가 80에서 89점이면 B학점
		 * 	score 가 70에서 79점이면 C학점
		 * 	score 가 60에서 69점이면 D학점
		 * 	score 가 0에서 59점이면 F학점
		 * 
		 * 
		 */
		
		int score = 58;
		
		char grade = score > 100 || score < 0 ? 'X'
				: score > 89 ? 'A' 
				: score > 79 ? 'B' 
				: score > 69 ? 'C'
				: score > 59 ? 'D': 'F';
				
		char plus = score > 100 || score < 60 ? '\0' : score % 10 > 4  || score == 100 ? '+' : '\0';
				
				
	    System.out.println("점수(" + score + "): " + grade + plus + "학점"  );
		
		
	}
}
