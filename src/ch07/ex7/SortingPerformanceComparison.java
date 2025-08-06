package ch07.ex7;

import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceComparison {

    // 선택 정렬
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = temp;
            }
        }
    }

    // 문자열 선택 정렬
    public static void selectionSort(String[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                String temp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = temp;
            }
        }
    }

    // 랜덤 int 배열 생성
    public static int[] generateRandomIntArray(int size, int maxValue) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(maxValue);
        }
        return arr;
    }

    // 성능 측정
    public static void measureIntSortingPerformance(int size) {
        System.out.printf("\n=== 정수 배열 정렬 성능 (크기: %,d) ===\n", size);

        int[] original = generateRandomIntArray(size, 1000000);

        // 선택 정렬
        int[] arr1 = original.clone();
        long start = System.nanoTime();
        selectionSort(arr1);
        long selectionTime = System.nanoTime() - start;

        // Arrays.sort
        int[] arr2 = original.clone();
        start = System.nanoTime();
        Arrays.sort(arr2);
        long arraysTime = System.nanoTime() - start;

        System.out.printf("선택 정렬: %.2f ms\n", selectionTime / 1_000_000.0);
        System.out.printf("Arrays.sort: %.2f ms\n", arraysTime / 1_000_000.0);
        System.out.printf("속도 향상: %.2fx\n", (double) selectionTime / arraysTime);
        System.out.println("정렬 정확성: " + Arrays.equals(arr1, arr2));
    }

    public static void main(String[] args) {
        System.out.println("=== 정렬 성능 비교 프로그램 ===");
        int[] sizes = {100, 500, 1000, 2000};

        for (int size : sizes) {
            measureIntSortingPerformance(size);
            System.out.println("-".repeat(40));
        }
    }
}
