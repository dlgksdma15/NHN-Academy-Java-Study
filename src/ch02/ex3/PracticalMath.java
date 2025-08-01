package ch02.ex3;

public class PracticalMath {
    public static void main(String[] args) {
        // TODO: 피타고라스 정리를 사용하여 직각삼각형의 빗변을 계산하세요
        // 힌트:
        // 1. a = 3.0, b = 4.0 선언
        // 2. c = Math.sqrt(a*a + b*b) 계산
        // 3. "직각삼각형의 빗변: " + c 출력

        // TODO: 원의 넓이와 둘레를 계산하세요
        // 힌트:
        // 1. radius = 5.0 선언
        // 2. area = Math.PI * radius * radius 계산
        // 3. circumference = 2 * Math.PI * radius 계산
        // 4. 반지름, 넓이, 둘레 출력

        // TODO: 복리 계산을 수행하세요
        // 힌트:
        // 1. principal = 10000 (원금)
        // 2. rate = 0.05 (연이율 5%)
        // 3. years = 10 (기간)
        // 4. amount = principal * Math.pow(1 + rate, years) 계산
        // 5. 원금과 10년 후 금액 출력

        // TODO: 각도 변환을 수행하세요
        // 힌트:
        // 1. angleInDegrees = 180 선언
        // 2. angleInRadians = Math.toRadians(angleInDegrees) 변환
        // 3. 도와 라디안 값 출력

        // 여기에 코드를 작성하세요

        double a = 3.0, b = 4.0;
        double c = Math.sqrt(a*a + b*b);
        System.out.println("직각삼각형의 빗변: " + c);
        double radius = 5.0;
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        System.out.println("반지름 " + radius + "인 원의 넓이: " + area);
        System.out.println("반지름 " + radius + "인 원의 둘레: " + circumference);
        double principal = 10000;
        double rate = 0.05;
        double years = 10;
        double amount = principal * Math.pow(1 + rate, years);
        System.out.println("10년 후 금액: $" + amount);
        double angleInDegrees = 180;
        double angleInRadians = Math.toRadians(angleInDegrees);
        System.out.println("180도 = " + angleInRadians + " 라디안");

    }
}