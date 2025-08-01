package ch03.ex6;

public class NumberClassifier {
    public static void main(String[] args) {
        int number = 3;

        System.out.println("숫자 " + number + " 분석:");

        // TODO: 숫자 분류 switch문
        // 힌트: -> 연산자 사용

        // 여기에 코드를 작성하세요

        String message = switch (number % 2){
            case 0 -> "짝수입니다";
            case 1 -> "홀수입니다";
            default -> "소수일 가능성이 있습니다.";
        };
        System.out.println(message);
    }
}