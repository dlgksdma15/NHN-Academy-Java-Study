package ch10.ex4;

import java.util.*;
import java.io.*;

public class WordCounter {

    // 단어 정보 클래스
    static class WordData implements Comparable<WordData> {
        String word;
        int count;

        WordData(String word) {
            this.word = word;
            this.count = 1;
        }

        void increment() {
            count++;
        }

        // 빈도 내림차순, 같으면 알파벳순
        @Override
        public int compareTo(WordData other) {
            int countCompare = other.count - this.count;
            if (countCompare != 0) return countCompare;
            return this.word.compareTo(other.word);
        }

        @Override
        public String toString() {
            return String.format("%-15s %4d", word, count);
        }
    }

    private TreeMap<String, WordData> words;
    private int totalWords;

    public WordCounter() {
        // 대소문자 무시
        words = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        totalWords = 0;
    }

    // 텍스트 처리
    public void processText(String text) {
        // 단어 분리 (알파벳과 숫자만)
        String[] tokens = text.split("[^a-zA-Z0-9]+");

        for (String token : tokens) {
            if (!token.isEmpty()) {
                processWord(token.toLowerCase());
            }
        }
    }

    // 단어 처리
    private void processWord(String word) {
        totalWords++;

        WordData data = words.get(word);
        if (data == null) {
            words.put(word, new WordData(word));
        } else {
            data.increment();
        }
    }

    // 알파벳순 출력
    public void printAlphabetical() {
        System.out.println("=== 알파벳순 ===");
        for (WordData data : words.values()) {
            System.out.println(data);
        }
    }

    // 빈도순 출력
    public void printByFrequency(int minCount) {
        System.out.println("=== 빈도순 (최소 " + minCount + "회) ===");

        // TreeSet으로 정렬
        TreeSet<WordData> sorted = new TreeSet<>(words.values());

        for (WordData data : sorted) {
            if (data.count >= minCount) {
                System.out.println(data);
            }
        }
    }

    // 통계 출력
    public void printStatistics() {
        System.out.println("\n=== 통계 ===");
        System.out.println("전체 단어 수: " + totalWords);
        System.out.println("고유 단어 수: " + words.size());

        if (!words.isEmpty()) {
            // 가장 빈번한 단어
            WordData mostFrequent = Collections.max(
                    words.values(),
                    Comparator.comparingInt(w -> w.count)
            );
            System.out.println("가장 빈번한 단어: " + mostFrequent);

            // 평균 빈도
            double avgFrequency = (double) totalWords / words.size();
            System.out.printf("평균 빈도: %.2f\n", avgFrequency);
        }
    }

    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        String text = """
                Java is a high-level, class-based, object-oriented
                programming language that is designed to have as few
                implementation dependencies as possible. It is a
                general-purpose programming language intended to let
                programmers write once, run anywhere (WORA), meaning
                that compiled Java code can run on all platforms that
                support Java without the need to recompile.
                """;

        counter.processText(text);

        counter.printAlphabetical();
        System.out.println();
        counter.printByFrequency(2);
        counter.printStatistics();
    }
}