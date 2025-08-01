package ch03.ex3;

import textio.TextIO;

public class AverageWithPriming {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;

        System.out.println("=== 평균 계산기 ===");
        System.out.println("양수를 입력하세요 (0 입력시 종료):");

        // 루프 준비 - 첫 번째 입력
        System.out.print("숫자: ");
        int number = TextIO.getlnInt();

        // 📌 센티넬 값이 아닐 때까지 반복
        while (number != 0) {
            if (number > 0) {
                sum += number;
                count++;
            } else {
                System.out.println("⚠️  음수는 무시됩니다. 양수만 입력하세요.");
            }

            // 다음 숫자 입력
            System.out.print("숫자: ");
            number = TextIO.getlnInt();
        }

        // 결과 출력
        if (count == 0) {
            System.out.println("\n입력된 데이터가 없습니다!");
        } else {
            double average = (double) sum / count;
            System.out.println("\n=== 결과 ===");
            System.out.println("입력한 숫자: " + count + "개");
            System.out.println("합계: " + sum);
            System.out.printf("평균: %.2f%n", average);
        }
    }
}
