package ch07.ex6;

public class Array2DTraversalExample {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println("원본 배열:");
        printMatrix(matrix);

        System.out.println("\n=== 다양한 순회 방법 ===");

        // 행 우선 순회
        System.out.println("행 우선 순회 (Row-major):");
        traverseRowMajor(matrix);

        // 열 우선 순회
        System.out.println("\n열 우선 순회 (Column-major):");
        traverseColumnMajor(matrix);

        // 대각선 순회
        System.out.println("\n대각선 순회:");
        traverseDiagonal(matrix);

        // 나선형 순회
        System.out.println("\n나선형 순회:");
        traverseSpiral(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%3d", element);
            }
            System.out.println();
        }
    }

    // 행 우선 순회
    public static void traverseRowMajor(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    // 열 우선 순회
    public static void traverseColumnMajor(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    // 대각선 순회
    public static void traverseDiagonal(int[][] matrix) {
        int minDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < minDim; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    // 나선형 순회 (이미 완성됨)
    public static void traverseSpiral(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // 위쪽 행
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;

            // 오른쪽 열
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // 아래쪽 행
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }

            // 왼쪽 열
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
}
