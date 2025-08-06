package ch07.ex6;

public class SymmetricMatrixExample {

    // 대칭 행렬 클래스
    static class SymmetricMatrix {
        private double[][] data;  // 삼각형 배열로 저장
        private int size;

        // 생성자: 삼각형 모양의 2차원 배열 생성
        public SymmetricMatrix(int size) {
            this.size = size;
            data = new double[size][];
            for (int i = 0; i < size; i++) {
                data[i] = new double[i + 1];  // 1, 2, 3 ... 요소만 저장
            }
        }

        // 값 조회 (대칭성 이용)
        public double get(int row, int col) {
            if (row >= size || col >= size) {
                throw new IndexOutOfBoundsException("인덱스 범위 초과");
            }
            if (row >= col) {
                return data[row][col];
            } else {
                return data[col][row];
            }
        }

        // 값 설정 (대칭성 이용)
        public void set(int row, int col, double value) {
            if (row >= size || col >= size) {
                throw new IndexOutOfBoundsException("인덱스 범위 초과");
            }
            if (row >= col) {
                data[row][col] = value;
            } else {
                data[col][row] = value;
            }
        }

        public int getSize() {
            return size;
        }

        // 행렬 출력
        public void printMatrix() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.printf("%6.2f", get(i, j));
                }
                System.out.println();
            }
        }

        // 저장 정보 출력
        public void printStorageInfo() {
            int totalElements = size * size;
            int storedElements = size * (size + 1) / 2; // 삼각형 저장 개수
            double savedPercent = (1 - (double) storedElements / totalElements) * 100;

            System.out.println("=== 저장 정보 ===");
            System.out.println("행렬 크기: " + size + "x" + size);
            System.out.println("전체 요소 수: " + totalElements);
            System.out.println("실제 저장된 요소 수: " + storedElements);
            System.out.printf("메모리 절약률: %.1f%%\n", savedPercent);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 대칭 행렬 예제 ===");

        // 5x5 대칭 행렬 생성
        SymmetricMatrix matrix = new SymmetricMatrix(5);

        // 값 설정 (대칭으로 자동 저장됨)
        matrix.set(0, 0, 1.0);
        matrix.set(0, 1, 2.0);
        matrix.set(0, 2, 3.0);
        matrix.set(1, 1, 4.0);
        matrix.set(1, 2, 5.0);
        matrix.set(1, 3, 6.0);
        matrix.set(2, 2, 7.0);
        matrix.set(2, 3, 8.0);
        matrix.set(2, 4, 9.0);
        matrix.set(3, 3, 10.0);
        matrix.set(3, 4, 11.0);
        matrix.set(4, 4, 12.0);

        System.out.println("대칭 행렬:");
        matrix.printMatrix();

        System.out.println();
        matrix.printStorageInfo();

        // 대칭성 확인
        System.out.println("\n=== 대칭성 확인 ===");
        System.out.println("matrix[1][3] = " + matrix.get(1, 3));
        System.out.println("matrix[3][1] = " + matrix.get(3, 1));
        System.out.println("대칭? " + (matrix.get(1, 3) == matrix.get(3, 1)));

        // 상관관계 행렬 예제
        System.out.println("\n=== 상관관계 행렬 예제 ===");
        SymmetricMatrix correlation = createCorrelationMatrix();
        correlation.printMatrix();
    }

    public static SymmetricMatrix createCorrelationMatrix() {
        // 5개 변수간의 상관관계 행렬 (예시)
        SymmetricMatrix corr = new SymmetricMatrix(5);

        // 대각선은 1.0 (자기 자신과의 상관관계)
        for (int i = 0; i < 5; i++) {
            corr.set(i, i, 1.0);
        }

        // 상관관계 값들 설정
        corr.set(0, 1, 0.85);
        corr.set(0, 2, 0.72);
        corr.set(0, 3, 0.43);
        corr.set(0, 4, 0.67);
        corr.set(1, 2, 0.91);
        corr.set(1, 3, 0.58);
        corr.set(1, 4, 0.74);
        corr.set(2, 3, 0.39);
        corr.set(2, 4, 0.82);
        corr.set(3, 4, 0.51);

        return corr;
    }
}
