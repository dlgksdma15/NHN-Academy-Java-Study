package ch02.ex3;

public class EnumBasics {
    // 요일 열거형 정의
    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // 사이즈 열거형 정의
    enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }

    public static void main(String[] args) {
        // 열거형 변수 선언하고 값 할당
        DayOfWeek today = DayOfWeek.FRIDAY;
        Size shirtSize = Size.LARGE;

        // 열거형 값 출력
        System.out.println("오늘은 " + today + "입니다.");
        System.out.println("셔츠 사이즈: " + shirtSize);

        // ordinal() 메소드로 순서 출력
        System.out.println("\nordinal 값:");
        System.out.println(today + "의 순서: " + today.ordinal());
        System.out.println(shirtSize + "의 순서: " + shirtSize.ordinal());

        // values() 메소드로 모든 요일 출력
        System.out.println("\n모든 요일:");
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day + " (인덱스: " + day.ordinal() + ")");
        }

    }
}