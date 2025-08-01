package ch02.ex2;

import static java.lang.Long.*;

public class IntegerTypes {
    public static void main(String[] args) {
        // TODO: byte 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        byte age = 25;
        byte temperature = -10;
        // 주의: byte tooBig = 200은 범위 초과로 오류 발생

        // TODO: short 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        short year = 2024;
        short population = 30000;

        // TODO: int 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        int salary = 50000000;
        int distance = 384400;

        // TODO: long 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        long worldPopulation = 7_900_000_000L;
        long nationalDebt = 1_500_000_000_000L;
        // 주의: 밑줄(_)은 숫자 가독성을 위해 사용 가능

        // TODO: 각 정수 타입의 최대/최소값을 출력하세요
        // 힌트:
        byte maxValue = Byte.MAX_VALUE;
        byte minValue = Byte.MIN_VALUE;
        System.out.println("byte 범위: " + minValue + " ~ " + maxValue);
        short minValue1 = Short.MIN_VALUE;
        short maxValue1 = Short.MAX_VALUE;
        System.out.println("short 범위: " + minValue1 + " ~ " + maxValue1);
        int minValue2 = Integer.MIN_VALUE;
        int maxValue2 = Integer.MAX_VALUE;
        System.out.println("short 범위: " + minValue1 + " ~ " + maxValue1);
        System.out.println("int 범위: " + minValue2 + " ~ " + maxValue2);
        // 3. Integer.MIN_VALUE, Integer.MAX_VALUE
        // 4. Long.MIN_VALUE, Long.MAX_VALUE
        long minValue3 = MAX_VALUE;
        long maxValue3 = MIN_VALUE;
        System.out.println("long 범위: " + minValue3 + " ~ " + maxValue3);
    }
}