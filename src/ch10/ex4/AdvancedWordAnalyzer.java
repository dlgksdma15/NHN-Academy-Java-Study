package ch10.ex4;

import java.util.*;
import java.util.stream.*;

public class AdvancedWordAnalyzer {

    private Map<String, Integer> wordFrequency;
    private Map<Integer, Set<String>> frequencyWords;  // 빈도 → 단어들
    private Map<Character, Integer> firstLetterCount;   // 첫 글자 통계

    public AdvancedWordAnalyzer() {
        wordFrequency = new HashMap<>();
        frequencyWords = new TreeMap<>(Collections.reverseOrder());
        firstLetterCount = new TreeMap<>();
    }

    // 텍스트 분석
    public void analyze(String text) {
        Arrays.stream(text.toLowerCase().split("\\W+"))
                .filter(word -> word.length() > 0)
                .forEach(this::processWord);

        // 빈도별 그룹화
        buildFrequencyGroups();
    }

    private void processWord(String word) {
        // 빈도 계산
        wordFrequency.merge(word, 1, Integer::sum);

        // 첫 글자 통계
        if (!word.isEmpty()) {
            char firstChar = word.charAt(0);
            firstLetterCount.merge(firstChar, 1, Integer::sum);
        }
    }

    private void buildFrequencyGroups() {
        frequencyWords.clear();

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();

            frequencyWords.computeIfAbsent(count, k -> new TreeSet<>())
                    .add(word);
        }
    }

    // 상위 N개 단어
    public List<Map.Entry<String, Integer>> getTopWords(int n) {
        return wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    // 특정 길이의 단어들
    public Set<String> getWordsByLength(int length) {
        return wordFrequency.keySet().stream()
                .filter(word -> word.length() == length)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    // 빈도별 분포
    public void printFrequencyDistribution() {
        System.out.println("=== 빈도 분포 ===");

        for (Map.Entry<Integer, Set<String>> entry : frequencyWords.entrySet()) {
            int frequency = entry.getKey();
            Set<String> words = entry.getValue();

            System.out.printf("%d회: %d개 단어 ", frequency, words.size());

            // 샘플 출력 (최대 5개)
            List<String> sample = words.stream()
                    .limit(5)
                    .collect(Collectors.toList());
            System.out.println(sample);
        }
    }

    // 첫 글자 통계
    public void printFirstLetterStatistics() {
        System.out.println("\n=== 첫 글자 통계 ===");

        int total = firstLetterCount.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        firstLetterCount.forEach((letter, count) -> {
            double percentage = (count * 100.0) / total;
            System.out.printf("%c: %3d (%.1f%%)\n",
                    letter, count, percentage);
        });
    }

    // 단어 길이 분포
    public void printLengthDistribution() {
        System.out.println("\n=== 단어 길이 분포 ===");

        Map<Integer, Long> lengthCount = wordFrequency.keySet().stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.counting()
                ));

        lengthCount.forEach((length, count) -> {
            System.out.printf("%2d글자: %3d개\n", length, count);
        });
    }

    public static void main(String[] args) {
        AdvancedWordAnalyzer analyzer = new AdvancedWordAnalyzer();

        String text = """
                The Java programming language is a high-level, object-oriented
                language. Java is designed to be platform independent, which
                means that Java programs can run on any system that has a
                Java Virtual Machine. The Java language is strongly typed
                and has automatic memory management through garbage collection.
                """;

        analyzer.analyze(text);

        // 상위 10개 단어
        System.out.println("=== 상위 10개 단어 ===");
        analyzer.getTopWords(10).forEach(entry ->
                System.out.printf("%-15s %d회\n", entry.getKey(), entry.getValue())
        );

        // 빈도 분포
        System.out.println();
        analyzer.printFrequencyDistribution();

        // 첫 글자 통계
        analyzer.printFirstLetterStatistics();

        // 길이 분포
        analyzer.printLengthDistribution();

        // 5글자 단어들
        System.out.println("\n=== 5글자 단어들 ===");
        System.out.println(analyzer.getWordsByLength(5));
    }
}