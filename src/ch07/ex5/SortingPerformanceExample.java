package ch07.ex5;

import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceExample {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 2000};

        for (int size : sizes) {
            System.out.printf("\n=== 배열 크기: %d ===\n", size);

            // 테스트용 데이터 생성
            int[] original = generateRandomArray(size);

            // 삽입 정렬 테스트
            int[] array1 = Arrays.copyOf(original, original.length);
            long startTime = System.nanoTime();
            insertionSort(array1);
            long insertionTime = System.nanoTime() - startTime;

            // 선택 정렬 테스트
            int[] array2 = Arrays.copyOf(original, original.length);
            startTime = System.nanoTime();
            selectionSort(array2);
            long selectionTime = System.nanoTime() - startTime;

            // Java 내장 정렬 테스트
            int[] array3 = Arrays.copyOf(original, original.length);
            startTime = System.nanoTime();
            Arrays.sort(array3);
            long javaTime = System.nanoTime() - startTime;

            // 결과가 같은지 확인
            boolean same = Arrays.equals(array1, array2) && Arrays.equals(array2, array3);

            System.out.printf("삽입 정렬: %8.3f ms\n", insertionTime / 1_000_000.0);
            System.out.printf("선택 정렬: %8.3f ms\n", selectionTime / 1_000_000.0);
            System.out.printf("Java 정렬: %8.3f ms\n", javaTime / 1_000_000.0);
            System.out.printf("결과 일치: %s\n", same ? "예" : "아니오");
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
