package ch03.ex2;

import textio.TextIO;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        System.out.println("=== 소수 판별 프로그램 ===");
        System.out.println("0을 입력하면 종료\n");

        while (true) {
            // 숫자 입력
            System.out.print("검사할 숫자: ");
            int number = TextIO.getlnInt();

            // 종료 조건
            if (number == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 음수 처리
            if (number < 0) {
                System.out.println("양수를 입력해주세요.\n");
                continue;
            }

            // TODO: 소수 판별 알고리즘
            boolean isPrime = true;

            // 힌트:
            // 1. 1 이하의 숫자는 소수가 아님
            // 2. 2부터 시작하여 divisor * divisor <= number 동안:
            //    - number가 divisor로 나누어 떨어지면 소수가 아님
            //    - divisor를 1씩 증가
            // 3. 최적화: 제곱근까지만 검사하면 충분

            // 여기에 코드를 작성하세요
            int divisor = 0;
            if(number <= 1){
                isPrime = false;
            } else{
                for(int i = 2; i < number; i++){
                    if(number % i == 0){
                        isPrime = false;
                        break;
                    }

                }
            }

            // 결과 출력
            if (isPrime) {
                System.out.println(number + "은(는) 소수입니다. ✓");
            } else {
                System.out.println(number + "은(는) 소수가 아닙니다. ✗");

                // 약수 출력
                if (number > 1) {
                    System.out.print("약수: ");
                    int factor = 1;
                    while (factor <= number) {
                        if (number % factor == 0) {
                            System.out.print(factor + " ");
                        }
                        factor = factor + 1;
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}