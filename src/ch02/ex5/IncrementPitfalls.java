package ch02.ex5;

public class IncrementPitfalls {
    public static void main(String[] args) {
        System.out.println("=== 증가/감소 연산자 함정 ===");

        // 함정 1: x = x++의 문제
        System.out.println("\n함정 1: x = x++");
        int x = 5;
        System.out.println("초기값: x = " + x);
        x = x++;  // x는 변하지 않음!
        System.out.println("x = x++ 후: x = " + x);  // 여전히 5

        // 올바른 사용
        x = 5;
        x++;  // 또는 x = x + 1;
        System.out.println("x++ 후: x = " + x);  // 6

        // 함정 2: 복잡한 표현식에서 사용
        System.out.println("\n함정 2: 복잡한 표현식");
        int a = 5, b = 5;
        int result1 = a++ * b++;  // 5 * 5 = 25
        System.out.println("a++ * b++ = " + result1);
        System.out.println("연산 후: a = " + a + ", b = " + b);  // 6, 6

        a = 5; b = 5;
        int result2 = ++a * ++b;  // 6 * 6 = 36
        System.out.println("++a * ++b = " + result2);
        System.out.println("연산 후: a = " + a + ", b = " + b);  // 6, 6

        // 함정 3: 같은 변수를 여러 번 수정
        System.out.println("\n함정 3: 혼란스러운 사용 (피해야 함)");
        int i = 1;
        int confusing = i++ + ++i + i++;  // 권장하지 않음!
        System.out.println("결과: " + confusing);
        System.out.println("i = " + i);
    }
}