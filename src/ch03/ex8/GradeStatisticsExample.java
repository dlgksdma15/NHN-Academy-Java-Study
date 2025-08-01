package ch03.ex8;

import textio.TextIO;

public class GradeStatisticsExample {
    public static void main(String[] args) {
        final int MAX_SCORES = 50;
        double[] scores = new double[MAX_SCORES];
        int scoreCount = 0;

        System.out.println("=== 성적 통계 계산기 ===");
        System.out.println("점수를 입력하세요 (0 이하로 종료):");

        // 점수 입력
        while (scoreCount < MAX_SCORES) {
            System.out.print("점수 " + (scoreCount + 1) + ": ");
            double score = TextIO.getlnDouble();

            if (score <= 0) {
                break;
            }

            if (score > 100) {
                System.out.println("❌ 100점을 초과할 수 없습니다.");
                continue;
            }

            scores[scoreCount] = score;
            scoreCount++;
        }

        if (scoreCount == 0) {
            System.out.println("입력된 점수가 없습니다.");
            return;
        }

        // TODO: 통계 계산 (합계, 최대, 최소, 평균, 표준편차)
        double sum = 0;
        double max = scores[0];
        double min = scores[0];

        for (int i = 0; i < scoreCount; i++) {
            double val = scores[i];
            sum += val;
            if (val > max) max = val;
            if (val < min) min = val;
        }

        double average = sum / scoreCount;

        // 표준편차 계산
        double varianceSum = 0;
        for (int i = 0; i < scoreCount; i++) {
            double diff = scores[i] - average;
            varianceSum += diff * diff;
        }
        double variance = varianceSum / scoreCount;
        double standardDeviation = Math.sqrt(variance);

        // TODO: 등급별 분포 계산
        int[] gradeCount = new int[5]; // A,B,C,D,F

        for (int i = 0; i < scoreCount; i++) {
            double val = scores[i];
            if (val >= 90) gradeCount[0]++;
            else if (val >= 80) gradeCount[1]++;
            else if (val >= 70) gradeCount[2]++;
            else if (val >= 60) gradeCount[3]++;
            else gradeCount[4]++;
        }

        // 결과 출력
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📊 통계 결과");
        System.out.println("=".repeat(40));
        System.out.printf("입력된 점수 개수: %d개%n", scoreCount);
        System.out.printf("합계: %.2f점%n", sum);
        System.out.printf("평균: %.2f점%n", average);
        System.out.printf("최고점: %.2f점%n", max);
        System.out.printf("최저점: %.2f점%n", min);
        System.out.printf("표준편차: %.2f%n", standardDeviation);

        System.out.println("\n등급별 분포:");
        String[] grades = {"A (90-100)", "B (80-89)", "C (70-79)", "D (60-69)", "F (0-59)"};
        for (int i = 0; i < grades.length; i++) {
            double percentage = (gradeCount[i] * 100.0) / scoreCount;
            System.out.printf("%s: %d명 (%.1f%%)%n", grades[i], gradeCount[i], percentage);

            // 막대 그래프
            System.out.print("  ");
            int barLength = (int)(percentage / 2);  // 50% = 25개 문자
            for (int j = 0; j < barLength; j++) {
                System.out.print("█");
            }
            System.out.println();
        }
    }
}
