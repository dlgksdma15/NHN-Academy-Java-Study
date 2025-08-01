package ch04.ex2;

public class GradeManager {
    // 멤버 변수
    private static final int MAX_STUDENTS = 30;
    private static String[] names = new String[MAX_STUDENTS];
    private static int[] scores = new int[MAX_STUDENTS];
    private static int studentCount = 0;

    public static void main(String[] args) {
        System.out.println("=== 성적 관리 프로그램 ===");

        // 샘플 학생 추가
        addStudent("김철수", 85);
        addStudent("이영희", 92);
        addStudent("박민수", 78);
        addStudent("최유진", 88);
        addStudent("정하늘", 95);

        // 기능 테스트
        showAllStudents();
        showStatistics();
        findStudent("이영희");
        findStudent("홍길동"); // 없는 학생
    }

    // 학생 추가
    public static void addStudent(String name, int score) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("더 이상 학생을 추가할 수 없습니다.");
            return;
        }
        if (score < 0 || score > 100) {
            System.out.println("점수는 0~100 사이여야 합니다.");
            return;
        }
        names[studentCount] = name;
        scores[studentCount] = score;
        studentCount++;
        System.out.println("학생이 추가되었습니다: " + name);
    }

    // 전체 학생 조회
    public static void showAllStudents() {
        if (studentCount == 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }
        System.out.println("\n번호\t이름\t점수\t학점");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%d\t%s\t%d\t%s\n", i + 1, names[i], scores[i], getGrade(scores[i]));
        }
    }

    // 통계 보기
    public static void showStatistics() {
        if (studentCount == 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }
        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        for (int i = 0; i < studentCount; i++) {
            sum += scores[i];
            if (scores[i] > max) max = scores[i];
            if (scores[i] < min) min = scores[i];
        }
        double avg = (double) sum / studentCount;
        System.out.printf("\n학생 수: %d명\n평균 점수: %.1f점\n최고 점수: %d점\n최저 점수: %d점\n",
                studentCount, avg, max, min);
    }

    // 학생 검색
    public static void findStudent(String searchName) {
        for (int i = 0; i < studentCount; i++) {
            if (names[i].equals(searchName)) {
                System.out.printf("학생 찾음 → %s: %d점 (%s)\n", names[i], scores[i], getGrade(scores[i]));
                return;
            }
        }
        System.out.println("학생을 찾을 수 없습니다: " + searchName);
    }

    // 학점 계산
    public static String getGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }
}
