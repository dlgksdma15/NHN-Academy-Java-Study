package ch04.ex4;

public class MathFunctions {
    public static void main(String[] args) {
        System.out.println("=== 수학 함수 예제 ===\n");

        // 20: 절댓값 함수
        System.out.println("|-5| = " + abs(-5));
        System.out.println("|3| = " + abs(3));

        // 21: 최대값, 최소값
        System.out.println("max(10, 7) = " + max(10, 7));
        System.out.println("min(10, 7) = " + min(10, 7));

        // 22: 거듭제곱
        System.out.println("2^10 = " + power(2, 10));
        System.out.println("3^4 = " + power(3, 4));

        // 23: 팩토리얼
        System.out.println("5! = " + factorial(5));
        System.out.println("0! = " + factorial(0));

        // 24: 최대공약수
        System.out.println("gcd(48, 18) = " + gcd(48, 18));

        // 25: 최소공배수
        System.out.println("lcm(12, 18) = " + lcm(12, 18));
    }

    // 26: 절댓값
    static int abs(int n) {
        return (n < 0) ? -n : n;
    }

    // 27: 최대값
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // 28: 최소값
    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    // 29: 거듭제곱
    static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // 30: 팩토리얼
    static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 31: 최대공약수 (유클리드 호제법)
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 32: 최소공배수
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
