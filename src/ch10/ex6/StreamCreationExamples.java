package ch10.ex6;

import java.util.*;
import java.util.stream.*;

public class StreamCreationExamples {
    public static void main(String[] args) {
        System.out.println("=== 스트림 생성 방법들 ===");

        // 1. 컬렉션에서 스트림 생성
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println("리스트에서 순차 스트림:");
        fruits.stream().forEach(System.out::println);

        System.out.println("\n리스트에서 병렬 스트림:");
        fruits.parallelStream().forEach(System.out::println);

        // 2. 배열에서 스트림 생성
        String[] colors = {"red", "green", "blue", "yellow"};
        System.out.println("\n배열에서 스트림:");
        Arrays.stream(colors).forEach(System.out::println);

        // 정수 배열
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("\n정수 배열에서 IntStream:");
        Arrays.stream(numbers).forEach(System.out::println);

        // 3. Stream.of()로 직접 생성
        System.out.println("\nStream.of()로 생성:");
        Stream.of("하나", "둘", "셋").forEach(System.out::println);

        // 4. Stream.generate()로 무한 스트림 생성
        System.out.println("\n무한 스트림 (첫 5개만):");
        Stream.generate(() -> "Hello")
                .limit(5)
                .forEach(System.out::println);

        // 5. Stream.iterate()로 수열 생성
        System.out.println("\n피보나치 수열 (첫 10개):");
        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(10)
                .mapToInt(fib -> fib[0])
                .forEach(System.out::println);

        // 6. IntStream.range()로 범위 생성
        System.out.println("\n범위 스트림 (1-5):");
        IntStream.range(1, 6).forEach(System.out::println);

        // 7. Random 스트림
        System.out.println("\n랜덤 정수 (5개):");
        new Random().ints(5, 1, 101)
                .forEach(System.out::println);
    }
}