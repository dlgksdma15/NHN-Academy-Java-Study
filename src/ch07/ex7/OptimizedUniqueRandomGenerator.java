package ch07.ex7;

import java.util.*;

public class OptimizedUniqueRandomGenerator {

    // HashSet을 사용한 최적화 버전
    public static ArrayList<Integer> generateUniqueRandomsOptimized(int count, int maxValue) {
        if (count > maxValue) {
            throw new IllegalArgumentException("count는 maxValue보다 클 수 없습니다.");
        }

        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();

        while (set.size() < count) {
            set.add(random.nextInt(maxValue) + 1);
        }

        return new ArrayList<>(set);
    }

    // Fisher-Yates 셔플 버전
    public static ArrayList<Integer> generateUniqueRandomsShuffle(int count, int maxValue) {
        if (count > maxValue) {
            throw new IllegalArgumentException("count는 maxValue보다 클 수 없습니다.");
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= maxValue; i++) {
            numbers.add(i);
        }

        // Fisher-Yates: count만큼만 섞기
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int j = i + random.nextInt(maxValue - i);
            Collections.swap(numbers, i, j);
        }

        return new ArrayList<>(numbers.subList(0, count));
    }

    // 성능 비교
    public static void performanceComparison(int count, int maxValue, int iterations) {
        System.out.printf("\n테스트 조건: %d개 숫자, 범위 1-%d, %d회 반복\n",
                count, maxValue, iterations);

        // 기본 방법
        long basicTotal = 0;
        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            UniqueRandomGenerator.generateUniqueRandoms(count, maxValue);
            basicTotal += System.nanoTime() - start;
        }

        // HashSet 방법
        long hashSetTotal = 0;
        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            generateUniqueRandomsOptimized(count, maxValue);
            hashSetTotal += System.nanoTime() - start;
        }

        // 셔플 방법
        long shuffleTotal = 0;
        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            generateUniqueRandomsShuffle(count, maxValue);
            shuffleTotal += System.nanoTime() - start;
        }

        System.out.printf("기본 방법:      %.2f ms\n", basicTotal / iterations / 1_000_000.0);
        System.out.printf("HashSet 최적화: %.2f ms (%.1fx 빠름)\n",
                hashSetTotal / iterations / 1_000_000.0,
                (double) basicTotal / hashSetTotal);
        System.out.printf("셔플 방법:      %.2f ms (%.1fx 빠름)\n",
                shuffleTotal / iterations / 1_000_000.0,
                (double) basicTotal / shuffleTotal);
    }

    public static void main(String[] args) {
        System.out.println("=== 정확성 테스트 ===");
        System.out.println("HashSet 결과: " + generateUniqueRandomsOptimized(10, 20));
        System.out.println("셔플 결과:   " + generateUniqueRandomsShuffle(10, 20));

        performanceComparison(100, 1000, 10);
        performanceComparison(500, 1000, 5);
        performanceComparison(50, 100, 20);
    }
}
