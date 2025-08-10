package ch10.ex1;

import java.util.*;

public class WrapperExample {

    /**
     * 리스트의 합계 계산 (오토언박싱 활용)
     */
    public static int calculateSum(List<Integer> numbers) {
        // TODO: 향상된 for 루프를 사용하여 합계 계산
        // 힌트: 오토언박싱이 자동으로 발생
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;

        }
        return sum; // 임시 반환값
    }

    /**
     * null 안전하게 처리하는 메서드
     */
    public static int safeGetValue(Integer nullableInt, int defaultValue) {
        // TODO: nullableInt가 null이면 defaultValue 반환
        if(nullableInt == null){
            return defaultValue;
        }

        return nullableInt; // 임시 반환값
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        int sum = calculateSum(numbers);
        System.out.println("합계: " + sum);

        int value = 42;
        System.out.println("42의 이진수: " + Integer.toBinaryString(value));
        System.out.println("42의 16진수: " + Integer.toHexString(value));

        String strNum = "123";
        int parsedValue = Integer.parseInt(strNum);
        System.out.println("파싱된 값: " + parsedValue);

        Integer nullableInt = null;
        System.out.println("Nullable 값: " + safeGetValue(nullableInt,0));

        Integer a = 127;
        Integer b = 127;
        System.out.println("a == b (127): " + (a == b));

        Integer c = 128;
        Integer d = 128;
        System.out.println("c == d (128): " + (c == d));

        System.out.println("c.equals(d): " + c.equals(d));
        // 실행 결과:
        // 합계: 60
        // 42의 이진수: 101010
        // 42의 16진수: 2a
        // 파싱된 값: 123
        // Nullable 값: 0
        // a == b (127): true
        // c == d (128): false
        // c.equals(d): true
    }
}