package ch04.ex4;

public class GeometryFunctions {
    public static void main(String[] args) {
        System.out.println("=== 기하학 함수 예제 ===\n");

        // 33: 피타고라스 정리
        double c = pythagoras(3, 4);
        System.out.println("직각삼각형 (3, 4)의 빗변: " + c);

        // 34: 원의 면적과 둘레
        double radius = 5;
        System.out.println("\n반지름 " + radius + "인 원:");
        System.out.println("면적: " + circleArea(radius));
        System.out.println("둘레: " + circlePerimeter(radius));

        // 35: 삼각형 면적
        double area = triangleArea(3, 4, 5);
        System.out.println("\n변의 길이가 3, 4, 5인 삼각형의 면적: " + area);

        // 36: 두 점 사이의 거리
        double distance = distanceBetweenPoints(0, 0, 3, 4);
        System.out.println("\n(0,0)과 (3,4) 사이의 거리: " + distance);
    }

    // 37: 피타고라스 정리
    static double pythagoras(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    // 38: 원의 면적
    static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    // 39: 원의 둘레
    static double circlePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    // 40: 삼각형 면적 (Heron 공식)
    static double triangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // 41: 두 점 사이의 거리
    static double distanceBetweenPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
