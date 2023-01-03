package j06_조건;

import java.util.Scanner;

public class Conditional3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int score = 0;
		String grade = null;
		
		System.out.print("점수 입력: ");
		score = sc.nextInt();
		
		/*
		 *  0 보다 작고 100보다 큰 경우 
		 *  
		 *  60밑은 f
		 *  70밑은 d
		 *  80밑은 c
		 *  90밑은 b
		 *  이상은 a
		 *  
		 *  플러스 학점
		 *  65, 75, 85, 95 
		 */
		
//		if(score < 0 || score > 100) {
//			System.out.println("계산 불가");
//		}else if(score > 94) {
//			grade = "A+";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else if(score > 89) {
//			grade = "A";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else if(score > 84) {
//			grade = "B+";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else if(score > 79) {
//			grade = "B";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else if(score > 74) {
//			grade = "C+";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else if(score > 69) {
//			grade = "C";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else if(score > 65) {
//			grade = "D+";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else if(score > 59) {
//			grade = "D";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else {
//			grade = "F";
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}
//		
//		if (score < 101 && score > -1) {
//			if(score > 89) {
//				grade = "A";
//			}else if(score > 79) {
//				grade = "B";
//			}else if(score > 69) {
//				grade = "C";
//			}else if(score > 59) {
//				grade = "D";
//			}else {
//				grade = "F";
//			}
//			if((score > 59 && score < 101) && (score % 10 > 4 || score == 100)) {
//				grade += "+";
//			}
//			System.out.println("점수(" + score + "): " + grade + "학점");
//		}else {
//			System.out.println("계산 불가");
//		}
		
		// 각각의 기능에 맞게 응집시켜서 묶어둔다.
		// 첫 if else문은 score 관련 grade를 나누는 작업
		// 두번째는 플러스에 관한 작업
		// 세번째는 계산불가 부분인지 출력가능 부분인지 나누는 작업
		
		if(score < 0 || score > 100) {
			grade = null;
		}else if (score > 89) {
			grade = "A";
		}else if (score > 79) {
			grade = "B";
		}else if (score > 69) {
			grade = "C";
		}else if (score > 59) {
			grade = "D";
		}else {
			grade = "F";
		}
		
		if((score > 59 && score < 101) && (score % 10 > 4 || score == 100)) {
			grade += "+";
		}
		
		if(grade == null) {
			System.out.println("계산 불가");
		}else {
			System.out.println("점수(" + score + "): " + grade + "학점");
		}
		
				
		
	}
}
