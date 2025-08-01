package ch03.ex5;

import textio.TextIO;

public class GradeSystem {
    public static void main(String[] args) {
        System.out.print("점수를 입력하세요 (0-100): ");
        double score = TextIO.getlnDouble();

        String grade;
        String comment;

        // 입력 검증
        if (score < 0 || score > 100) {
            System.out.println("유효하지 않은 점수입니다!");
            return;
        }

        // 등급 결정
        if (score >= 90) {
            grade = "A";
            comment = "우수한 성과입니다!";
        } else if (score >= 80) {
            grade = "B";
            comment = "좋은 결과입니다.";
        } else if (score >= 70) {
            grade = "C";
            comment = "보통입니다.";
        } else if (score >= 60) {
            grade = "D";
            comment = "노력이 필요합니다.";
        } else {
            grade = "F";
            comment = "불합격입니다.";
        }

        System.out.println("\n=== 성적 결과 ===");
        System.out.printf("점수: %.1f%n", score);
        System.out.println("등급: " + grade);
        System.out.println("평가: " + comment);

        // 장학금 자격
        if (grade.equals("A") || grade.equals("B")) {
            System.out.println("🎓 장학금 자격이 있습니다!");
        }
    }
}
