package ch02.ex5;

public class OperatorPrecedence {
    public static void main(String[] args) {
        System.out.println("=== 연산자 우선순위 ===");

        // 산술 연산자 우선순위
        int result1 = 2 + 3 * 4;        // 2 + 12 = 14
        int result2 = (2 + 3) * 4;      // 5 * 4 = 20
        int result3 = 10 / 2 * 3;       // 5 * 3 = 15 (왼쪽에서 오른쪽)
        int result4 = 10 / (2 * 3);     // 10 / 6 = 1

        System.out.println("2 + 3 * 4 = " + result1);
        System.out.println("(2 + 3) * 4 = " + result2);
        System.out.println("10 / 2 * 3 = " + result3);
        System.out.println("10 / (2 * 3) = " + result4);

        // 관계 연산자와 논리 연산자
        int x = 5, y = 3, z = 7;
        boolean test1 = x > y && y < z;     // true && true = true
        boolean test2 = x > y || y > z;     // true || false = true
        boolean test3 = x + y > z;          // 8 > 7 = true
        boolean test4 = x > y + z;          // 5 > 10 = false

        System.out.println("\nx = " + x + ", y = " + y + ", z = " + z);
        System.out.println("x > y && y < z = " + test1);
        System.out.println("x > y || y > z = " + test2);
        System.out.println("x + y > z = " + test3);
        System.out.println("x > y + z = " + test4);

        // 복잡한 예제
        int a = 5, b = 3, c = 2;
        int complex = a + b * c - a % b;  // 5 + 6 - 2 = 9
        System.out.println("\na = " + a + ", b = " + b + ", c = " + c);
        System.out.println("a + b * c - a % b = " + complex);
        System.out.println("계산 순서: " + a + " + (" + b + " * " + c +
                ") - (" + a + " % " + b + ")");
        System.out.println("= " + a + " + " + (b * c) + " - " + (a % b));
        System.out.println("= " + a + " + 6 - 2 = " + complex);
    }
}