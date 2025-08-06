package ch07.ex1;

public class ArrayLiteralMethods {
    public static String getDayName(int dayNumber) {
        String[] days = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
        if (dayNumber >= 0 && dayNumber < days.length) {
            return days[dayNumber];
        } else {
            return "잘못된 요일";
        }
    }

    public static int getDaysInMonth(int month, boolean isLeapYear) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear) {
            return 29;
        } else if (month >= 1 && month <= 12) {
            return daysInMonth[month];
        } else {
            return 0; // Invalid month
        }
    }

    public static char getGrade(int score) {
        int[] boundaries = {90, 80, 70, 60, 0};
        char[] grades = {'A', 'B', 'C', 'D', 'F'};
        for (int i = 0; i < boundaries.length; i++) {
            if (score >= boundaries[i]) {
                return grades[i];
            }
        }
        return 'F'; // Should not reach here if score is non-negative
    }

    public static void showMenu() {
        printMenu("메인 메뉴", new String[]{"1. 게임 시작", "2. 설정", "3. 도움말", "4. 종료"});
    }


    private static void printMenu(String title, String[] items) {
        System.out.println("=== " + title + " ===");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("================");
    }

    public static void main(String[] args) {
        // getDayName 테스트
        System.out.println("오늘은 " + getDayName(3));  // 수요일

        // getDaysInMonth 테스트
        System.out.println("\n2024년 2월: " +
                getDaysInMonth(2, true) + "일");  // 29일

        // getGrade 테스트
        int[] scores = {95, 82, 73, 65, 58};
        System.out.println("\n성적 평가:");
        for (int score : scores) {
            System.out.println(score + "점: " + getGrade(score) + "등급");
        }

        // showMenu 테스트
        System.out.println();
        showMenu();
    }
}