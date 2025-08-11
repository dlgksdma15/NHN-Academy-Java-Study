package ch10.ex6;

import java.util.*;
import java.util.stream.*;

public class FlatMapExample {
    public static void main(String[] args) {
        // 1. 문자열을 문자로 분해
        List<String> words = Arrays.asList("hello", "world", "java", "stream");

        System.out.println("=== flatMap 예제 ===");

        // 잘못된 방법: map만 사용
        System.out.println("map만 사용 (Stream<Stream<Character>>):");
        words.stream()
                .map(word -> word.chars().mapToObj(c -> (char) c))
                .forEach(stream -> {
                    System.out.print("스트림: ");
                    stream.forEach(System.out::print);
                    System.out.println();
                });

        // 올바른 방법: flatMap 사용
        System.out.println("\nflatMap 사용 (모든 문자):");
        words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .forEach(System.out::print);
        System.out.println();

        // 2. 중첩된 리스트 평면화
        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        System.out.println("\n중첩 리스트 평면화:");
        nestedNumbers.stream()
                .flatMap(List::stream)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 3. 학생-과목 관계 예제
        List<Student2> students = Arrays.asList(
                new Student2("김철수", Arrays.asList("수학", "영어", "과학")),
                new Student2("이영희", Arrays.asList("국어", "수학", "역사")),
                new Student2("박민수", Arrays.asList("영어", "과학", "체육"))
        );

        System.out.println("\n모든 수강 과목 (중복 포함):");
        students.stream()
                .flatMap(s -> s.getSubjects().stream())
                .forEach(subject -> System.out.print(subject + " "));
        System.out.println();

        System.out.println("\n고유한 수강 과목:");
        students.stream()
                .flatMap(s -> s.getSubjects().stream())
                .distinct()
                .sorted()
                .forEach(subject -> System.out.print(subject + " "));
        System.out.println();

        // 4. 문자열 분할과 단어 카운트
        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Stream API is useful",
                "Programming is fun"
        );

        System.out.println("\n모든 단어들:");
        Map<String, Long> wordCount = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));

        wordCount.forEach((word, count) ->
                System.out.println(word + ": " + count + "번"));
    }
}

class Student2 {
    private String name;
    private List<String> subjects;

    public Student2(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() { return name; }
    public List<String> getSubjects() { return subjects; }
}