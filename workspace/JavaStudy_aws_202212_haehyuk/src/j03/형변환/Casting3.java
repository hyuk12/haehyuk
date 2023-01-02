package j03.형변환;

public class Casting3 {
	public static void main(String[] args) {
		double kor = 87.5;
		double eng = 95.7;
		double math = 80.5;
		
		// 각각의 점수들의 소수점을 빼고 합계를 내라 
		// 그 합계의 평균을 실수형으로 표시해라.
		
		int total = (int) kor + (int) eng + (int) math ;
		double avg = (double) total / 3.0;
		
		System.out.println("total: " + total);
		System.out.println("avg: " + avg);
		
	}
}
