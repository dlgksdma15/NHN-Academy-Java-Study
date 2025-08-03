package ch04.ex6;

// TODO 28: MathUtils 정적 import하기

import static ch04.ex6.MathUtils.*;

public class CustomStaticImport {
    public static void main(String[] args) {
        // TODO 29: MathUtils. 없이 사용하기
        System.out.println("황금비: " + GOLDEN_RATIO);
        System.out.println("평균(1,2,3,4,5): " + average(1, 2, 3, 4, 5));
        System.out.println("5! = " + factorial(5));

        // TODO 30: 1-20 사이의 소수 출력하기
        System.out.println("\n1-20 사이의 소수:");
        for (int i = 1; i <= 20; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
