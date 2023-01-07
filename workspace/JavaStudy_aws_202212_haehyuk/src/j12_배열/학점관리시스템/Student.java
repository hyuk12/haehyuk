package j12_배열.학점관리시스템;

public class Student {
	
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getScore() {

		return score;
	}

	public void setScore(int score) {

		this.score = score;
	}

	@Override
	public String toString() {

		return "학생의 이름= " + name + ", 점수= " + score ;
	}
	
	
	
}
