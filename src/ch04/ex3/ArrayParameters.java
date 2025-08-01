package ch04.ex3;

import java.util.Arrays;

public class ArrayParameters {
    public static void main(String[] args) {
        System.out.println("=== 배열 매개변수 예제 ===\n");

        int[] numbers = {15, 7, 23, 4, 18, 12, 9};

        // 41: 배열 정보 출력
        System.out.print("원본 배열: ");
        printArray(numbers);

        // 42: 통계 정보 출력
        System.out.println("\n=== 배열 통계 ===");
        System.out.println("합계: " + sum(numbers));
        System.out.println("평균: " + average(numbers));
        System.out.println("최대값: " + max(numbers));
        System.out.println("최소값: " + min(numbers));
        System.out.println("범위: " + range(numbers));

        // 43: 배열 조작
        System.out.println("\n=== 배열 조작 ===");

        System.out.print("2배 값: ");
        printArray(doubleValues(numbers));

        System.out.print("10보다 큰 값: ");
        printArray(filterGreaterThan(numbers, 10));

        // 원본 배열 정렬 (복사 후 정렬)
        int[] sorted = copyArray(numbers);
        sortArray(sorted);
        System.out.print("정렬된 배열: ");
        printArray(sorted);

        // 원본 배열은 변경되지 않음
        System.out.print("원본 배열: ");
        printArray(numbers);
    }

    // 44: 배열 출력 메서드
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    // 45: 통계 메서드들
    static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        return total;
    }

    static double average(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    static int max(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }

    static int min(int[] arr) {
        int min = arr[0];
        for (int num : arr) if (num < min) min = num;
        return min;
    }

    static int range(int[] arr) {
        return max(arr) - min(arr);
    }

    // 46: 배열 조작 메서드들
    static int[] doubleValues(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * 2;
        }
        return result;
    }

    static int[] filterGreaterThan(int[] arr, int threshold) {
        // 카운트 먼저
        int count = 0;
        for (int num : arr) if (num > threshold) count++;

        int[] result = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num > threshold) result[index++] = num;
        }
        return result;
    }

    static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    static void sortArray(int[] arr) {
        Arrays.sort(arr);
    }
}
