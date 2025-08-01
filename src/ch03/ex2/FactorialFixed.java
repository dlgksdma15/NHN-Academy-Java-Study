package ch03.ex2;

public class FactorialFixed {
    public static void main(String[] args) {
        int n = 5;
        int factorial = 1;  // 수정: 1로 초기화
        int i = 1;

        System.out.println(n + "! 계산 과정:");
        System.out.print(n + "! = ");

        while (i <= n) {
            factorial = factorial * i;

            // 계산 과정 출력
            System.out.print(i);
            if (i < n) {
                System.out.print(" × ");
            }

            i = i + 1;
        }

        System.out.println(" = " + factorial);
    }
}