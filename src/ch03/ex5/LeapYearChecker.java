package ch03.ex5;

import textio.TextIO;

public class LeapYearChecker {
    public static void main(String[] args) {
        System.out.print("년도를 입력하세요: ");
        int year = TextIO.getlnInt();

        boolean isLeapYear = false;
        String reason;

        // TODO: 윤년 판별 로직
        // 힌트: 판별 순서가 중요함 (400 → 100 → 4)
        if(year % 400 == 0){
            isLeapYear = true;
            reason = "400으로 나누어떨어지므로";
        }else if(year % 100 == 0){
            isLeapYear = false;
            reason = "100으로 나누어떨어지므로";
        }else if(year % 4 == 0){
            isLeapYear = true;
            reason = "4로 나누어떨어지므로";
        }else{
            reason = "4로 나누어 떨어지지않으므로";
        }

        // 여기에 코드를 작성하세요
        // 결과 출력
        if (isLeapYear) {
            System.out.println(year + "년은 윤년입니다.");
        } else {
            System.out.println(year + "년은 평년입니다.");
        }
        System.out.println("이유: " + reason);

        // 2월의 일수
        int daysInFebruary = isLeapYear ? 29 : 28;
        System.out.println(year + "년 2월은 " + daysInFebruary + "일입니다.");
    }
}