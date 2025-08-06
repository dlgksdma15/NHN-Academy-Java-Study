package ch07.ex3;

import java.util.ArrayList;

public class WrapperUtilities {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // TODO: 문자열 배열을 숫자로 변환하여 ArrayList에 추가
        String[] strNumbers = {"100", "200", "300"};
        for (String s : strNumbers) {
            // 문자열 -> int 변환 후 추가 (Integer.parseInt 사용)
            numbers.add(Integer.parseInt(s));
        }
        System.out.println("숫자 리스트: " + numbers);

        // TODO: 래퍼 클래스의 상수들을 출력
        System.out.println("최대 int 값: " + Integer.MAX_VALUE);
        System.out.println("최소 int 값: " + Integer.MIN_VALUE);

        // TODO: 진법 변환 수행
        int decimal = 42;
        System.out.println(decimal + "의 2진수: " + Integer.toBinaryString(decimal));
        System.out.println(decimal + "의 16진수: " + Integer.toHexString(decimal));

        // TODO: Double의 특수값들을 포함한 ArrayList 생성
        ArrayList<Double> measurements = new ArrayList<>();
        measurements.add(12.5);
        measurements.add(Double.NaN);         // 숫자가 아님
        measurements.add(Double.POSITIVE_INFINITY); // +무한대
        measurements.add(Double.NEGATIVE_INFINITY); // -무한대
        measurements.add(0.0);

        // TODO: 각 값의 타입 확인 및 출력
        for (Double value : measurements) {
            System.out.print("값: " + value + " -> ");

            if (value.isNaN()) {
                System.out.println("NaN (숫자가 아님)");
            } else if (value.isInfinite()) {
                System.out.println(value > 0 ? "+무한대" : "-무한대");
            } else {
                System.out.println("일반 숫자");
            }
        }
    }
}
