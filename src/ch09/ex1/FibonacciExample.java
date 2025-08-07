package ch09.ex1;

public class FibonacciExample {

    /**
     * 기본 재귀 피보나치 (비효율적)
     * F(n) = F(n-1) + F(n-2)
     */
    public static long fibonacciSimple(int n) {
        // TODO 1: 기저 사례 구현
        // 힌트: F(0) = 0, F(1) = 1
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        // TODO 2: 재귀 사례 구현
        // 힌트: F(n) = F(n-1) + F(n-2)


        return fibonacciSimple(n-1) + fibonacciSimple(n - 2);
    }

    /**
     * 메모이제이션을 사용한 효율적인 재귀 피보나치
     */
    public static long fibonacciMemo(int n) {
        long[] memo = new long[n + 1];
        return fibonacciMemoHelper(n, memo);
    }

    private static long fibonacciMemoHelper(int n, long[] memo) {
        // TODO 1: 기저 사례
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // TODO 2: 이미 계산된 값이 있는지 확인
        if (memo[n] != 0) {
            return memo[n];
        }

        // TODO 3: 계산 후 메모에 저장
        memo[n] = fibonacciMemoHelper(n - 1, memo) + fibonacciMemoHelper(n - 2, memo);
        return memo[n];
    }


    public static void main(String[] args) {
        System.out.println("=== 피보나치 수열 예제 ===");

        // 실행 결과:
        // F(0) = 0
        // F(1) = 1
        // F(2) = 1
        // F(3) = 2
        // F(4) = 3
        // F(5) = 5
        // F(6) = 8
        // F(7) = 13
        // F(8) = 21
        // F(9) = 34
        System.out.println("F(0) = " + fibonacciSimple(0));
        System.out.println("F(1) = " + fibonacciSimple(1));
        System.out.println("F(2) = " + fibonacciSimple(2));
        System.out.println("F(3) = " + fibonacciSimple(3));
        System.out.println("F(4) = " + fibonacciSimple(4));
        System.out.println("F(5) = " + fibonacciSimple(5));
        System.out.println("F(6) = " + fibonacciSimple(6));
        System.out.println("F(7) = " + fibonacciSimple(7));
        System.out.println("F(8) = " + fibonacciSimple(8));
        System.out.println("F(9) = " + fibonacciSimple(9));

        System.out.println("\n=== 성능 비교 ===");
        // F(20) 계산:
        // 단순 재귀: 6765 (약 10ms, 21891회 호출)
        // 메모이제이션: 6765 (약 0.1ms)

        int testN = 20;

        long startSimple = System.nanoTime();
        long resultSimple = fibonacciSimple(testN);
        long endSimple = System.nanoTime();

        long startMemo = System.nanoTime();
        long resultMemo = fibonacciMemo(testN);
        long endMemo = System.nanoTime();

        System.out.println("fibonacciSimple(" + testN + ") = " + resultSimple + ", 시간: " + (endSimple - startSimple) / 1_000_000.0 + " ms");
        System.out.println("fibonacciMemo(" + testN + ")   = " + resultMemo + ", 시간: " + (endMemo - startMemo) / 1_000_000.0 + " ms");

    }
}