package ch10.ex4;

import java.util.*;
import java.text.Collator;

public class CaseInsensitiveExample {

    public static void main(String[] args) {
        // 문제: 기본 정렬은 대문자가 소문자보다 앞
        System.out.println("=== 기본 정렬 ===");
        TreeSet<String> defaultSort = new TreeSet<>();
        defaultSort.addAll(Arrays.asList(
                "Apple", "apple", "Banana", "banana",
                "Cherry", "cherry", "APPLE"
        ));
        System.out.println(defaultSort);

        // 해결 1: CASE_INSENSITIVE_ORDER
        System.out.println("\n=== 대소문자 무시 정렬 ===");
        TreeSet<String> caseInsensitive = new TreeSet<>(
                String.CASE_INSENSITIVE_ORDER
        );
        caseInsensitive.addAll(Arrays.asList(
                "Apple", "apple", "Banana", "banana",
                "Cherry", "cherry", "APPLE"
        ));
        System.out.println(caseInsensitive);
        System.out.println("크기: " + caseInsensitive.size());

        // 해결 2: compareToIgnoreCase
        System.out.println("\n=== compareToIgnoreCase ===");
        TreeSet<String> ignoreCase = new TreeSet<>(
                String::compareToIgnoreCase
        );
        ignoreCase.addAll(Arrays.asList(
                "Apple", "apple", "Banana", "banana",
                "Cherry", "cherry", "APPLE"
        ));
        System.out.println(ignoreCase);

        // 해결 3: 소문자 변환 후 비교 (원본 유지)
        System.out.println("\n=== 소문자 변환 비교 (원본 유지) ===");
        TreeSet<String> lowerCaseCompare = new TreeSet<>(
                Comparator.comparing(String::toLowerCase)
        );
        lowerCaseCompare.addAll(Arrays.asList(
                "Apple", "apple", "Banana", "banana",
                "Cherry", "cherry", "APPLE"
        ));
        System.out.println(lowerCaseCompare);

        // 응용: 한글 정렬
        System.out.println("\n=== 한글 정렬 ===");
        TreeSet<String> korean = new TreeSet<>(
                Collator.getInstance(Locale.KOREAN)
        );
        korean.addAll(Arrays.asList(
                "가나다", "다라마", "나다라", "라마바", "마바사"
        ));
        System.out.println(korean);
    }
}