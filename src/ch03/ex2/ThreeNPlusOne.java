package ch03.ex2;

import textio.TextIO;

public class ThreeNPlusOne {
    public static void main(String[] args) {
        int N;           // 현재 숫자
        int counter;     // 단계 수

        // 입력 받기 (양수 검증 포함)
        System.out.print("시작 숫자 입력 (양수): ");
        N = TextIO.getlnInt();

        while (N <= 0) {
            System.out.print("양수를 입력해주세요: ");
            N = TextIO.getlnInt();
        }

        // TODO: 3N+1 수열 계산
        System.out.println("\n3N+1 수열:");
        System.out.print(N);  // 첫 번째 항 출력

        counter = 1;  // 첫 번째 항 포함

        // 힌트:
        // 1. N이 1이 아닌 동안 반복
        // 2. N이 짝수면: N = N / 2
        // 3. N이 홀수면: N = 3 * N + 1
        // 4. 각 단계마다 " -> " + N 출력
        // 5. counter 증가

        // 여기에 코드를 작성하세요
        while (N != 1) {
            if (N % 2 == 0) {
                N = N / 2;
            } else {
                N = 3 * N + 1;
            }
            System.out.print(" -> " + N);
            counter++;
        }


        System.out.println("\n\n수열의 길이: " + counter);
    }
}