package ch04.ex4;

public class StringTransformation {
    public static void main(String[] args) {
        System.out.println("=== 문자열 변환 함수 ===\n");

        String text = "Hello World!";
        System.out.println("원본: " + text);
        System.out.println("대문자: " + toUpperCase(text));
        System.out.println("소문자: " + toLowerCase(text));
        System.out.println("대소문자 반전: " + swapCase(text));

        System.out.println("\n=== 문자 처리 ===");
        System.out.println("모음 제거: " + removeVowels("Hello World"));
        System.out.println("공백 제거: " + removeSpaces("Hello World"));
        System.out.println("숫자만 추출: " + extractDigits("abc123def456"));

        System.out.println("\n=== 문자열 반복 ===");
        System.out.println("repeat(\"Hi\", 3): " + repeat("Hi", 3));
        System.out.println("repeat(\"*\", 10): " + repeat("*", 10));
    }

    static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    static String swapCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String removeVowels(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

    static String removeSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }

    static String extractDigits(String str) {
        return str.replaceAll("\\D+", "");
    }

    static String repeat(String str, int times) {
        return str.repeat(times);
    }
}
