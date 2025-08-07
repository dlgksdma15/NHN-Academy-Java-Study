package ch09.ex1;

public class TailRecursion {

    /**
     * 일반 재귀 팩토리얼
     */
    public static long factorialNormal(int n) {
        if (n <= 1) return 1;
        return n * factorialNormal(n - 1);
    }

    /**
     * 꼬리 재귀 팩토리얼
     */
    public static long factorialTail(int n) {
        return factorialTailHelper(n, 1);
    }

    private static long factorialTailHelper(int n, long acc) {
        // TODO: 꼬리 재귀 구현
        if (n <= 1) return acc;
        return factorialTailHelper(n - 1, acc * n);
    }


    public static void main(String[] args) {
        System.out.println("=== 꼬리 재귀 예제 ===");

        System.out.println("일반 재귀: 5! = " + factorialNormal(5));
        System.out.println("꼬리 재귀: 5! = " + factorialTail(5));
    }

}
