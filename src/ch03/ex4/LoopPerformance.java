package ch03.ex4;

public class LoopPerformance {
    public static void main(String[] args) {
        int n = 100_000_000;  // 1억
        long sum;
        long startTime, endTime, elapsed;

        // === for 루프 성능 측정 ===
        startTime = System.currentTimeMillis();

        sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        endTime = System.currentTimeMillis();
        elapsed = endTime - startTime;

        System.out.println("for 루프 합계: " + sum);
        System.out.println("for 루프 소요 시간: " + elapsed + "ms");

        // === while 루프 성능 측정 ===
        startTime = System.currentTimeMillis();

        sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }

        endTime = System.currentTimeMillis();
        elapsed = endTime - startTime;

        System.out.println("\nwhile 루프 합계: " + sum);
        System.out.println("while 루프 소요 시간: " + elapsed + "ms");

        // === 수학 공식 사용 ===
        startTime = System.currentTimeMillis();

        sum = (long)n * (n + 1) / 2;

        endTime = System.currentTimeMillis();
        elapsed = endTime - startTime;

        System.out.println("\n수학 공식 합계: " + sum);
        System.out.println("공식 계산 소요 시간: " + elapsed + "ms");
    }
}
