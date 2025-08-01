package ch03.ex2;

public class DebuggingExample {
    public static void main(String[] args) {
        // 팩토리얼 계산 (오류가 있는 코드)
        int n = 5;
        int factorial = 0;  // 오류: 0으로 초기화
        int i = 1;

        System.out.println("DEBUG: 초기값 - n=" + n + ", factorial=" + factorial);

        while (i <= n) {
            System.out.println("DEBUG: 루프 시작 - i=" + i + ", factorial=" + factorial);

            factorial = factorial * i;  // 오류: 0 * i는 항상 0
            i = i + 1;

            System.out.println("DEBUG: 루프 끝 - i=" + i + ", factorial=" + factorial);
        }

        System.out.println("\n" + n + "! = " + factorial);
        System.out.println("(예상값: 120)");
    }
}