package ch04.ex3;

public class PrintOverloading {
    public static void main(String[] args) {
        System.out.println("=== print 메서드 오버로딩 ===\n");

        // 29: 다양한 타입 출력 테스트
        print(42);
        print(3.14);
        print("안녕하세요");
        print('A');
        print(true);

        System.out.println();

        // 30: 여러 개 출력 테스트
        print(10, 20);
        print("점수", 95);
        print(1, 2, 3);

        System.out.println();

        // 31: 배열 출력 테스트
        int[] numbers = {5, 10, 15, 20};
        String[] words = {"Hello", "Java", "World"};

        print(numbers);
        print(words);
    }

    // 32: 단일 값 출력 메서드들
    static void print(int value) {
        System.out.println("정수 출력: " + value);
    }

    static void print(double value) {
        System.out.println("실수 출력: " + value);
    }

    static void print(String value) {
        System.out.println("문자열 출력: " + value);
    }

    static void print(char value) {
        System.out.println("문자 출력: " + value);
    }

    static void print(boolean value) {
        System.out.println("불린 출력: " + value);
    }

    // 33: 여러 값 출력 메서드들
    static void print(int a, int b) {
        System.out.printf("두 정수 출력: %d, %d\n", a, b);
    }

    static void print(String text, int number) {
        System.out.printf("문자열 + 정수 출력: %s (%d)\n", text, number);
    }

    static void print(int a, int b, int c) {
        System.out.printf("세 정수 출력: %d, %d, %d\n", a, b, c);
    }

    // 34: 배열 출력 메서드들
    static void print(int[] array) {
        System.out.print("정수 배열 출력: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    static void print(String[] array) {
        System.out.print("문자열 배열 출력: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
