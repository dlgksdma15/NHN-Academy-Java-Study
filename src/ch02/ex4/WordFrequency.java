package ch02.ex4;

import textio.TextIO;

public class WordFrequency {
    public static void main(String[] args) {
        // TODO: 텍스트 분석 프로그램을 만드세요
        System.out.println("=== 단어 빈도 분석 ===");
        System.out.println("텍스트를 입력하세요 (종료: 빈 줄):");

        StringBuilder inputText = new StringBuilder();
        while (true) {
            String line = TextIO.getln();
            if (line.isBlank()) break;
            inputText.append(line).append(" ");
        }

        String text = inputText.toString().trim();

        // 문자 수 (공백 제외)
        int charCount = 0;
        int vowelCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!Character.isWhitespace(ch)) {
                charCount++;
            }
            if ("aeiouAEIOU".indexOf(ch) >= 0) {
                vowelCount++;
            }
        }

        // 단어 수
        String[] words = text.split("[\\s.,!?]+");
        int wordCount = words.length;

        // 문장 수 (., !, ? 기준)
        int sentenceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '.' || ch == '!' || ch == '?') {
                sentenceCount++;
            }
        }

        // 평균 단어 길이
        int wordLengthTotal = 0;
        for (String word : words) {
            wordLengthTotal += word.length();
        }
        double avgWordLength = wordCount > 0 ? (double) wordLengthTotal / wordCount : 0;

        // 문장당 평균 단어 수
        double avgWordsPerSentence = sentenceCount > 0 ? (double) wordCount / sentenceCount : 0;

        // 결과 출력
        System.out.println("\n=== 분석 결과 ===");
        System.out.printf("총 문자 수: %d%n", charCount);
        System.out.printf("총 단어 수: %d%n", wordCount);
        System.out.printf("모음 개수: %d%n", vowelCount);
        System.out.printf("문장 수: %d%n", sentenceCount);
        System.out.printf("평균 단어 길이: %.1f%n", avgWordLength);
        System.out.printf("문장당 평균 단어 수: %.1f%n", avgWordsPerSentence);
    }
}
