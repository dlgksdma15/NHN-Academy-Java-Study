package ch07.ex6;

public class ArrayPerformanceExample {
    public static void main(String[] args) {
        int size = 1000;

        // 이차원 배열
        int[][] array2D = new int[size][size];

        // 일차원 배열 (같은 크기)
        int[] array1D = new int[size * size];

        System.out.println("=== 배열 성능 비교 ===");
        System.out.println("배열 크기: " + size + "x" + size);

        // 이차원 배열 초기화 시간 측정
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array2D[i][j] = i * size + j;
            }
        }
        long time2D = System.nanoTime() - start;

        // 일차원 배열 초기화 시간 측정
        start = System.nanoTime();
        for (int i = 0; i < size * size; i++) {
            array1D[i] = i;
        }
        long time1D = System.nanoTime() - start;

        System.out.println("초기화 시간:");
        System.out.printf("이차원 배열: %.2f ms\n", time2D / 1_000_000.0);
        System.out.printf("일차원 배열: %.2f ms\n", time1D / 1_000_000.0);
        System.out.printf("성능 비율: %.2fx\n", (double) time2D / time1D);

        // 순회 성능 비교
        compareTraversalMethods(array2D);

        // 메모리 사용량 정보
        printMemoryInfo(size);
    }

    // 순회 방법별 성능 비교
    public static void compareTraversalMethods(int[][] array) {
        System.out.println("\n=== 순회 방법별 성능 비교 ===");
        int sum = 0;
        long start, elapsed;

        // 행 우선 순회
        start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        elapsed = System.nanoTime() - start;
        System.out.printf("행 우선 순회: %.2f ms (합계: %d)\n", elapsed / 1_000_000.0, sum);

        // 열 우선 순회
        sum = 0;
        start = System.nanoTime();
        for (int j = 0; j < array[0].length; j++) {
            for (int i = 0; i < array.length; i++) {
                sum += array[i][j];
            }
        }
        elapsed = System.nanoTime() - start;
        System.out.printf("열 우선 순회: %.2f ms (합계: %d)\n", elapsed / 1_000_000.0, sum);

        // Enhanced for 순회
        sum = 0;
        start = System.nanoTime();
        for (int[] row : array) {
            for (int val : row) {
                sum += val;
            }
        }
        elapsed = System.nanoTime() - start;
        System.out.printf("Enhanced for: %.2f ms (합계: %d)\n", elapsed / 1_000_000.0, sum);
    }

    // 메모리 사용량 정보
    public static void printMemoryInfo(int size) {
        int totalElements = size * size;
        int dataSizeBytes = totalElements * Integer.BYTES; // 데이터 크기 (4바이트)
        int referenceOverheadBytes = size * 8; // 64비트 참조 오버헤드 가정

        double dataSizeMB = dataSizeBytes / (1024.0 * 1024.0);
        double referenceMB = referenceOverheadBytes / (1024.0 * 1024.0);
        double totalMB = dataSizeMB + referenceMB;

        System.out.println("\n=== 메모리 사용 정보 ===");
        System.out.printf("데이터 크기: %.2f MB\n", dataSizeMB);
        System.out.printf("참조 오버헤드: %.2f MB\n", referenceMB);
        System.out.printf("총 메모리 사용량: %.2f MB\n", totalMB);
    }
}
