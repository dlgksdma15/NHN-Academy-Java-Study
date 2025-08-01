package ch02.ex2;

public class ExplicitTypeConversion {
    public static void main(String[] args) {
        double pi = 3.14159;
        int intPi = (int) pi;
        System.out.println("double: " + pi);
        System.out.println("int (캐스팅): " + intPi);

        int bigNumber = 300;
        byte smallByte = (byte) bigNumber;
        System.out.println("\n데이터 손실 예제:");
        System.out.println("원본 int: " + bigNumber);
        System.out.println("캐스팅된 byte: " + smallByte);

        int x = 7, y = 2;
        int result1 = x / y;
        double result2 = (double) x / y;
        System.out.println("\n나눗셈 캐스팅:");
        System.out.println("정수 나눗셈 결과: " + result1);
        System.out.println("실수 나눗셈 결과: " + result2);
    }
}