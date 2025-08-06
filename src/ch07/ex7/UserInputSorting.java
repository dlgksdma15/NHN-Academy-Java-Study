package ch07.ex7;

import java.util.Scanner;

public class UserInputSorting {

    /**
     * 삽입 정렬 구현
     */
    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    /**
     * 선택 정렬 구현
     */
    public static void selectionSort(double[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                double temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * 배열이 정렬되었는지 확인
     */
    public static boolean isSorted(double[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 배열 출력
     */
    public static void printArray(double[] array, String title) {
        System.out.println(title + ":");

        if (array.length <= 20) {
            // 작은 배열은 모두 출력
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%.2f", array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } else {
            // 큰 배열은 처음 10개와 마지막 10개만 출력
            System.out.print("[");
            for (int i = 0; i < 5; i++) {
                System.out.printf("%.2f, ", array[i]);
            }
            System.out.print("..., ");
            for (int i = array.length - 5; i < array.length; i++) {
                System.out.printf("%.2f", array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        System.out.println("총 개수: " + array.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[100];  // 최대 100개
        int count = 0;

        System.out.println("=== 양의 실수 정렬 프로그램 ===");
        System.out.println("양의 실수를 입력하세요 (0을 입력하면 종료):");
        System.out.println("최대 100개까지 입력 가능합니다.");

        // 사용자 입력 받기
        while (count < 100) {
            System.out.printf("숫자 %d: ", count + 1);

            try {
                double input = scanner.nextDouble();

                if (input == 0) {
                    break;  // 입력 종료
                }

                if (input > 0) {
                    numbers[count] = input;
                    count++;
                } else {
                    System.out.println("양수만 입력해주세요.");
                }

            } catch (Exception e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                scanner.nextLine();  // 잘못된 입력 제거
            }
        }

        if (count == 0) {
            System.out.println("입력된 숫자가 없습니다.");
            scanner.close();
            return;
        }

        // 입력된 개수만큼 배열 크기 조정
        double[] inputArray = new double[count];
        System.arraycopy(numbers, 0, inputArray, 0, count);

        System.out.println("\n" + "=".repeat(50));
        printArray(inputArray, "입력된 숫자들");

        // 정렬 방법 선택
        System.out.println("\n정렬 방법을 선택하세요:");
        System.out.println("1. 삽입 정렬");
        System.out.println("2. 선택 정렬");
        System.out.print("선택 (1 또는 2): ");

        int choice = 1;  // 기본값
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 삽입 정렬을 사용합니다.");
        }

        // 정렬 수행
        long startTime = System.nanoTime();

        if (choice == 2) {
            System.out.println("\n선택 정렬을 수행합니다...");
            selectionSort(inputArray);
        } else {
            System.out.println("\n삽입 정렬을 수행합니다...");
            insertionSort(inputArray);
        }

        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("정렬 완료!");
        System.out.printf("실행 시간: %.3f ms\n", executionTime);

        // 결과 출력
        printArray(inputArray, "정렬된 숫자들");

        // 정렬 검증
        boolean sorted = isSorted(inputArray);
        System.out.println("정렬 검증: " + (sorted ? "성공" : "실패"));

        // 통계 정보
        displayStatistics(inputArray);

        scanner.close();
    }

    /**
     * 통계 정보 출력
     */
    private static void displayStatistics(double[] array) {
        if (array.length == 0) return;

        double min = array[0];
        double max = array[array.length - 1];
        double sum = 0;

        for (double num : array) {
            sum += num;
        }

        double average = sum / array.length;
        double median;

        if (array.length % 2 == 0) {
            median = (array[array.length/2 - 1] + array[array.length/2]) / 2.0;
        } else {
            median = array[array.length/2];
        }

        System.out.println("\n=== 통계 정보 ===");
        System.out.printf("최솟값: %.2f\n", min);
        System.out.printf("최댓값: %.2f\n", max);
        System.out.printf("합계:   %.2f\n", sum);
        System.out.printf("평균:   %.2f\n", average);
        System.out.printf("중앙값: %.2f\n", median);
        System.out.printf("범위:   %.2f\n", max - min);
    }
}