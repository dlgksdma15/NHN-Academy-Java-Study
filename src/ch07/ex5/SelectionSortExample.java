package ch07.ex5;

import java.util.Arrays;

public class SelectionSortExample {
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};
        System.out.println("정렬 전: " + Arrays.toString(numbers));
        selectionSort(numbers);
        System.out.println("정렬 후: " + Arrays.toString(numbers));

        System.out.println("\n--- 정렬 과정 상세 --- ");
        int[] numbers2 = {29, 10, 14, 37, 13};
        System.out.println("정렬 전: " + Arrays.toString(numbers2));
        selectionSortWithSteps(numbers2);
        System.out.println("정렬 후: " + Arrays.toString(numbers2));
    }

    // TODO: 선택 정렬 메서드를 작성하세요
    // 메서드명: selectionSort, 매개변수: int[] array
    // 힌트: 매 단계에서 최소값을 찾아 현재 위치와 교환
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 최소값을 현재 위치와 교환
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // TODO: 선택 정렬 과정을 단계별로 출력하는 메서드를 작성하세요
    // 메서드명: selectionSortWithSteps, 매개변수: int[] array
    public static void selectionSortWithSteps(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            System.out.println("\n단계 " + (i + 1) + ": " + Arrays.toString(array) + " (현재 위치: " + array[i] + ")");
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            System.out.println("  최소값: " + array[minIndex] + " (인덱스: " + minIndex + ")");
            // 최소값을 현재 위치와 교환
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            System.out.println("  교환 후: " + Arrays.toString(array));
        }
    }
}
