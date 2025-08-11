package ch10.ex6;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "api", "functional", "programming");

        // 1. Predicate<T> - 조건 판별
        Predicate<String> longWord = s -> s.length() > 4;
        System.out.println("긴 단어들:");
        words.stream()
                .filter(longWord)
                .forEach(System.out::println);

        // 2. Function<T, R> - 변환
        Function<String, Integer> getLength = String::length;
        System.out.println("\n단어 길이들:");
        words.stream()
                .map(getLength)
                .forEach(System.out::println);

        // 3. Consumer<T> - 소비
        Consumer<String> printer = s -> System.out.println("처리중: " + s);
        System.out.println("\nConsumer 사용:");
        words.stream().forEach(printer);

        // 4. Supplier<T> - 공급
        Supplier<String> randomWord = () -> {
            String[] samples = {"hello", "world", "java", "stream"};
            return samples[new Random().nextInt(samples.length)];
        };

        System.out.println("\n랜덤 단어 5개:");
        Stream.generate(randomWord)
                .limit(5)
                .forEach(System.out::println);

        // 5. UnaryOperator<T> - 단항 연산
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println("\n대문자 변환:");
        words.stream()
                .map(toUpperCase)
                .forEach(System.out::println);

        // 6. BinaryOperator<T> - 이항 연산
        BinaryOperator<String> concat = (s1, s2) -> s1 + "-" + s2;
        System.out.println("\n단어 연결:");
        String result = words.stream()
                .reduce(concat)
                .orElse("없음");
        System.out.println(result);

        // 7. 메서드 조합 사용
        Predicate<String> startsWithJ = s -> s.startsWith("j");
        Predicate<String> hasMoreThan3Chars = s -> s.length() > 3;

        System.out.println("\n'j'로 시작하고 3글자 이상:");
        words.stream()
                .filter(startsWithJ.and(hasMoreThan3Chars))
                .forEach(System.out::println);
    }
}