package ch03.ex3;

public class SumCalculator {
    public static void main(String[] args) {
        // 1부터 100까지의 합 계산
        int n = 1;
        int sum = 0;

        while (n <= 100) {
            sum += n;
            n++;
        }

        System.out.println("1부터 100까지의 합: " + sum);  // 출력: 5050

        // 1부터 100까지 짝수의 합 계산
        n = 2;
        sum = 0;

        while (n <= 100) {
            sum += n;
            n += 2;  // 짝수만 증가
        }

        System.out.println("1부터 100까지 짝수의 합: " + sum);  // 출력: 2550
    }
}
