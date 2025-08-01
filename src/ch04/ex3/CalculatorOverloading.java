package ch04.ex3;

public class CalculatorOverloading {
    public static void main(String[] args) {
        System.out.println("=== 계산기 오버로딩 ===\n");

        // 35: 두 수의 합 테스트
        System.out.println("10 + 20 = " + add(10, 20));
        System.out.println("1.5 + 2.5 = " + add(1.5, 2.5));

        // 36: 세 수의 합 테스트
        System.out.println("10 + 20 + 30 = " + add(10, 20, 30));
        System.out.println("1.1 + 2.2 + 3.3 = " + add(1.1, 2.2, 3.3));

        // 37: 배열의 합 테스트
        int[] intArray = {10, 20, 30, 40};
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        System.out.println("정수 배열 합 = " + add(intArray));
        System.out.println("실수 배열 합 = " + add(doubleArray));

        // 38: 평균 계산 테스트
        System.out.println("\n평균 계산:");
        System.out.println("평균(10, 20) = " + average(10, 20));
        System.out.println("평균(10, 20, 30) = " + average(10, 20, 30));
        System.out.println("배열 평균 = " + average(intArray));
    }

    // 39: add 메서드들 구현
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static double add(double a, double b, double c) {
        return a + b + c;
    }

    static int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) sum += num;
        return sum;
    }

    static double add(double[] numbers) {
        double sum = 0;
        for (double num : numbers) sum += num;
        return sum;
    }

    // 40: average 메서드들 구현
    static double average(int a, int b) {
        return (a + b) / 2.0;
    }

    static double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    static double average(int[] numbers) {
        if (numbers.length == 0) return 0;
        return (double) add(numbers) / numbers.length;
    }
}
