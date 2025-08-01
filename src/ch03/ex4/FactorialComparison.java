package ch03.ex4;

public class FactorialComparison {
    public static void main(String[] args) {
        int n = 5;

        // while 루프 버전
        int factorial1 = 1;
        int i = 1;
        while (i <= n) {
            factorial1 *= i;
            i++;
        }
        System.out.println("while 루프: " + n + "! = " + factorial1);

        // 여기에 코드를 작성하세요
        int factorial2 = 1;
        for(i = 1; i < n; i++){
            factorial2 = factorial2 * (i + 1); // 5 *
        }
        System.out.println("for 루프: " + n + "! = " + factorial2);

        System.out.printf("계산 과정: 5! = ");
        for(int j = 1; j < 5; j++){
            System.out.print(j + " x ");
        }
        System.out.println("5 = " + factorial2 );
    }
}