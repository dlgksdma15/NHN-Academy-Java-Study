package ch02.ex2;

public class FloatingPointTypes {
    public static void main(String[] args) {
        // TODO: float 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        float pi = 3.14159f;
        float price = 19.99F;
        float scientificNotation = 6.02e23f;

        // TODO: double 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        double e = 2.718281828459045;
        double atomRadius = 1.2e-10;
        double lightSpeed = 299_792_458.0;

        // TODO: float와 double의 정밀도 차이를 비교하세요
        // 힌트:
        float floatValue = 1.12345678901234567890f;
        double doubleValue = 1.12345678901234567890;
        System.out.println("float 정밀도: " + floatValue);
        System.out.println("doubleValue 정밀도: " + doubleValue);

        // TODO: 원의 넓이를 계산하고 출력하세요
        // 힌트:
        double radius = 5.0;
        double area = Math.PI * radius * radius;
        System.out.printf("반지름 %.1f인 원의 넓이: %f",radius,area);

        // 여기에 코드를 작성하세요
    }
}