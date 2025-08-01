package ch02.ex5;

public class CalculatorExample {
    public static void main(String[] args) {
        // TODO: 조건 연산자를 활용한 계산기를 만드세요
        System.out.println("=== 계산기 예제 ===");

        double num1 = 10.5;
        double num2 = 3.2;
        char operator = '*';

        // 올바른 연산자인지 체크
        boolean validOperation = operator == '+' || operator == '-' || operator == '*' || operator == '/';

        double result = validOperation
                ? (operator == '+' ? num1 + num2
                : operator == '-' ? num1 - num2
                : operator == '*' ? num1 * num2
                : num2 != 0 ? num1 / num2 : Double.NaN) // 나누기 0 방지
                : Double.NaN;

        if (validOperation) {
            System.out.printf("%.1f %c %.1f = %.2f%n", num1, operator, num2, result);

            // 나눗셈일 경우 나머지 계산 (실수 나머지)
            if (operator == '/') {
                double remainder = num1 % num2;
                System.out.printf("나머지: %.2f%n", remainder);
            }
        } else {
            System.out.println("잘못된 연산자입니다.");
        }
    }
}
