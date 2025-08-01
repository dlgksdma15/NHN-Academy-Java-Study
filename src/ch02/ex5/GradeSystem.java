package ch02.ex5;

public class GradeSystem {
    public static void main(String[] args) {
        System.out.println("=== 성적 처리 시스템 ===");

        String name = "김학생";
        int midterm = 85;
        int finalExam = 92;
        int homework = 88;
        int attendance = 95;

        double weightedScore = midterm * 0.3 + finalExam * 0.4 + homework * 0.2 + attendance * 0.1;

        // 학점 계산 (조건 연산자 중첩)
        String grade = weightedScore >= 95 ? "A+"
                : weightedScore >= 90 ? "A"
                : weightedScore >= 85 ? "B+"
                : weightedScore >= 80 ? "B"
                : weightedScore >= 75 ? "C+"
                : weightedScore >= 70 ? "C"
                : weightedScore >= 65 ? "D+"
                : weightedScore >= 60 ? "D"
                : "F";

        // 장학금 자격 판별
        String scholarship = (weightedScore >= 90 && attendance >= 90) ? "장학금 자격 있음" : "없음";

        // 출력
        System.out.printf("학생: %s%n", name);
        System.out.printf("중간고사: %d (30%%)%n", midterm);
        System.out.printf("기말고사: %d (40%%)%n", finalExam);
        System.out.printf("과제: %d (20%%)%n", homework);
        System.out.printf("출석: %d (10%%)%n", attendance);
        System.out.printf("총점: %.1f%n", weightedScore);
        System.out.printf("학점: %s%n", grade);
        System.out.printf("장학금 자격: %s%n", scholarship);
    }
}
