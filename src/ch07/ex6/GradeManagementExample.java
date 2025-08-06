package ch07.ex6;

import java.util.Scanner;

public class GradeManagementExample {
    public static void main(String[] args) {
        // 5명 학생, 3과목 성적
        double[][] scores = {
                {85.5, 92.0, 78.5},  // 학생 1
                {90.0, 85.5, 95.0},  // 학생 2
                {88.0, 91.0, 87.5},  // 학생 3
                {92.5, 88.5, 90.0},  // 학생 4
                {87.0, 89.5, 86.0}   // 학생 5
        };

        String[] students = {"김철수", "이영희", "박민수", "최지영", "홍길동"};
        String[] subjects = {"국어", "수학", "영어"};

        System.out.println("=== 학생 성적 관리 시스템 ===");

        // 성적표 출력
        printGradeTable(scores, students, subjects);

        // 학생별 평균 계산
        System.out.println("\n=== 학생별 평균 ===");
        for (int i = 0; i < students.length; i++) {
            double average = calculateStudentAverage(scores, i);
            System.out.printf("%s: %.1f점\n", students[i], average);
        }

        // 과목별 평균 계산
        System.out.println("\n=== 과목별 평균 ===");
        for (int j = 0; j < subjects.length; j++) {
            double average = calculateSubjectAverage(scores, j);
            System.out.printf("%s: %.1f점\n", subjects[j], average);
        }

        // 최고 점수와 최저 점수
        double[] minMax = findMinMaxScores(scores);
        System.out.printf("\n최고 점수: %.1f점\n", minMax[1]);
        System.out.printf("최저 점수: %.1f점\n", minMax[0]);

        // 등급 분포
        System.out.println("\n=== 등급 분포 ===");
        printGradeDistribution(scores, students);
    }

    public static void printGradeTable(double[][] scores, String[] students, String[] subjects) {
        System.out.printf("%8s", "학생");
        for (String subject : subjects) {
            System.out.printf("%8s", subject);
        }
        System.out.printf("%8s\n", "평균");
        System.out.println("----------------------------------------");

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%8s", students[i]);
            double sum = 0;
            for (int j = 0; j < subjects.length; j++) {
                System.out.printf("%8.1f", scores[i][j]);
                sum += scores[i][j];
            }
            System.out.printf("%8.1f\n", sum / subjects.length);
        }
    }

    public static double calculateStudentAverage(double[][] scores, int studentIndex) {
        double sum = 0;
        for (int j = 0; j < scores[studentIndex].length; j++) {
            sum += scores[studentIndex][j];
        }
        return sum / scores[studentIndex].length;
    }

    public static double calculateSubjectAverage(double[][] scores, int subjectIndex) {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i][subjectIndex];
        }
        return sum / scores.length;
    }

    public static double[] findMinMaxScores(double[][] scores) {
        double min = scores[0][0];
        double max = scores[0][0];

        for (double[] row : scores) {
            for (double score : row) {
                if (score < min) min = score;
                if (score > max) max = score;
            }
        }

        return new double[]{min, max};
    }

    public static void printGradeDistribution(double[][] scores, String[] students) {
        int[] gradeCount = new int[5];  // A, B, C, D, F
        String[] grades = {"A", "B", "C", "D", "F"};

        for (int i = 0; i < students.length; i++) {
            double average = calculateStudentAverage(scores, i);
            int gradeIndex = getGradeIndex(average);
            gradeCount[gradeIndex]++;
            System.out.printf("%s: %.1f점 (%s등급)\n",
                    students[i], average, grades[gradeIndex]);
        }

        System.out.println("\n등급별 분포:");
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("%s등급: %d명\n", grades[i], gradeCount[i]);
        }
    }

    private static int getGradeIndex(double average) {
        if (average >= 90) return 0;  // A
        else if (average >= 80) return 1;  // B
        else if (average >= 70) return 2;  // C
        else if (average >= 60) return 3;  // D
        else return 4;  // F
    }
}
