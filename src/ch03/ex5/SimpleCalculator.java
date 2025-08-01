package ch03.ex5;

import textio.TextIO;

import textio.TextIO;

public class SimpleCalculator {
    public static void main(String[] args) {
        System.out.println("=== 간단한 계산기 ===");

        System.out.print("첫 번째 숫자: ");
        double num1 = TextIO.getlnDouble();

        System.out.print("연산자 (+, -, *, /, %, ^): ");
        String operator = TextIO.getln().trim();

        System.out.print("두 번째 숫자: ");
        double num2 = TextIO.getlnDouble();

        double result = 0;
        boolean validOperation = true;
        String operation = "";

        // 연산자별 계산
        if (operator.equals("+")) {
            result = num1 + num2;
            operation = "덧셈";
        } else if (operator.equals("-")) {
            result = num1 - num2;
            operation = "뺄셈";
        } else if (operator.equals("*")) {
            result = num1 * num2;
            operation = "곱셈";
        } else if (operator.equals("/")) {
            if (num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                validOperation = false;
            } else {
                result = num1 / num2;
                operation = "나눗셈";
            }
        } else if (operator.equals("%")) {
            if (num2 == 0) {
                System.out.println("0으로 나머지 연산을 할 수 없습니다.");
                validOperation = false;
            } else {
                result = num1 % num2;
                operation = "나머지";
            }
        } else if (operator.equals("^")) {
            result = Math.pow(num1, num2);
            operation = "거듭제곱";
        } else {
            System.out.println("지원하지 않는 연산자입니다.");
            validOperation = false;
        }

        if (validOperation) {
            System.out.println("\n=== 계산 결과 ===");
            System.out.println("연산: " + operation);
            System.out.printf("%.2f %s %.2f = %.2f%n", num1, operator, num2, result);

            // 추가 정보: 정수 여부 확인
            if ((int) result == result) {
                System.out.println("결과는 양수입니다.");
            } else {
                System.out.println("결과는 실수입니다.");
            }
        }
    }
}
