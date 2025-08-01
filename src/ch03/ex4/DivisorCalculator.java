package ch03.ex4;

import textio.TextIO;

public class DivisorCalculator {
    public static void main(String[] args) {
        System.out.print("양의 정수를 입력하세요: ");
        int N = TextIO.getlnInt();

        // 입력 검증
        while (N <= 0) {
            System.out.print("양의 정수를 입력해주세요: ");
            N = TextIO.getlnInt();
        }

        System.out.println("\n" + N + "의 약수:");
        int divisorCount = 0;

        // TODO: 약수 찾기
        // 힌트:
        // 1. d를 1부터 N까지 반복
        // 2. N % d == 0 이면:
        //    - d 출력 (공백 포함)
        //    - divisorCount 증가

        // 여기에 코드를 작성하세요
        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                System.out.print(i + " ");
                divisorCount++;
            }
        }

        System.out.println("\n\n약수의 개수: " + divisorCount);

        // 소수 판별
        if (divisorCount == 2) {
            System.out.println(N + "은(는) 소수입니다!");
        } else if (divisorCount == 1) {
            System.out.println(N + "은(는) 1입니다.");
        } else {
            System.out.println(N + "은(는) 합성수입니다.");
        }
    }
}