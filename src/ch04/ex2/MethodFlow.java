package ch04.ex2;

public class MethodFlow {
    public static void main(String[] args) {
        System.out.println("=== 메서드 호출 흐름 ===\n");
        System.out.println("1. main 시작");

        // TODO 11: methodA 호출하기
        methodA();

        System.out.println("6. main 종료");
    }

    // TODO 12: methodA 구현하기
    public static void methodA() {
        System.out.println("2. methodA 시작");
        methodB();
        System.out.println("5. methodA 종료");
    }

    // TODO 13: methodB 구현하기
    public static void methodB() {
        System.out.println("3. methodB 시작");
        methodC();
        System.out.println("4. methodB 종료");
    }

    // TODO 14: methodC 구현하기
    public static void methodC() {
        System.out.println("3.5. methodC 실행");
    }
}