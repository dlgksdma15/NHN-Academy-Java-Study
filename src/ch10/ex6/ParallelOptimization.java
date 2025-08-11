package ch10.ex6;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ParallelOptimization {
    public static void main(String[] args) {
        // 1. ForkJoinPool 커스터마이징
        System.out.println("=== ForkJoinPool 커스터마이징 ===");

        List<Integer> numbers = IntStream.range(1, 1000000)
                .boxed()
                .collect(Collectors.toList());

        // 기본 스레드 풀 사용
        long result1 = numbers.parallelStream()
                .mapToLong(n -> heavyComputation(n))
                .sum();
        System.out.println("기본 풀 결과: " + result1);

        // 커스텀 스레드 풀 사용
        ForkJoinPool customThreadPool = new ForkJoinPool(8);
        try {
            long result2 = customThreadPool.submit(() ->
                    numbers.parallelStream()
                            .mapToLong(n -> heavyComputation(n))
                            .sum()
            ).get();
            System.out.println("커스텀 풀 결과: " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            customThreadPool.shutdown();
        }

        // 2. 데이터 분할 최적화
        System.out.println("\n=== 데이터 분할 최적화 ===");

        // ArrayList vs LinkedList 병렬 처리 성능
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // ArrayList (분할이 효율적)
        long startTime = System.currentTimeMillis();
        long arraySum = arrayList.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        long arrayTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList 병렬 처리 시간: " + arrayTime + "ms");

        // LinkedList (분할이 비효율적)
        startTime = System.currentTimeMillis();
        long linkedSum = linkedList.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        long linkedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList 병렬 처리 시간: " + linkedTime + "ms");

        // 3. 병렬 처리 적합성 판단
        demonstrateParallelSuitability();
    }

    private static long heavyComputation(int n) {
        // 무거운 계산을 시뮬레이션
        return n % 1000 == 0 ?
                IntStream.range(1, 1000).sum() : n;
    }

    private static void demonstrateParallelSuitability() {
        System.out.println("\n=== 병렬 처리 적합성 가이드 ===");

        List<Integer> data = IntStream.range(1, 1000000)
                .boxed()
                .collect(Collectors.toList());

        // 적합한 케이스들
        System.out.println("1. CPU 집약적 작업 - 적합");
        long start = System.currentTimeMillis();
        data.parallelStream()
                .filter(n -> isPrime(n))
                .count();
        System.out.println("소수 찾기 시간: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("\n2. 독립적인 변환 작업 - 적합");
        start = System.currentTimeMillis();
        data.parallelStream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("제곱 계산 시간: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("\n3. 단순 집계 작업 - 적합");
        start = System.currentTimeMillis();
        data.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println("합계 계산 시간: " + (System.currentTimeMillis() - start) + "ms");

        // 부적합한 케이스들
        System.out.println("\n4. 순서 의존적 작업 - 부적합");
        System.out.println("순차: " + data.stream().limit(10).collect(Collectors.toList()));
        System.out.println("병렬: " + data.parallelStream().limit(10).collect(Collectors.toList()));

        System.out.println("\n5. I/O 작업 - 부적합 (여기서는 시뮬레이션)");
        start = System.currentTimeMillis();
        data.stream()
                .limit(1000)
                .map(n -> simulateIOOperation(n))
                .collect(Collectors.toList());
        System.out.println("순차 I/O 시간: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static boolean isPrime(int n) {
        // TODO 1: n이 2보다 작으면 false 반환
        if (n < 2) {
            return false;
        }
        // TODO 2: 2부터 sqrt(n)까지 반복하며
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // TODO 3: n이 i로 나누어떨어지면 false 반환
            if (n % i == 0) {
                return false;
            }
        }
        // TODO 4: 반복문이 끝나면 true 반환
        return true;
    }

    private static String simulateIOOperation(int n) {
        // I/O 지연 시뮬레이션
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data" + n;
    }
}