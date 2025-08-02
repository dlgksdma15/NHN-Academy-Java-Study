package ch04.ex4;

public class StringAnalysis {
    public static void main(String[] args) {
        System.out.println("=== 문자열 분석 함수 ===\n");

        String text = "Hello World 2024!";

        // 문자열 분석 테스트
        System.out.println("텍스트: \"" + text + "\"");
        System.out.println("길이: " + length(text));
        System.out.println("모음 개수: " + countVowels(text));
        System.out.println("자음 개수: " + countConsonants(text));
        System.out.println("숫자 개수: " + countDigits(text));
        System.out.println("공백 개수: " + countSpaces(text));
        System.out.println("단어 개수: " + countWords(text));

        // 회문 검사 테스트
        String[] palindromes = {"radar", "hello", "level", "noon"};
        System.out.println("\n=== 회문 검사 ===");
        for (String word : palindromes) {
            System.out.println(word + " → " +
                    (isPalindrome(word) ? "회문입니다" : "회문이 아닙니다"));
        }
    }

    static int length(String str) {
        return str.length();
    }

    static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) >= 0) count++;
        }
        return count;
    }

    static int countConsonants(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) < 0) count++;
        }
        return count;
    }

    static int countDigits(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) count++;
        }
        return count;
    }

    static int countSpaces(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isWhitespace(c)) count++;
        }
        return count;
    }

    static int countWords(String str) {
        if (str.trim().isEmpty()) return 0;
        return str.trim().split("\\s+").length;
    }

    static boolean isPalindrome(String word) {
        return word.equalsIgnoreCase(reverse(word));
    }

    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

