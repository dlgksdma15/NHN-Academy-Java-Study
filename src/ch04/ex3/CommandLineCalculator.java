package ch04.ex3;

public class CommandLineCalculator {
    public static void main(String[] args) {
        // TODO 61: 인수 개수 검증하기

        if (args.length != 3) {
            printUsage();
            return;
        }

        // TODO 62: 계산 수행하기
        try {
            double a = Double.parseDouble(args[0]);
            String op = args[1];
            double b = Double.parseDouble(args[2]);

            double result = calculate(a, op, b);
            System.out.printf("결과: %.2f\n", result);


        } catch (NumberFormatException e) {
            System.out.println("오류: 숫자를 올바르게 입력하세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    // TODO 63: 계산 메서드 구현하기
    static double calculate(double a, String op, double b) {
        switch (op){
            case "+" :
                return a + b;
            case "-":
                return a - b;
            case "*" :
                return a * b;
            case "^":
                return Math.pow(a,b);
            case "/":
                if(b == 0){
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자: " + op);
        }
    }

    // TODO 64: 사용법 출력 메서드 구현하기
    static void printUsage() {
        System.out.println("사용법: java CommandLineCalculator <숫자1> <연산자> <숫자2>");
        System.out.println("예시: java CommandLineCalculator 10 + 20");
        System.out.println("지원 연산자: +, -, *, /");
    }
}