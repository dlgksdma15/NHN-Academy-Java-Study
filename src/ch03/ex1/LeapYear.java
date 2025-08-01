package ch03.ex1;

public class LeapYear {
    public static void main(String[] args) {
        int[] years = {2020, 2021, 2024, 2100, 2400};

        for (int year : years) {
            boolean isLeapYear;

            // TODO: 윤년 판별 로직
            // 힌트:
            // 1. 400으로 나누어 떨어지면 윤년
            // 2. 100으로 나누어 떨어지면 평년
            // 3. 4로 나누어 떨어지면 윤년
            // 4. 그 외는 평년

            // 여기에 코드를 작성하세요
            isLeapYear = (year % 400 == 0 ) ? true
                    : (year % 100 == 0) ? false
                    : (year % 4 == 0) ? true
                    : false;

            if (isLeapYear) {
                System.out.println(year + "년은 윤년입니다.");
            } else {
                System.out.println(year + "년은 평년입니다.");
            }
        }
    }
}