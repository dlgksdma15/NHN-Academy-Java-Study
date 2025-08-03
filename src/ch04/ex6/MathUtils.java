package ch04.ex6;

class MathUtils {
    // TODO 24: 황금비 상수 정의하기
    public static final double GOLDEN_RATIO = 1.618033988749895;

    // TODO 25: 평균 계산 메서드 구현하기
    public static double average(double... numbers) {
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum / numbers.length;
    }

    // TODO 26: 팩토리얼 계산 메서드 구현하기
    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // TODO 27: 소수 판별 메서드 구현하기
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
