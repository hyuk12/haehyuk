package j01_exam_산대특;

import java.util.Arrays;
import java.util.List;

class SubjectService {
    private List<String> subjects;

    public SubjectService(List<String> subjects) {
        this.subjects = subjects;
    }

    public void showSubjects() {
        int length = 4;
        length = subjects.size();
        for (int i = 0; i < length; i++) {
            System.out.println(subjects.get(i));
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        List<String> subjects = Arrays.asList(new String[]{"C", "Java", "Python"});

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        SubjectService subjectService = new SubjectService(subjects);
        subjectService.showSubjects();
    }
}
