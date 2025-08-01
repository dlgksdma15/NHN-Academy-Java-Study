package ch03.ex1;

import textio.TextIO;

public class SumAndAverage {
    public static void main(String[] args) {
        double sum = 0;
        int count = 0;
        double number;

        System.out.println("숫자를 입력하세요 (0 입력시 종료):");

        // TODO: 합계와 평균 계산 루프
        // 힌트:
        // 1. while(true) 무한 루프
        // 2. 숫자 입력받기
        // 3. 0이면 break로 루프 종료
        // 4. sum에 더하고 count 증가

        // 여기에 코드를 작성하세요
        while(true){
            number = TextIO.getlnDouble();
            if(number == 0){ break; }
            sum += number;
            count++;
        }

        if (count > 0) {
            double average = sum / count;
            System.out.println("\n입력한 숫자: " + count + "개");
            System.out.println("합계: " + sum);
            System.out.println("평균: " + average);
        } else {
            System.out.println("입력된 숫자가 없습니다.");
        }
    }
}