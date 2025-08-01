package ch03.ex4;

public class ForLoopIncrements {
    public static void main(String[] args) {
        // 짝수 출력
        System.out.println("0부터 20까지 짝수:");
        for (int i = 0; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 홀수 출력
        System.out.println("\n1부터 20까지 홀수:");
        for (int i = 1; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 5의 배수 출력
        System.out.println("\n5의 배수 (5부터 50까지):");
        for (int i = 5; i <= 50; i += 5) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 제곱수 출력
        System.out.println("\n제곱수:");
        for (int i = 1; i <= 10; i++) {
            System.out.print((i * i) + " ");
        }
        System.out.println();
    }
}
