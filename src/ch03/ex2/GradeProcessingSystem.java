package ch03.ex2;

import textio.TextIO;

public class GradeProcessingSystem {
    public static void main(String[] args) {
        // 변수 선언
        String studentName;
        int numberOfSubjects;
        double totalScore = 0;
        double average;
        String grade;

        System.out.println("=== 성적 처리 시스템 ===");

        // 학생 이름 입력
        System.out.print("학생 이름: ");
        studentName = TextIO.getln();

        // 과목 수 입력 (양수 검증)
        do {
            System.out.print("과목 수: ");
            numberOfSubjects = TextIO.getlnInt();

            if (numberOfSubjects <= 0) {
                System.out.println("과목 수는 1개 이상이어야 합니다!");
            }
        } while (numberOfSubjects <= 0);

        // 각 과목 점수 입력
        System.out.println("\n각 과목의 점수를 입력하세요 (0-100):");

        int subjectCount = 0;
        while (subjectCount < numberOfSubjects) {
            System.out.print("과목 " + (subjectCount + 1) + ": ");
            double score = TextIO.getlnDouble();

            // 점수 범위 검증
            if (score < 0 || score > 100) {
                System.out.println("잘못된 점수입니다. 다시 입력해주세요.");
                continue;
            }

            totalScore = totalScore + score;
            subjectCount = subjectCount + 1;
        }

        // TODO: 평균 및 학점 계산
        // 힌트:
        // 1. 평균 = totalScore / numberOfSubjects
        // 2. 학점 기준:
        //    - 90점 이상: A
        //    - 80점 이상: B
        //    - 70점 이상: C
        //    - 60점 이상: D
        //    - 60점 미만: F

        // 여기에 코드를 작성하세요

        average = totalScore / numberOfSubjects;
        int aver = (int)(average / 10);
        switch (aver) {
            case 10: // 평균 100
            case 9:  grade = "A"; break;
            case 8:  grade = "B"; break;
            case 7:  grade = "C"; break;
            case 6:  grade = "D"; break;
            default: grade = "F";

        }

        // 결과 출력
        System.out.println("\n=== 성적 결과 ===");
        System.out.println("학생: " + studentName);
        System.out.println("총 과목 수: " + numberOfSubjects);
        System.out.printf("평균 점수: %.2f%n", average);
        System.out.println("학점: " + grade);

        // 추가 메시지
        if (grade.equals("A")) {
            System.out.println("축하합니다! 훌륭한 성적입니다! 🎆");
        } else if (grade.equals("F")) {
            System.out.println("더 노력이 필요합니다. 화이팅! 💪");
        }
    }
}