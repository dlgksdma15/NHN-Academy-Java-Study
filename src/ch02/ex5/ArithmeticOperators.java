package ch02.ex5;

public class ArithmeticOperators {
    public static void main(String[] args) {
        // TODO: 기본 산술 연산을 수행하고 결과를 출력하세요
        // 힌트:
        int a = 17, b = 5;
        System.out.println("=== 정수 연산 ===");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));   // 정수 나눗셈
        System.out.println("a % b = " + (a % b));   // 나머지 연산

        double x = 17.0, y = 5.0;
        System.out.println("\n=== 실수 연산 ===");
        System.out.println("x / y = " + (x / y));
        System.out.println("x % y = " + (x % y));

        System.out.println("\n=== 나머지 연산 테스트 ===");
        System.out.println(" 17 % 5  = " + (17 % 5));
        System.out.println("-17 % 5  = " + (-17 % 5));
        System.out.println(" 17 % -5 = " + (17 % -5));
        System.out.println("-17 % -5 = " + (-17 % -5));
    }
}
