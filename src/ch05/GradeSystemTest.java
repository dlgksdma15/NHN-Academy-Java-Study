package ch05;

/**
 * 학급 성적 관리 시스템
 */
class ClassGradeSystem {
    private Student[] students;
    private String[] subjects;
    private int studentCount;
    private final int MAX_STUDENTS = 40;

    // 생성자
    public ClassGradeSystem(String[] subjects) {
        this.subjects = subjects;
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }

    // 학생 추가
    public void addStudent(String id, String name) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("학급 정원이 초과되었습니다.");
            return;
        }

        students[studentCount] = new Student(id, name, subjects);
        studentCount++;
        System.out.println(name + " 학생이 등록되었습니다.");
    }

    // 학번으로 학생 찾기
    public Student findStudent(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                return students[i];
            }
        }
        return null;
    }

    // 전체 학급 평균
    public double getClassAverage() {
        if (studentCount == 0) return 0;

        double sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += students[i].getAverage();
        }
        return sum / studentCount;
    }

    // 과목별 평균
    public double getSubjectAverage(String subject) {
        if (studentCount == 0) return 0;

        int sum = 0;
        int count = 0;

        for (int i = 0; i < studentCount; i++) {
            int score = students[i].getScore(subject);
            if (score >= 0) {
                sum += score;
                count++;
            }
        }

        return count > 0 ? (double) sum / count : 0;
    }

    // 성적 순위 (평균 기준)
    public void printRanking() {
        // 학생 배열 복사 (원본 보존)
        Student[] sorted = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            sorted[i] = students[i];
        }

        // 버블 정렬 (평균 점수 기준 내림차순)
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - 1 - i; j++) {
                if (sorted[j].getAverage() < sorted[j + 1].getAverage()) {
                    Student temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }

        // 순위 출력
        System.out.println("\n=== 성적 순위 ===");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%d위: %s (%.2f점)\n",
                    i + 1, sorted[i].getName(), sorted[i].getAverage());
        }
    }

    // 전체 성적표
    public void printClassReport() {
        System.out.println("\n=== 학급 성적표 ===");
        System.out.println("학급 인원: " + studentCount + "명");
        System.out.printf("학급 평균: %.2f점\n", getClassAverage());

        System.out.println("\n과목별 평균:");
        for (String subject : subjects) {
            System.out.printf("  %s: %.2f점\n", subject, getSubjectAverage(subject));
        }

        printRanking();
    }
}

// 테스트
public class GradeSystemTest {
    public static void main(String[] args) {
        String[] subjects = {"국어", "영어", "수학", "과학"};
        ClassGradeSystem gradeSystem = new ClassGradeSystem(subjects);

        // 학생 등록
        gradeSystem.addStudent("2024001", "김철수");
        gradeSystem.addStudent("2024002", "이영희");
        gradeSystem.addStudent("2024003", "박민수");
        gradeSystem.addStudent("2024004", "정수진");

        // 점수 입력
        Student student1 = gradeSystem.findStudent("2024001");
        if (student1 != null) {
            student1.setScore("국어", 85);
            student1.setScore("영어", 90);
            student1.setScore("수학", 88);
            student1.setScore("과학", 92);
        }

        Student student2 = gradeSystem.findStudent("2024002");
        if (student2 != null) {
            student2.setScore("국어", 92);
            student2.setScore("영어", 88);
            student2.setScore("수학", 95);
            student2.setScore("과학", 90);
        }

        Student student3 = gradeSystem.findStudent("2024003");
        if (student3 != null) {
            student3.setScore("국어", 78);
            student3.setScore("영어", 82);
            student3.setScore("수학", 85);
            student3.setScore("과학", 80);
        }

        Student student4 = gradeSystem.findStudent("2024004");
        if (student4 != null) {
            student4.setScore("국어", 88);
            student4.setScore("영어", 95);
            student4.setScore("수학", 82);
            student4.setScore("과학", 87);
        }

        // 전체 성적표 출력
        gradeSystem.printClassReport();
    }
}