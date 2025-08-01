package ch04.ex2;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("=== 계산기 프로그램 ===\n");

        // 기본 연산 테스트
        int a = 15, b = 4;

        System.out.println(a + " + " + b + " = " + add(a, b));
        System.out.println(a + " - " + b + " = " + subtract(a, b));
        System.out.println(a + " × " + b + " = " + multiply(a, b));
        System.out.println(a + " ÷ " + b + " = " + divide(a, b));
        System.out.println(a + " % " + b + " = " + modulo(a, b));

        // 고급 연산 테스트
        System.out.println("\n고급 연산:");
        System.out.println(a + "의 " + b + "제곱 = " + power(a, b));
        System.out.println(a + "의 제곱근 = " + squareRoot(a));
        System.out.println(a + "과 " + b + "의 최대값 = " + max(a, b));
        System.out.println(a + "과 " + b + "의 최소값 = " + min(a, b));
    }

    // 덧셈
    public static int add(int x, int y) {
        return x + y;
    }

    // 뺄셈
    public static int subtract(int x, int y) {
        return x - y;
    }

    // 곱셈
    public static int multiply(int x, int y) {
        return x * y;
    }

    // 나눗셈
    public static double divide(int x, int y) {
        if (y == 0) {
            System.out.println("경고: 0으로 나눌 수 없습니다.");
            return 0;
        }
        return (double) x / y;
    }

    // 나머지
    public static int modulo(int x, int y) {
        if (y == 0) {
            System.out.println("경고: 0으로 나눌 수 없습니다.");
            return 0;
        }
        return x % y;
    }

    // 거듭제곱
    public static double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    // 제곱근
    public static double squareRoot(int number) {
        if (number < 0) {
            System.out.println("경고: 음수의 제곱근은 계산할 수 없습니다.");
            return 0;
        }
        return Math.sqrt(number);
    }

    // 최대값
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // 최소값
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
