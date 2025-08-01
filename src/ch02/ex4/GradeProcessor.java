package ch02.ex4;

import textio.TextIO;

public class GradeProcessor {
    public static void main(String[] args) {
        // TODO: 성적 처리 프로그램을 만드세요
        System.out.println("=== 성적 처리 프로그램 ===");

        System.out.print("학생 이름: ");
        String name = TextIO.getln();

        System.out.print("학번: ");
        int studentId = TextIO.getlnInt();

        System.out.println("\n과목별 점수를 입력하세요 (0-100):");

        System.out.print("국어: ");
        double kor = TextIO.getlnDouble();

        System.out.print("영어: ");
        double eng = TextIO.getlnDouble();

        System.out.print("수학: ");
        double math = TextIO.getlnDouble();

        System.out.print("과학: ");
        double sci = TextIO.getlnDouble();

        double avg = (kor + eng + math + sci) / 4.0;
        char grade;

        if (avg >= 90) grade = 'A';
        else if (avg >= 80) grade = 'B';
        else if (avg >= 70) grade = 'C';
        else if (avg >= 60) grade = 'D';
        else grade = 'F';

        System.out.println("\n=== 성적표 ===");
        System.out.printf("이름: %s (학번: %d)\n", name, studentId);
        System.out.println("──────────────────────────────");
        System.out.printf("국어:   %.1f점\n", kor);
        System.out.printf("영어:   %.1f점\n", eng);
        System.out.printf("수학:   %.1f점\n", math);
        System.out.printf("과학:   %.1f점\n", sci);
        System.out.println("──────────────────────────────");
        System.out.printf("평균:   %.1f점\n", avg);
        System.out.printf("학점: %c\n", grade);

        if (grade == 'A' || grade == 'B') {
            System.out.println("\n좋은 성적입니다. 계속 노력하세요!");
        } else if (grade == 'C' || grade == 'D') {
            System.out.println("\n좀 더 분발하세요!");
        } else {
            System.out.println("\n더 열심히 공부하세요!");
        }
    }
}