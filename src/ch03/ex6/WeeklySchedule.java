package ch03.ex6;

enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class WeeklySchedule {
    public static void main(String[] args) {
        DayOfWeek today = DayOfWeek.FRIDAY;

        System.out.println("오늘은 " + getDayNameInKorean(today) + "입니다.");

        // TODO: 요일별 활동 추천 switch문
        // 힌트: switch-case 사용

        // 여기에 코드를 작성하세요
        getDayActive(today);



        // TODO: 업무일/휴일 구분
        // 힌트: switch 표현식
        boolean isWorkday = switch (today){
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
            case SATURDAY, SUNDAY -> false;
        };

        System.out.println(isWorkday ? "평일입니다." : "주말입니다.");
    }

    private static void getDayActive(DayOfWeek today) {
        System.out.println("=== 활동 추천 ===");
        switch (today){
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
                -> System.out.println("평일에는 힘을 내야합니다\n버텨!!");
            case SATURDAY, SUNDAY
                -> System.out.println("펑펑 놀아요 주말이니까!!!");
        }
    }

    public static String getDayNameInKorean(DayOfWeek day) {
        // TODO: switch 표현식으로 한국어 요일 명 반환
        // 힌트: -> 연산자
        String resultday = switch (day){
            case MONDAY -> "월요일";
            case TUESDAY -> "화요일";
            case WEDNESDAY ->"수요일";
            case THURSDAY -> "목요일";
            case FRIDAY -> "금요일";
            case SATURDAY -> "토요일";
            case SUNDAY ->"일요일";
        };
        return resultday;
    }
}