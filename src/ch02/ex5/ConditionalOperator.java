package ch02.ex5;

public class ConditionalOperator {
    public static void main(String[] args) {
        System.out.println("=== 조건 연산자 (? :) ===");

        int a = 10, b = 20;
        System.out.println("a = " + a + ", b = " + b);

        // 최댓값, 최솟값 구하기
        int max = (a > b) ? a : b;
        int min = (a < b) ? a : b;
        System.out.println("최댓값: " + max);
        System.out.println("최솟값: " + min);

        // 절댓값 구하기
        int number = -15;
        int abs = (number >= 0) ? number : -number;
        System.out.println("\n" + number + "의 절댓값: " + abs);

        // 1부터 5까지 짝수/홀수 판별
        System.out.println("\n짝수/홀수 판별:");
        for (int i = 1; i <= 5; i++) {
            String result = (i % 2 == 0) ? "짝수" : "홀수";
            System.out.println(i + "는 " + result);
        }

        // 점수에 따른 등급 계산 (중첩 조건 연산자)
        int score = 85;
        String grade = (score >= 90) ? "A" :
                (score >= 80) ? "B" :
                        (score >= 70) ? "C" :
                                (score >= 60) ? "D" : "F";
        System.out.println("\n점수 " + score + "의 등급: " + grade);
    }
}
