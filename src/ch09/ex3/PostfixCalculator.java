package ch09.ex3;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.EmptyStackException;
import java.lang.Math;

public class PostfixCalculator {

    /**
     * 후위 표기법 표현식을 계산
     */
    public static double evaluate(String expression) {
        GenericLinkedStack<Double> stack = new GenericLinkedStack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);

        try {
            // TODO 1: tokenizer로 각 토큰을 순회
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                // TODO 2: 토큰이 숫자면 스택에 push
                if (isNumber(token)) {
                    stack.push(Double.parseDouble(token));
                }
                // TODO 3: 토큰이 연산자면:
                else if (isOperator(token)) {
                    //   - 스택에서 두 개의 숫자를 pop (b를 먼저, 그 다음 a)
                    double b = stack.pop();
                    double a = stack.pop();
                    //   - applyOperator(a, b, token)으로 계산
                    double result = applyOperator(a, b, token);
                    //   - 결과를 스택에 push
                    stack.push(result);
                } else {
                    throw new IllegalArgumentException("유효하지 않은 토큰: " + token);
                }
            }
        } catch (EmptyStackException e) {
            throw new IllegalArgumentException("표현식이 올바르지 않습니다.");
        }

        // TODO 4: 모든 토큰 처리 후 스택에 하나의 값만 남았는지 확인
        if (stack.size() != 1) {
            throw new IllegalArgumentException("표현식에 너무 많은 숫자가 있습니다.");
        }

        // TODO 5: 최종 결과 반환
        return stack.pop();
    }

    /**
     * 중위 표기법을 후위 표기법으로 변환
     */
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        GenericLinkedStack<Character> operatorStack = new GenericLinkedStack<>();
        StringTokenizer tokenizer = new StringTokenizer(infix, "+-*/^()", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;

            if (isNumber(token)) {
                postfix.append(token).append(" ");
            } else if (token.equals("(")) {
                operatorStack.push('(');
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                if (!operatorStack.isEmpty()) {
                    operatorStack.pop();  // '(' 제거
                }
            } else if (token.length() == 1 && isOperator(token)) {
                char op = token.charAt(0);
                while (!operatorStack.isEmpty() &&
                        operatorStack.peek() != '(' &&
                        precedence(operatorStack.peek()) >= precedence(op)) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(op);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    /**
     * 연산자 우선순위 반환
     */
    private static int precedence(char operator) {
        // TODO: 연산자에 따른 우선순위 반환
        // +, - : 1
        // *, / : 2
        // ^ : 3
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    /**
     * 문자열이 숫자인지 확인
     */
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 문자열이 연산자인지 확인
     */
    private static boolean isOperator(String token) {
        // TODO: token이 +, -, *, /, ^ 중 하나인지 확인
        return "+-*/^".contains(token);
    }

    /**
     * 연산자 적용
     */
    private static double applyOperator(double a, double b, String operator) {
        // TODO: operator에 따라 적절한 연산 수행
        // +: a + b
        // -: a - b
        // *: a * b
        // /: a / b (b가 0이면 ArithmeticException)
        // ^: Math.pow(a, b)
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다");
                return a / b;
            case "^": return Math.pow(a, b);
            default: throw new IllegalArgumentException("알 수 없는 연산자: " + operator);
        }
    }

    /**
     * 계산 과정을 시각화
     */
    public static void visualizeCalculation(String expression) {
        System.out.println("\n=== 후위 표기법 계산 시각화 ===");
        System.out.println("표현식: " + expression);
        System.out.println();

        GenericLinkedStack<Double> stack = new GenericLinkedStack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);
        int step = 1;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("단계 " + step++ + ": 토큰 '" + token + "' 처리");

            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
                System.out.println("  동작: 스택에 푸시");
            } else if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
                System.out.println("  동작: " + a + " " + token + " " + b + " = " + result);
            }

            System.out.println("  스택: " + stack);
            System.out.println();
        }

        System.out.println("최종 결과: " + stack.pop());
    }

    public static void main(String[] args) {
        System.out.println("=== 후위 표기법 계산기 ===");

        // 테스트 케이스
        String[] infixExpressions = {
                "2 + 3",
                "2 + 3 * 4",
                "(2 + 3) * 4",
                "2 * (3 + 4)",
                "2 + 3 * 4 - 5",
                "2 ^ 3 + 1"
        };

        for (String infix : infixExpressions) {
            System.out.println("\n중위: " + infix);
            String postfix = infixToPostfix(infix);
            System.out.println("후위: " + postfix);
            double result = evaluate(postfix);
            System.out.println("결과: " + result);
        }

        // 시각화 예제
        visualizeCalculation("2 3 4 * +");

        // 대화형 계산기
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== 대화형 계산기 ===");
        System.out.println("후위 표기법 표현식을 입력하세요 (종료: quit):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                double result = evaluate(input);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }

        scanner.close();
    }
}