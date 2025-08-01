package ch02.ex3;

public class TrigonometryDemo {
    public static void main(String[] args) {
        // TODO: 45도의 삼각함수 값을 계산하고 출력하세요
        // 힌트:
        // 1. degrees = 45 선언
        // 2. radians = Math.toRadians(degrees)로 라디안 변환
        // 3. "도의 삼각함수 값:" 출력
        // 4. sin, cos, tan 값을 각각 출력

        // TODO: 특별한 각도들의 삼각함수 값을 출력하세요
        // 힌트:
        // 1. "\n특별한 각도:" 출력
        // 2. sin(0°), sin(90°), cos(0°), cos(90°) 출력
        // Math.PI/2는 90도를 라디안으로 변환한 값

        // TODO: 역삼각 함수를 사용하여 각도를 구하세요
        // 힌트:
        // 1. value = 0.5 선언
        // 2. angle = Math.asin(value)로 역사인 계산
        // 3. 라디안과 도 단위로 출력 (Math.toDegrees 사용)

        // 여기에 코드를 작성하세요
        int degrees = 45;
        double radians = Math.toRadians(degrees);
        System.out.println(degrees + "도의 삼각함수 값:");
        System.out.println("sin(45°) = " + Math.sin(radians));
        System.out.println("cos(45°) = " + Math.cos(radians));
        System.out.println("tan(45°) = " + Math.tan(radians));

        System.out.println("\n특별한 각도:");
        System.out.println("sin(0°) = " + Math.sin(0));
        radians = Math.PI/2;
        System.out.println("sin(90°) = " + Math.sin(radians));
        System.out.println("cos(0°) = " + Math.cos(0));
        System.out.println("cos(90°) = " + Math.cos(radians));

        double value = 0.5;
        double angle = Math.asin(value);
        System.out.println("\nasin(0.5°) = " + angle + " 라디안");
        System.out.println("asin(0.5°) = " + Math.toDegrees(angle) + " 도");

    }
}
