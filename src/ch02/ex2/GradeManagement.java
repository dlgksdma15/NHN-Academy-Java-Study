package ch02.ex2;

public class GradeManagement {
    public static void main(String[] args) {
        // TODO: 학생 정보를 저장할 변수들을 선언하세요
        String studentName = "김철수";
        int studentId = 20240001;

        // TODO: 과목별 점수를 저장할 변수들을 선언하세요
        double korean = 85.5, english = 92.0, math = 78.5, science = 88.0, history = 91.5;

        // TODO: 총점과 평균을 계산하세요
        double totalScore = korean + english + math + science + history;
        double average = totalScore / 5;

        // TODO: 평균 점수에 따라 학점을 결정하세요
        char grade;
        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else grade = 'F';

        // TODO: 합격 여부를 다산하세요
        boolean isPassed = average >= 60;

        // TODO: 성적표를 출력하세요
        System.out.println("=== 성적표 ===");
        System.out.println("학생명: " + studentName);
        System.out.println("학번: " + studentId);
        System.out.println("\n과목별 점수:");
        System.out.println("국어: " + korean + ", 영어: " + english + ", 수학: " + math + ", 과학: " + science + ", 역사: " + history);
        System.out.println("총점: " + totalScore);
        System.out.println("평균: " + average);
        System.out.println("학점: " + grade);
        System.out.println("합격 여부: " + (isPassed ? "합격" : "불합격"));

        // TODO: 장학금 자격을 확인하고 출력하세요
        boolean scholarshipEligible = average >= 90.0;
        if (scholarshipEligible) {
            System.out.println("\n🎉 장학금 수혜 자격이 있습니다!");
        }
    }
}
