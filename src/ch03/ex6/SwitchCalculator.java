package ch03.ex6;

import textio.TextIO;

public class SwitchCalculator {
    public static void main(String[] args) {
        System.out.println("=== Switch 표현식 계산기 ===");

        System.out.print("첫 번째 숫자: ");
        double num1 = TextIO.getlnDouble();

        System.out.print("연산자 (+, -, *, /, %, ^): ");
        String operator = TextIO.getln().trim();

        System.out.print("두 번째 숫자: ");
        double num2 = TextIO.getlnDouble();

        // switch 표현식으로 계산 수행
        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    yield Double.NaN;
                }
                yield num1 / num2;
            }
            case "%" -> {
                if (num2 == 0) {
                    System.out.println("0으로 나머지를 구할 수 없습니다.");
                    yield Double.NaN;
                }
                yield num1 % num2;
            }
            case "^" -> Math.pow(num1, num2);
            default -> {
                System.out.println("지원하지 않는 연산자입니다.");
                yield Double.NaN;
            }
        };

        // 결과 출력
        if (!Double.isNaN(result)) {
            System.out.printf("결과: %.2f %s %.2f = %.2f%n", num1, operator, num2, result);

            // switch 표현식으로 결과 분석
            String analysis = switch (Double.compare(result, 0)) {
                case 1 -> "양수입니다.";
                case -1 -> "음수입니다.";
                case 0 -> "결과는 0입니다.";
                default -> "분석할 수 없습니다.";
            };
            System.out.println("분석: " + analysis);

            // 정수 여부 확인
            String numberType = switch ((result == (int) result) ? 1 : 0) {
                case 1 -> "정수";
                case 0 -> "실수";
                default -> "알 수 없음";
            };
            System.out.println("타입: " + numberType);
        }
    }
}
