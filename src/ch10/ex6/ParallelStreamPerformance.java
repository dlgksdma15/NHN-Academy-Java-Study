package ch10.ex6;

import java.util.*;
import java.util.stream.*;

public class ParallelStreamPerformance {
    public static void main(String[] args) {
        // 큰 데이터셋 생성
        List<Integer> largeList = IntStream.range(1, 10000000)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("데이터 크기: " + largeList.size());

        // 1. 순차 스트림으로 처리
        long startTime = System.currentTimeMillis();
        long sum1 = largeList.stream()
                .filter(n -> n % 2 == 0)
                .mapToLong(n -> n * n)
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("순차 처리 시간: " + (endTime - startTime) + "ms");
        System.out.println("순차 처리 결과: " + sum1);

        // 2. 병렬 스트림으로 처리
        startTime = System.currentTimeMillis();
        long sum2 = largeList.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToLong(n -> n * n)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("병렬 처리 시간: " + (endTime - startTime) + "ms");
        System.out.println("병렬 처리 결과: " + sum2);

        // 3. 작은 데이터셋에서의 비교
        List<Integer> smallList = IntStream.range(1, 1000)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\n=== 작은 데이터셋 (크기: " + smallList.size() + ") ===");

        // 순차 처리
        startTime = System.nanoTime();
        long smallSum1 = smallList.stream()
                .mapToLong(n -> n * n)
                .sum();
        endTime = System.nanoTime();
        System.out.println("순차 처리 시간: " + (endTime - startTime) + "ns");

        // 병렬 처리
        startTime = System.nanoTime();
        long smallSum2 = smallList.parallelStream()
                .mapToLong(n -> n * n)
                .sum();
        endTime = System.nanoTime();
        System.out.println("병렬 처리 시간: " + (endTime - startTime) + "ns");

        // 4. 병렬 처리에 적합한 연산 vs 부적합한 연산
        System.out.println("\n=== 병렬 처리 적합성 테스트 ===");

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        // 적합한 예: 독립적인 변환 작업
        System.out.println("병렬 처리 적합 - 독립적 변환:");
        words.parallelStream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 부적합한 예: 순서 의존적 작업 (순서가 보장되지 않음)
        System.out.println("\n병렬 처리 부적합 - 순서 의존적:");
        words.parallelStream()
                .forEach(word -> System.out.print(word + " "));
        System.out.println();

        // 순서 보장이 필요한 경우 forEachOrdered 사용
        System.out.println("forEachOrdered로 순서 보장:");
        words.parallelStream()
                .forEachOrdered(word -> System.out.print(word + " "));
        System.out.println();
    }
}