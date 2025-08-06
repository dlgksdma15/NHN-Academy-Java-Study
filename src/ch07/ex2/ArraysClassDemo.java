package ch07.ex2;

import java.util.Arrays;

public class ArraysClassDemo {
    public static void main(String[] args) {
        // 1. Arrays.copyOf 예제
        System.out.println("=== Arrays.copyOf 예제 ===");
        int[] original = {1, 2, 3, 4, 5};

        // TODO: Arrays.copyOf를 사용하여 다양한 크기로 배열을 복사하세요
        // 같은 크기, 더 큰 크기(8), 더 작은 크기(3)로 복사
        int[] copy1 = Arrays.copyOf(original, original.length);
        int[] copy2 = Arrays.copyOf(original, 8);
        int[] copy3 = Arrays.copyOf(original, 3);

        System.out.println("원본: " + Arrays.toString(original));
        System.out.println("복사본: " + Arrays.toString(copy1));
        System.out.println("확장 복사: " + Arrays.toString(copy2));
        System.out.println("축소 복사: " + Arrays.toString(copy3));

        // 2. Arrays.fill 예제
        System.out.println("\n=== Arrays.fill 예제 ===");
        // TODO: Arrays.fill을 사용하여 배열을 채우세요
        // 크기 10 배열을 7로 전체 채우기
        int[] array1 = new int[10];
        Arrays.fill(array1, 7);

        // 크기 10 배열의 인덱스 2~7을 99로 부분 채우기
        int[] array2 = new int[10];
        Arrays.fill(array2, 2, 8, 99);


        System.out.println("전체 채우기: " + Arrays.toString(array1));
        System.out.println("부분 채우기: " + Arrays.toString(array2));

        // 3. Arrays.sort 예제
        System.out.println("\n=== Arrays.sort 예제 ===");
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("정렬 전: " + Arrays.toString(numbers));

        // TODO: Arrays.sort를 사용하여 배열을 정렬하세요
        Arrays.sort(numbers);

        System.out.println("정렬 후: " + Arrays.toString(numbers));

        // TODO: 부분 정렬을 구현하세요 (인덱스 2~6만 정렬)
        int[] partial = {5, 2, 8, 6, 1, 9, 4, 3, 7};
        Arrays.sort(partial, 2, 7);

        System.out.println("부분 정렬: " + Arrays.toString(partial));

        // 4. Arrays.binarySearch 예제
        System.out.println("\n=== Arrays.binarySearch 예제 ===");
        int[] sorted = {11, 12, 22, 25, 34, 64, 90};

        // TODO: Arrays.binarySearch를 사용하여 값을 검색하세요
        // 25와 30을 검색
        int index1 = Arrays.binarySearch(sorted, 25);
        int index2 = Arrays.binarySearch(sorted, 30);

        System.out.println("25의 위치: " + index1);
        System.out.println("30의 위치: " + index2 + " (음수 = 없음)");

        // 5. 문자열 배열 처리
        System.out.println("\n=== 문자열 배열 처리 ===");
        String[] fruits = {"banana", "apple", "cherry", "date", "elderberry"};
        System.out.println("원본: " + Arrays.toString(fruits));

        // TODO: 문자열 배열을 정렬하고 "cherry"를 검색하세요
        Arrays.sort(fruits);

        System.out.println("정렬: " + Arrays.toString(fruits));

        int fruitIndex = Arrays.binarySearch(fruits, "cherry");
        System.out.println("cherry의 위치: " + fruitIndex);
    }
}