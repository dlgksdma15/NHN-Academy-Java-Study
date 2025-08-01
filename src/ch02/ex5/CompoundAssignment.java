package ch02.ex5;

public class CompoundAssignment {
    public static void main(String[] args) {
        System.out.println("=== 복합 할당 연산자 ===");

        // 숫자 연산
        int x = 10;
        System.out.println("초기값: x = " + x);

        x += 5;   // x = x + 5
        System.out.println("x += 5 → x = " + x);    // 15

        x -= 3;   // x = x - 3
        System.out.println("x -= 3 → x = " + x);    // 12

        x *= 2;   // x = x * 2
        System.out.println("x *= 2 → x = " + x);    // 24

        x /= 4;   // x = x / 4
        System.out.println("x /= 4 → x = " + x);    // 6

        x %= 4;   // x = x % 4
        System.out.println("x %= 4 → x = " + x);    // 2

        // 문자열 연결
        System.out.println("\n=== 문자열 연결 ===");
        String message = "Hello";
        System.out.println("초기값: \"" + message + "\"");

        message += " ";
        message += "World";
        message += "!";
        System.out.println("최종값: \"" + message + "\"");

        // 실제 활용 예
        System.out.println("\n=== 실제 활용 예 ===");

        // 누적 합계
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            System.out.println("i = " + i + ", sum = " + sum);
        }

        // 할인 적용
        double price = 100000;
        System.out.println("\n원가: " + price + "원");
        price *= 0.9;  // 10% 할인
        System.out.println("10% 할인 후: " + price + "원");
        price *= 0.95; // 추가 5% 할인
        System.out.println("추가 5% 할인 후: " + price + "원");
    }
}