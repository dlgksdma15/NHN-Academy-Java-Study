package ch03.ex5;

public class EmptyStatementExample {
    public static void main(String[] args) {
        int x = 10;
        boolean ready = true;

        System.out.println("=== 빈 명령문 예제 ===");

        // 의도적인 빈 명령문 사용
        if (ready)
            ;  // 준비되었으면 아무것도 안 함
        else
            System.out.println("아직 준비 안 됨");

        // 더 나은 방법
        if (!ready) {
            System.out.println("아직 준비 안 됨");
        }

        // 실수하기 쉬운 경우 1
        System.out.println("\n실수 예제 1:");
        for (int i = 0; i < 3; i++);  // 세미콜론 때문에 빈 루프
        {
            System.out.println("이 줄은 한 번만 실행됩니다!");
        }

        // 올바른 코드
        System.out.println("\n올바른 코드:");
        for (int i = 0; i < 3; i++) {
            System.out.println("반복 " + (i + 1));
        }

        // 실수하기 쉬운 경우 2
        System.out.println("\n실수 예제 2:");
        if (x > 5);  // 세미콜론 때문에 조건이 무의미
        {
            System.out.println("이 줄은 항상 실행됩니다!");
        }

        // while 루프에서의 의도적 사용
        System.out.println("\n의도적 사용:");
        int count = 0;
        while (++count < 5)
            ;  // 카운트만 증가
        System.out.println("최종 count: " + count);
    }
}