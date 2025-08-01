package ch03.ex2;

// 의사코드 단계
/*
pseudocode:
원금 입력받기
이자율 입력받기
기간 입력받기

for 각 년도 from 1 to 기간:
    이자 = 원금 * 이자율
    원금 = 원금 + 이자
    결과 출력
*/

// Java 구현
import textio.TextIO;

public class InterestCalculator {
    public static void main(String[] args) {
        double principal;  // 원금
        double rate;       // 이자율
        int years;         // 기간

        // 사용자 입력
        System.out.print("초기 투자 금액: $");
        principal = TextIO.getlnDouble();

        System.out.print("연간 이자율 (%): ");
        double percent = TextIO.getlnDouble();
        rate = percent / 100.0;  // 백분율을 소수로 변환

        System.out.print("투자 기간 (년): ");
        years = TextIO.getlnInt();

        System.out.println("\n년도\t투자 가치");
        System.out.println("----\t----------");

        // TODO: 계산 및 출력
        // 힌트:
        // 1. year 변수를 0으로 초기화
        // 2. while 루프로 year < years 동안 반복
        // 3. 각 반복에서:
        //    - year를 1 증가
        //    - 이자 = 원금 * 이자율
        //    - 원금 = 원금 + 이자
        //    - 결과 출력 (printf 사용)

        // 여기에 코드를 작성하세요
        int year = 0;
        while(year < years){
            year++;
            double plus = principal * rate;
            principal = principal + plus;
            System.out.printf("%d\t %,.2f\n",year,principal);
        }

        System.out.println("\n최종 투자 가치: $" +
                String.format("%,.2f", principal));
    }
}