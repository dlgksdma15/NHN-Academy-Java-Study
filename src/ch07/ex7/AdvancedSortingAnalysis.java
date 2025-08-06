package ch07.ex7;

import java.util.Arrays;

public class AdvancedSortingAnalysis {

    // 삽입 정렬
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // 버블 정렬
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // 퀵 정렬
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println("=== 다양한 정렬 알고리즘 비교 ===");

        int[] arr = SortingPerformanceComparison.generateRandomIntArray(5000, 10000);

        int[] copy1 = arr.clone();
        int[] copy2 = arr.clone();
        int[] copy3 = arr.clone();
        int[] copy4 = arr.clone();

        long start = System.nanoTime();
        SortingPerformanceComparison.selectionSort(copy1);
        System.out.printf("선택 정렬: %.2f ms\n", (System.nanoTime() - start) / 1_000_000.0);

        start = System.nanoTime();
        insertionSort(copy2);
        System.out.printf("삽입 정렬: %.2f ms\n", (System.nanoTime() - start) / 1_000_000.0);

        start = System.nanoTime();
        bubbleSort(copy3);
        System.out.printf("버블 정렬: %.2f ms\n", (System.nanoTime() - start) / 1_000_000.0);

        start = System.nanoTime();
        quickSort(copy4, 0, copy4.length - 1);
        System.out.printf("퀵 정렬: %.2f ms\n", (System.nanoTime() - start) / 1_000_000.0);

        start = System.nanoTime();
        Arrays.sort(arr);
        System.out.printf("Arrays.sort: %.2f ms\n", (System.nanoTime() - start) / 1_000_000.0);
    }
}
