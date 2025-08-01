package ch03.ex3;

import javax.swing.plaf.IconUIResource;

public class ContinueExample {
    public static void main(String[] args) {
        // TODO: 1부터 20까지 홀수만 출력
        // 힌트:
        // 1. n을 0으로 초기화
        // 2. n < 20 동안 반복
        // 3. n을 증가시킨 후
        // 4. n이 짝수면 continue로 건너뛰기
        // 5. 홀수면 출력
        System.out.println("=== 1부터 20까지 홀수 ===");

        // 여기에 코드를 작성하세요
        int n = 0;
        while (n < 20){
            n++;
            if(n % 2 == 0){
                continue;
            }else{
                System.out.print(n + " ");
            }
        }

        System.out.println();

        // TODO: 1부터 30까지 3의 배수를 제외한 합
        // 힌트:
        // 1. sum = 0, i = 1로 초기화
        int sum = 0, i = 1;
        // 2. i <= 30 동안 반복
        while(i <= 30){
            if (i % 3 == 0){
                i++;
                continue;
            }else{
                System.out.print(i + " ");
                sum += i;
                i++;
            }

        }
        // 3. i가 3의 배수면:
        //    - i를 증가시키고
        //    - continue로 건너뛰기
        // 4. 3의 배수가 아니면 sum에 더하고 i 증가
        System.out.println("\n=== 3의 배수 제외 합계 ===");

        // 여기에 코드를 작성하세요

        System.out.println("1부터 30까지 3의 배수를 제외한 합: " + sum);
    }
}