package ch07.ex6;

public class Array2DOperationsExample {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        System.out.println("행렬 1:");
        printMatrix(matrix1);

        System.out.println("\n행렬 2:");
        printMatrix(matrix2);

        // 행렬 덧셈
        int[][] sum = addMatrices(matrix1, matrix2);
        System.out.println("\n행렬 덧셈 결과:");
        printMatrix(sum);

        // 행렬 전치
        int[][] transposed = transpose(matrix1);
        System.out.println("\n행렬 1의 전치:");
        printMatrix(transposed);

        // 행렬 곱셈
        int[][] product = multiplyMatrices(matrix1, matrix2);
        System.out.println("\n행렬 곱셈 결과:");
        printMatrix(product);

        // 통계 계산
        System.out.println("\n=== 통계 정보 ===");
        System.out.println("행렬 1 합계: " + calculateSum(matrix1));
        System.out.println("행렬 1 평균: " + calculateAverage(matrix1));
        System.out.println("행렬 1 최대값: " + findMax(matrix1));
        System.out.println("행렬 1 최소값: " + findMin(matrix1));
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }

    // 행렬 덧셈
    public static int[][] addMatrices(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("행렬 크기가 다릅니다");
        }

        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // 행렬 전치
    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // 행렬 곱셈
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("행렬 곱셈이 불가능합니다");
        }

        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // 합계
    public static int calculateSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }

    // 평균
    public static double calculateAverage(int[][] matrix) {
        int sum = calculateSum(matrix);
        int totalElements = matrix.length * matrix[0].length;
        return (double) sum / totalElements;
    }

    // 최댓값
    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int val : row) {
                if (val > max) max = val;
            }
        }
        return max;
    }

    // 최솟값
    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < min) min = val;
            }
        }
        return min;
    }
}
