package ch03.ex2;

import textio.TextIO;

public class AverageCalculator {
    public static void main(String[] args) {
        // 변수 초기화
        double sum = 0;
        int count = 0;

        System.out.println("=== 평균 계산기 ===");
        System.out.println("숫자를 입력하세요 (0 입력 시 종료):");

        // 입력 및 합계 계산
        while (true) {
            System.out.print("숫자: ");
            double input = TextIO.getlnDouble();  // 사용자 입력 받기

            if (input == 0) {  // 입력이 0이면 반복 종료
                break;
            }

            sum += input;     // 입력값을 합계에 더함
            count++;          // 개수 증가
        }

        // 평균 계산 및 출력
        if (count > 0) {
            double average = sum / count;
            System.out.println("입력한 숫자: " + count + "개");
            System.out.println("합계: " + sum);
            System.out.println("평균: " + average);
        } else {
            System.out.println("입력된 숫자가 없습니다.");
        }
    }
}
