package ch07.ex7;

public class AdvancedMatrixOperations {

    // 블록 전치 (캐시 효율성 개선)
    public static int[][] transposeBlocked(int[][] matrix, int blockSize) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i += blockSize) {
            for (int j = 0; j < cols; j += blockSize) {
                for (int bi = i; bi < Math.min(i + blockSize, rows); bi++) {
                    for (int bj = j; bj < Math.min(j + blockSize, cols); bj++) {
                        transposed[bj][bi] = matrix[bi][bj];
                    }
                }
            }
        }

        return transposed;
    }

    // 행렬 곱셈
    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("행렬 곱셈 불가 (크기 불일치)");
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

    // 행렬 덧셈
    public static int[][] add(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("행렬 크기 불일치");
        }

        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // 단위 행렬 생성
    public static int[][] createIdentityMatrix(int size) {
        int[][] identity = new int[size][size];
        for (int i = 0; i < size; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }

    // 대각합 계산
    public static int trace(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("정사각 행렬이 아님");
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== 고급 행렬 연산 예제 ===");

        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        MatrixTranspose.printMatrix(A, "행렬 A (2x3)");
        MatrixTranspose.printMatrix(B, "행렬 B (3x2)");

        // 행렬 곱셈
        int[][] product = multiply(A, B);
        MatrixTranspose.printMatrix(product, "A × B");

        // 전치 성질 확인
        int[][] transposedProduct = MatrixTranspose.transpose(product);
        int[][] BT = MatrixTranspose.transpose(B);
        int[][] AT = MatrixTranspose.transpose(A);
        int[][] propertyCheck = multiply(BT, AT);
        System.out.println("(AB)^T == B^T A^T ? " + MatrixTranspose.areMatricesEqual(transposedProduct, propertyCheck));

        // 단위 행렬 & 대각합
        int[][] identity = createIdentityMatrix(3);
        MatrixTranspose.printMatrix(identity, "3x3 단위 행렬");
        System.out.println("단위 행렬의 대각합: " + trace(identity));

        // 블록 전치 성능 비교
        compareTransposeMethods();
    }

    private static void compareTransposeMethods() {
        int size = 512;
        int[][] largeMatrix = MatrixTranspose.generateRandomMatrix(size, size, 100);

        // 일반 전치
        long start = System.nanoTime();
        MatrixTranspose.transpose(largeMatrix);
        long normalTime = System.nanoTime() - start;

        System.out.printf("일반 전치: %.2f ms\n", normalTime / 1_000_000.0);

        // 블록 전치
        int[] blockSizes = {16, 32, 64, 128};
        for (int blockSize : blockSizes) {
            start = System.nanoTime();
            transposeBlocked(largeMatrix, blockSize);
            long blockTime = System.nanoTime() - start;
            System.out.printf("블록 전치 (블록 %d): %.2f ms (%.1fx)\n",
                    blockSize, blockTime / 1_000_000.0, (double) normalTime / blockTime);
        }
    }
}
