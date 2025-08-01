package ch02.ex5;

public class AutoTypeConversion {
    public static void main(String[] args) {
        System.out.println("=== 자동 타입 변환 ===");

        // 작은 타입에서 큰 타입으로
        byte byteValue = 100;
        short shortValue = byteValue;
        int intValue = shortValue;
        long longValue = intValue;
        float floatValue = longValue;
        double doubleValue = floatValue;

        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);

        // 연산 시 자동 변환
        System.out.println("\n=== 연산 시 자동 변환 ===");
        int x = 10;
        double y = 3.14;

        // int + double = double
        double result = x + y;
        System.out.println(x + " + " + y + " = " + result);

        // 문자의 자동 변환
        char ch = 'A';
        int chValue = ch;  // char → int
        System.out.println("\n'" + ch + "'의 숫자값: " + chValue);
    }
}