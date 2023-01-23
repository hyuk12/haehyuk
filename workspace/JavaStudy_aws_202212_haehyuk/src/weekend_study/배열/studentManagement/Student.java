package weekend_study.배열.studentManagement;

public class Student {


    // 콘솔창에 while 문이 돌건데 그안에 print
    // 학생관리 프로그램메뉴
    // 학생전체조회 1
    // 학생 등록 create 2
    // 학생 수정 update 3
    // 학생 삭제 delete 4
    // 학생 정보 조회 read 5
    // 나가기  q

    private String name;

    private int kor;
    private int eng;
    private int math;
    private int totalScore;
    private int avgScore;
    private char grade;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        calculation();

    }

    public void updateStudent(Student updateStudent) {
        this.kor = updateStudent.kor;
        this.eng = updateStudent.eng;
        this.math = updateStudent.math;

        calculation();
    }

    public String getName() {
        return name;
    }

    private void calculation() {
        setTotalScore();
        setAvgScore();
        setGrade();
    }

    private void setTotalScore() {
        totalScore = kor + eng + math;
    }

    private void setAvgScore() {
        avgScore = totalScore / 3;
    }

    private void setGrade() {
        if (avgScore > 89) {
            grade = 'A';
        }else if (avgScore > 79) {
            grade = 'B';
        }else if (avgScore > 69) {
            grade = 'C';
        }else if (avgScore > 59) {
            grade = 'D';
        }else {
            grade = 'F';
        }
    }
}
