package ch02.ex2;

public class AutomaticTypeConversion {
    public static void main(String[] args) {
        byte byteValue = 100;
        short shortValue = byteValue;
        int intValue = shortValue;
        long longValue = intValue;

        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);

        int count = 10;
        double doubleCount = count;
        System.out.println("\n정수 → 실수 변환:");
        System.out.println("count: " + count);
        System.out.println("doubleCount: " + doubleCount);

        int a = 10;
        double b = 3.14;
        double result = a + b;
        System.out.println("\n계산 시 자동 변환:");
        System.out.println("a + b = " + result);
    }
}