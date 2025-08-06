package ch07.ex5;

import java.util.Arrays;
import java.util.Random;

public class PerformanceComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 20000};

        System.out.println("=== 정렬 알고리즘 성능 비교 ===");
        System.out.printf("%-10s %-15s %-15s %-15s\n", "배열 크기", "삽입 정렬 (ms)", "선택 정렬 (ms)", "Arrays.sort (ms)");

        for (int size : sizes) {
            int[] originalArray = generateRandomArray(size);

            // 삽입 정렬
            int[] arrayForInsertion = Arrays.copyOf(originalArray, size);
            long startTime = System.nanoTime();
            InsertionSortExample.insertionSort(arrayForInsertion);
            long endTime = System.nanoTime();
            long insertionSortTime = (endTime - startTime) / 1_000_000;

            // 선택 정렬
            int[] arrayForSelection = Arrays.copyOf(originalArray, size);
            startTime = System.nanoTime();
            SelectionSortExample.selectionSort(arrayForSelection);
            endTime = System.nanoTime();
            long selectionSortTime = (endTime - startTime) / 1_000_000;

            // Arrays.sort
            int[] arrayForArraysSort = Arrays.copyOf(originalArray, size);
            startTime = System.nanoTime();
            Arrays.sort(arrayForArraysSort);
            endTime = System.nanoTime();
            long arraysSortTime = (endTime - startTime) / 1_000_000;

            System.out.printf("%-10d %-15d %-15d %-15d\n", size, insertionSortTime, selectionSortTime, arraysSortTime);
        }
    }

    // 무작위 정수 배열 생성
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10); // 0부터 size*10-1까지의 난수
        }
        return array;
    }
}
