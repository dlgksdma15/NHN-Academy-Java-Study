package ch07.ex6;

import java.util.Arrays;

public class Array2DBasicExample {
    public static void main(String[] args) {
        // 방법 1: 크기 지정으로 생성
        int[][] matrix1 = new int[3][4];  // 3행 4열 (모든 요소는 0)
        System.out.println("빈 3x4 배열 생성:");
        printArray2D(matrix1);

        // 방법 2: 초기화 리스트로 생성
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("\n초기화 리스트로 생성:");
        printArray2D(matrix2);

        // 방법 3: new 배열 리터럴
        int[][] matrix3 = new int[][] {
                {10, 20},
                {30, 40},
                {50, 60}
        };
        System.out.println("\n배열 리터럴로 생성:");
        printArray2D(matrix3);

        // 배열 정보 출력
        System.out.println("\n배열 정보:");
        System.out.println("matrix2 행 수: " + matrix2.length);
        System.out.println("matrix2 열 수: " + matrix2[0].length);
        System.out.println("matrix2[1][2] 값: " + matrix2[1][2]);
    }

    // 이차원 배열 출력 메서드
    public static void printArray2D(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}

