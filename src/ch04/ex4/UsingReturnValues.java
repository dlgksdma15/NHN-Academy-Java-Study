package ch04.ex4;

public class UsingReturnValues {
    public static void main(String[] args) {
        System.out.println("=== 반환값 활용 예제 ===\n");

        // 11: 변수에 저장하여 사용
        int result = add(10, 20);
        System.out.println("저장된 결과: " + result);

        // 12: 직접 출력
        System.out.println("직접 출력: " + add(30, 40));

        // 13: 표현식에서 사용
        int total = 100 + add(50, 60);
        System.out.println("표현식 결과: " + total);

        // 14: 조건문에서 사용
        if (add(25, 25) > 40) {
            System.out.println("25 + 25는 40보다 큽니다.");
        }

        // 15: 다른 함수의 인자로 사용
        int doubled = multiply(add(5, 7), 2);
        System.out.println("(5 + 7) × 2 = " + doubled);

        // 16: 반복문에서 사용
        System.out.print("카운트다운: ");
        for (int i = countdown(5); i > 0; i = countdown(i)) {
            System.out.print(i + " ");
        }
        System.out.println("발사!");
    }

    // 17: 덧셈 메서드
    static int add(int a, int b) {
        return a + b;
    }

    // 18: 곱셈 메서드
    static int multiply(int a, int b) {
        return a * b;
    }

    // 19: 카운트다운 메서드 (1 감소)
    static int countdown(int n) {
        return n - 1;
    }
}
