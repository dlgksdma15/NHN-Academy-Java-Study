package ch03.ex5;

public class DanglingElseDemo {
    public static void main(String[] args) {
        int x = 5;
        int y = -3;

        System.out.println("=== 달랑거리는 else 문제 시연 ===");
        System.out.println("x = " + x + ", y = " + y);

        // 문제가 있는 코드 (의도와 다르게 동작)
        System.out.println("\n1. 잘못된 들여쓰기:");
        if (x > 0)
            if (y > 0)
                System.out.println("  둘 다 양수");
            else  // 이 else는 if (y > 0)과 연결됨!
                System.out.println("  x가 음수");  // 실제로는 y가 음수일 때 실행

        // 올바른 코드 1: 중괄호 사용
        System.out.println("\n2. 중괄호로 명확하게:");
        if (x > 0) {
            if (y > 0)
                System.out.println("  둘 다 양수");
        } else {
            System.out.println("  x가 음수 또는 0");
        }

        // 올바른 코드 2: 모든 경우 처리
        System.out.println("\n3. 모든 경우 명시:");
        if (x > 0) {
            if (y > 0) {
                System.out.println("  둘 다 양수");
            } else {
                System.out.println("  x는 양수, y는 음수 또는 0");
            }
        } else {
            System.out.println("  x가 음수 또는 0");
        }
    }
}