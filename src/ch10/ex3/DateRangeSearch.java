package ch10.ex3;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateRangeSearch {

    static class Event {
        String title;
        LocalDateTime dateTime;

        Event(String title, LocalDateTime dateTime) {
            this.title = title;
            this.dateTime = dateTime;
        }

        @Override
        public String toString() {
            return title + " (" +
                    dateTime.format(DateTimeFormatter.ofPattern("MM/dd HH:mm")) + ")";
        }
    }

    public static void main(String[] args) {
        TreeMap<LocalDateTime, Event> calendar = new TreeMap<>();

        // 2024년 1월 이벤트 추가
        LocalDateTime base = LocalDateTime.of(2024, 1, 1, 0, 0);

        calendar.put(base.plusDays(0).plusHours(9),
                new Event("새해 인사", base.plusDays(0).plusHours(9)));
        calendar.put(base.plusDays(2).plusHours(14),
                new Event("프로젝트 회의", base.plusDays(2).plusHours(14)));
        calendar.put(base.plusDays(5).plusHours(10),
                new Event("팀 미팅", base.plusDays(5).plusHours(10)));
        calendar.put(base.plusDays(7).plusHours(15),
                new Event("고객 미팅", base.plusDays(7).plusHours(15)));
        calendar.put(base.plusDays(10).plusHours(11),
                new Event("코드 리뷰", base.plusDays(10).plusHours(11)));
        calendar.put(base.plusDays(15).plusHours(13),
                new Event("점심 약속", base.plusDays(15).plusHours(13)));

        // 전체 일정
        System.out.println("=== 전체 일정 ===");
        for (Map.Entry<LocalDateTime, Event> entry : calendar.entrySet()) {
            System.out.println(entry.getValue());
        }

        // 첫 주 일정 (1월 1일 ~ 1월 7일)
        LocalDateTime weekStart = base;
        LocalDateTime weekEnd = base.plusDays(7);

        System.out.println("\n=== 첫 주 일정 ===");
        SortedMap<LocalDateTime, Event> firstWeek =
                calendar.subMap(weekStart, weekEnd);
        for (Event event : firstWeek.values()) {
            System.out.println(event);
        }

        // 특정 날짜의 일정
        LocalDateTime dayStart = base.plusDays(7);
        LocalDateTime dayEnd = dayStart.plusDays(1);

        System.out.println("\n=== 1월 8일 일정 ===");
        SortedMap<LocalDateTime, Event> dayEvents =
                calendar.subMap(dayStart, dayEnd);
        if (dayEvents.isEmpty()) {
            System.out.println("일정 없음");
        } else {
            for (Event event : dayEvents.values()) {
                System.out.println(event);
            }
        }

        // 다음 일정 찾기
        LocalDateTime now = base.plusDays(3);
        System.out.println("\n=== 1월 4일 이후 일정 ===");
        SortedMap<LocalDateTime, Event> upcoming = calendar.tailMap(now);

//        if (!upcoming.isEmpty()) {
//            Map.Entry<LocalDateTime, Event> next = upcoming.firstEntry();
//            System.out.println("다음 일정: " + next.getValue());
//        }
    }
}