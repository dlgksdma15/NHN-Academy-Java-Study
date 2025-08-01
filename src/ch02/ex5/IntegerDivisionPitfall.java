package ch02.ex5;

public class IntegerDivisionPitfall {
    public static void main(String[] args) {
        int total = 17;
        int count = 5;

        System.out.println("=== 정수 나눗셈 주의 ===");

        // 잘못된 평균 계산 (정수 나눗셈 후 실수 저장)
        double wrongAverage = total / count;
        System.out.println("잘못된 평균: " + wrongAverage); // 출력: 3.0

        // 올바른 평균 계산 방법들
        double correctAverage1 = (double) total / count;
        double correctAverage2 = total / (double) count;
        double correctAverage3 = 1.0 * total / count;

        System.out.println("올바른 평균 1: " + correctAverage1);
        System.out.println("올바른 평균 2: " + correctAverage2);
        System.out.println("올바른 평균 3: " + correctAverage3);

        // 백분율 계산
        int score = 85;
        int totalScore = 100;

        double wrongPercent = score / totalScore * 100; // 정수 나눗셈 후 100 곱함
        double correctPercent = (double) score / totalScore * 100;

        System.out.println("\n잘못된 백분율: " + wrongPercent + "%");
        System.out.println("올바른 백분율: " + correctPercent + "%");
    }
}
