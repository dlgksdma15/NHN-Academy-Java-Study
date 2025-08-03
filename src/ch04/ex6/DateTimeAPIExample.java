package ch04.ex6;

// TODO 49: 날짜/시간 관련 import문 추가하기
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeAPIExample {
    public static void main(String[] args) {
        // === 현재 시간 정보 ===
        // TODO 50: 현재 날짜와 시간 가져오기
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("=== 현재 시간 정보 ===");
        System.out.println("오늘 날짜: " + today);
        System.out.println("현재 시간: " + currentTime);
        System.out.println("날짜와 시간: " + currentDateTime);
        System.out.println();

        // === 날짜 계산 ===
        // TODO 51: 날짜 계산하기
        LocalDate birthday = LocalDate.of(2000, 5, 15);
        LocalDate twentyFifthBirthday = birthday.plusYears(25);
        Period untilNextBirthday = Period.between(today, twentyFifthBirthday);

        System.out.println("=== 날짜 계산 ===");
        System.out.println("생일: " + birthday);
        System.out.println("25번째 생일: " + twentyFifthBirthday);
        System.out.println("오늘부터 생일까지: " + untilNextBirthday);
        System.out.println();

        // === 날짜/시간 포맷팅 ===
        // TODO 52: 날짜/시간 포맷팅하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println("=== 포맷팅 ===");
        System.out.println("포맷된 날짜/시간: " + formattedDateTime);
    }
}
