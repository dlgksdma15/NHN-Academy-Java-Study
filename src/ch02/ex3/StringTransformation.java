package ch02.ex3;

public class StringTransformation {
    public static void main(String[] args) {
        // TODO: 변환을 위한 원본 문자열을 선언하고 정보를 출력하세요
        // 힌트:
        // 1. original = "  Java Programming Language  " 선언
        // 2. 원본 문자열과 길이 출력

        // TODO: 대소문자 변환을 수행하세요
        // 힌트:
        // 1. upper = original.toUpperCase()
        // 2. lower = original.toLowerCase()
        // 3. 대문자와 소문자 결과 출력

        // TODO: 공백 제거를 수행하세요
        // 힌트:
        // 1. trimmed = original.trim()
        // 2. trim 후 문자열과 길이 출력

        // TODO: 연쇄 변환을 수행하세요
        // 힌트:
        // result = original.trim().toLowerCase().substring(0, 4)
        // 연쇄 변환 결과 출력

        // TODO: replace 메소드를 사용하여 문자열 치환을 수행하세요
        // 힌트:
        // 1. text = "I love Java. Java is great!" 선언
        // 2. replaced = text.replace("Java", "Python")
        // 3. 원본과 치환 후 결과 출력

        // TODO: CSV 예제를 보여주세요
        // 힌트:
        // 1. csv = "apple,banana,cherry" 선언
        // 2. CSV 문자열 출력
        // 3. csv.substring(0, csv.indexOf(','))로 첫 번째 항목 출력

        // 여기에 코드를 작성하세요

        String original = "  Java Programming Language  ";
        int length = original.length();
        System.out.println(length);

        String upper = original.toUpperCase();
        String lower = original.toLowerCase();

        System.out.println(upper);
        System.out.println(lower);

        String trimmed = original.trim();
        int trimmedLength = trimmed.length();
        System.out.println(trimmedLength);

        String result = original.trim().toLowerCase().substring(0, 4);
        System.out.println(result);

        String text = "I love Java. Java is great!";
        String replaced = text.replace("Java", "Python");
        // 3. 원본과 치환 후 결과 출력
        System.out.println(replaced);

        String csv = "apple,banana,cherry";
        // 2. CSV 문자열 출력
        System.out.println(csv);
        System.out.println(csv.substring(0, csv.indexOf(',')));

    }
}