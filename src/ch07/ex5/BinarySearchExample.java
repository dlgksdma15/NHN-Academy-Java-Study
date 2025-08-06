package ch07.ex5;
import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] numbers = {12, 23, 34, 45, 56, 67, 78, 89, 90};  // 정렬된 배열

        System.out.println("배열: " + Arrays.toString(numbers));

        // 다양한 값 검색
        int[] targets = {45, 78, 12, 90, 100, 1};

        for (int target : targets) {
            int index = binarySearch(numbers, target);
            System.out.printf("%d의 위치: %d%s\n",
                    target, index, (index == -1 ? " (없음)" : ""));
        }

        // Java 내장 이진 검색과 비교
        System.out.println("\n=== Java 내장 메서드와 비교 ===");
        for (int target : targets) {
            int ourResult = binarySearch(numbers, target);
            int javaResult = Arrays.binarySearch(numbers, target);
            System.out.printf("%d: 우리구현=%d, Java=%d\n",
                    target, ourResult, javaResult);
        }
    }

    // 이진 검색 메서드
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            // 중간 검색 상태 출력
            System.out.printf("  검색 범위: [%d, %d], 중간값: %d\n",
                    left, right, array[middle]);

            if (array[middle] == target) {
                return middle;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;  // 찾지 못함
    }
}
