package ch07.ex7;

import java.util.Random;

public class MatrixTranspose {

    // 일반 전치
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0][0];

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // 제자리 전치 (정사각 행렬만)
    public static void transposeInPlace(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || matrix[0].length != n) {
            throw new IllegalArgumentException("정사각 행렬이 아닙니다.");
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // 랜덤 행렬 생성
    public static int[][] generateRandomMatrix(int rows, int cols, int maxValue) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(maxValue) + 1;
            }
        }
        return matrix;
    }

    // 행렬 출력
    public static void printMatrix(int[][] matrix, String title) {
        System.out.println("\n" + title + ":");

        if (matrix.length == 0) {
            System.out.println("빈 행렬");
            return;
        }

        for (int[] row : matrix) {
            System.out.print("[ ");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) System.out.print(", ");
            }
            System.out.println(" ]");
        }

        System.out.printf("크기: %d x %d\n", matrix.length, matrix[0].length);
    }

    // 행렬 비교
    public static boolean areMatricesEqual(int[][] m1, int[][] m2) {
        if (m1.length != m2.length) return false;
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) return false;
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== 행렬 전치 연산 예제 ===");

        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        printMatrix(matrix1, "원본 행렬 (3x4)");
        int[][] transposed1 = transpose(matrix1);
        printMatrix(transposed1, "전치 행렬 (4x3)");

        int[][] doubleTransposed = transpose(transposed1);
        System.out.println("전치의 전치 == 원본: " +
                areMatricesEqual(matrix1, doubleTransposed));

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printMatrix(matrix2, "제자리 전치 전");
        transposeInPlace(matrix2);
        printMatrix(matrix2, "제자리 전치 후");
    }
}
