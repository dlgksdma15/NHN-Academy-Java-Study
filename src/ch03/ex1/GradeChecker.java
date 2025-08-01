package ch03.ex1;
import textio.TextIO;

public class GradeChecker {
    public static void main(String[] args) {
        System.out.print("점수를 입력하세요 (0-100): ");
        int score = TextIO.getlnInt();

        String grade;
        String comment;

        // 성적 판정 로직
        if (score >= 90) {
            grade = "A";
            comment = "우수합니다!";
        } else if (score >= 80) {
            grade = "B";
            comment = "잘했습니다!";
        } else if (score >= 70) {
            grade = "C";
            comment = "보통입니다.";
        } else if (score >= 60) {
            grade = "D";
            comment = "노력이 필요합니다.";
        } else {
            grade = "F";
            comment = "재수강이 필요합니다.";
        }

        System.out.println("학점: " + grade);
        System.out.println("평가: " + comment);
    }
}
