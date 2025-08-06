package ch07.ex5;

import java.util.Arrays;

public class InsertionSortExample {
    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6};
        System.out.println("정렬 전: " + Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println("정렬 후: " + Arrays.toString(numbers));

        System.out.println("\n--- 정렬 과정 상세 --- ");
        int[] numbers2 = {29, 10, 14, 37, 13};
        System.out.println("정렬 전: " + Arrays.toString(numbers2));
        insertionSortWithSteps(numbers2);
        System.out.println("정렬 후: " + Arrays.toString(numbers2));
    }

    // TODO: 삽입 정렬 메서드를 작성하세요
    // 메서드명: insertionSort, 매개변수: int[] array
    // 힌트: 두 번째 요소부터 시작하여 이전 요소들과 비교하며 삽입
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

    // TODO: 삽입 정렬 과정을 단계별로 출력하는 메서드를 작성하세요
    // 메서드명: insertionSortWithSteps, 매개변수: int[] array
    public static void insertionSortWithSteps(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            System.out.println("\n단계 " + i + ": " + Arrays.toString(array) + " (key: " + key + ")");

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                System.out.println("  이동: " + Arrays.toString(array));
            }
            array[j + 1] = key;
            System.out.println("  삽입: " + Arrays.toString(array));
        }
    }
}
