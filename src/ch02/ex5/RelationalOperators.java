package ch02.ex5;

public class RelationalOperators {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 10;

        System.out.println("=== 관계 연산자 ===");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);

        // 동등 비교
        System.out.println("\n동등 비교:");
        System.out.println("a == b: " + (a == b));  // false
        System.out.println("a == c: " + (a == c));  // true
        System.out.println("a != b: " + (a != b));  // true
        System.out.println("a != c: " + (a != c));  // false

        // 크기 비교
        System.out.println("\n크기 비교:");
        System.out.println("a < b: " + (a < b));    // true
        System.out.println("a > b: " + (a > b));    // false
        System.out.println("a <= b: " + (a <= b));  // true
        System.out.println("a >= b: " + (a >= b));  // false
        System.out.println("a <= c: " + (a <= c));  // true
        System.out.println("a >= c: " + (a >= c));  // true

        // 문자 비교
        System.out.println("\n문자 비교:");
        char ch1 = 'A';
        char ch2 = 'B';
        char ch3 = 'a';

        System.out.println("'A' < 'B': " + (ch1 < ch2));   // true
        System.out.println("'A' < 'a': " + (ch1 < ch3));   // true (대문자가 먼저)
        System.out.println("'A'의 값: " + (int)ch1);       // 65
        System.out.println("'a'의 값: " + (int)ch3);       // 97
    }
}