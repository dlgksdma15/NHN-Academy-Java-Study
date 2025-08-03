package ch04.ex6;

// TODO 15: Math 클래스의 모든 정적 멤버 import하기
import static java.lang.Math.*;

public class StaticImportMath {
    public static void main(String[] args) {
        double radius = 5.0;

        // TODO 16: Math. 없이 원의 넓이와 둘레 계산하기
        double area = PI * pow(radius, 2);
        double circumference = 2 * PI * radius;

        // TODO 17: 결과 출력하기
        System.out.println("반지름: " + radius);
        System.out.println("원의 넓이: " + area);
        System.out.println("원의 둘레: " + circumference);

        // TODO 18: 다른 Math 함수들 사용하기
        System.out.println("\n수학 함수 예제:");
        System.out.println("sqrt(16) = " + sqrt(16));
        System.out.println("sin(PI/2) = " + sin(PI / 2));
        System.out.println("max(10, 20) = " + max(10, 20));
        System.out.println("random() = " + random());
    }
}
