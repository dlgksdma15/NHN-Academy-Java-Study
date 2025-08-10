package ch10.ex2;

import java.util.*;
import java.time.LocalTime;

public class TaskScheduler {

    static class Task {
        String name;
        int priority;  // 낮을수록 우선순위 높음
        LocalTime deadline;

        Task(String name, int priority, LocalTime deadline) {
            this.name = name;
            this.priority = priority;
            this.deadline = deadline;
        }

        @Override
        public String toString() {
            return String.format("%s (우선순위: %d, 마감: %s)",
                    name, priority, deadline);
        }
    }

    public static void main(String[] args) {
        // 우선순위 기반 스케줄러
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> {
            // 우선순위가 같으면 마감시간 순
            if (t1.priority != t2.priority) {
                return Integer.compare(t1.priority, t2.priority);
            }
            return t1.deadline.compareTo(t2.deadline);
        });

        // 작업 추가
        taskQueue.offer(new Task("버그 수정", 1, LocalTime.of(14, 0)));
        taskQueue.offer(new Task("기능 구현", 3, LocalTime.of(17, 0)));
        taskQueue.offer(new Task("문서 작성", 2, LocalTime.of(16, 0)));
        taskQueue.offer(new Task("코드 리뷰", 2, LocalTime.of(15, 0)));
        taskQueue.offer(new Task("회의 준비", 1, LocalTime.of(13, 0)));

        System.out.println("=== 작업 처리 순서 ===");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("처리: " + task);
        }

        // 이벤트 처리 시뮬레이션
        System.out.println("\n=== 이벤트 처리 시뮬레이션 ===");

        class Event implements Comparable<Event> {
            int time;
            String description;

            Event(int time, String description) {
                this.time = time;
                this.description = description;
            }

            @Override
            public int compareTo(Event other) {
                return Integer.compare(this.time, other.time);
            }

            @Override
            public String toString() {
                return String.format("시간 %d: %s", time, description);
            }
        }

        PriorityQueue<Event> eventQueue = new PriorityQueue<>();
        eventQueue.offer(new Event(5, "사용자 로그인"));
        eventQueue.offer(new Event(2, "서버 시작"));
        eventQueue.offer(new Event(8, "데이터 백업"));
        eventQueue.offer(new Event(3, "캐시 초기화"));
        eventQueue.offer(new Event(7, "로그 파일 생성"));

        int currentTime = 0;
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            currentTime = event.time;
            System.out.println(event);
        }
    }
}