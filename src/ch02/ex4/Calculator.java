package ch02.ex4;

import textio.TextIO;

public class Calculator {
    public static void main(String[] args) {
        // TODO: TextIO를 사용하여 간단한 계산기를 만드세요
        System.out.println("=== 간단한 계산기 ===");

        System.out.print("첫 번째 숫자: ");
        double num1 = TextIO.getlnDouble();

        System.out.print("연산자 (+, -, *, /): ");
        char op = TextIO.getlnChar();

        System.out.print("두 번째 숫자: ");
        double num2 = TextIO.getlnDouble();

        double result = 0;
        boolean valid = true;

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    valid = false;
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                valid = false;
        }

        if (valid) {
            System.out.printf("\n%.2f %c %.2f = %.2f\n", num1, op, num2, result);
        }
    }
}