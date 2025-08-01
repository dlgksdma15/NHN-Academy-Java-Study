package ch03.ex1;

public class AvoidCompileError {
    public static void main(String[] args) {
        int value = 7;

        // 방법 1: 초기값 설정
        int result1 = 0;  // 기본값 설정
        if (value > 5) {
            result1 = value * 2;
        }
        System.out.println("result1 = " + result1);

        // 방법 2: else 사용
        int result2;
        if (value > 5) {
            result2 = value * 2;
        } else {
            result2 = value;
        }
        System.out.println("result2 = " + result2);

        // 방법 3: 최종 변수 사용
        final int result3;
        if (value > 5) {
            result3 = value * 2;
        } else {
            result3 = value;
        }
        System.out.println("result3 = " + result3);
    }
}