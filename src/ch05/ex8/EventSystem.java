package ch05.ex8;

import java.util.*;
import java.util.function.Predicate;

public class EventSystem {

    // 이벤트 타입
    public enum EventType {
        CLICK, HOVER, KEY_PRESS, CUSTOM
    }

    // 이벤트 클래스
    public static class Event {
        private EventType type;
        private String source;
        private Object data;
        private long timestamp;

        public Event(EventType type, String source, Object data) {
            // TODO 93
            this.type = type;
            this.source = source;
            this.data = data;
            this.timestamp = System.currentTimeMillis();
        }

        // getters
        public EventType getType() { return type; }
        public String getSource() { return source; }
        public Object getData() { return data; }
        public long getTimestamp() { return timestamp; }
    }

    // 이벤트 핸들러 인터페이스
    public interface EventHandler {
        void handle(Event event);
    }

    private Map<EventType, List<EventHandler>> handlers = new HashMap<>();

    // 이벤트 핸들러 등록
    public void addHandler(EventType type, EventHandler handler) {
        // TODO 94
        handlers.computeIfAbsent(type, k -> new ArrayList<>()).add(handler);
    }

    // 특정 조건의 핸들러 등록 (로컬 클래스 사용)
    public void addConditionalHandler(EventType type,
                                      final Predicate<Event> condition,
                                      final EventHandler handler) {
        // TODO 95
        class ConditionalHandler implements EventHandler {
            @Override
            public void handle(Event event) {
                if (condition.test(event)) {
                    handler.handle(event);
                }
            }
        }
        addHandler(type, new ConditionalHandler());
    }

    // 이벤트 발생
    public void fireEvent(Event event) {
        List<EventHandler> eventHandlers = handlers.get(event.getType());
        if (eventHandlers != null) {
            for (EventHandler handler : eventHandlers) {
                handler.handle(event);
            }
        }
    }

    // 복잡한 핸들러 생성 (로컬 클래스 사용)
    static EventHandler createComplexHandler(final String prefix) {
        class ComplexHandler implements EventHandler {
            private int count = 0;

            @Override
            public void handle(Event event) {
                count++;
                System.out.printf("%s [%d번째]: %s%n", prefix, count, event.getSource());
            }
        }
        return new ComplexHandler();
    }

    public static void main(String[] args) {
        EventSystem system = new EventSystem();

        // 익명 클래스로 핸들러 등록
        system.addHandler(EventType.CLICK, new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("클릭 이벤트: " + event.getSource());
            }
        });

        // 람다로 핸들러 등록
        system.addHandler(EventType.HOVER, event -> {
            System.out.println("호버 이벤트: " + event.getSource());
        });

        // 조건부 핸들러 등록
        system.addConditionalHandler(
                EventType.KEY_PRESS,
                event -> "Enter".equals(event.getData()),
                event -> System.out.println("Enter 키가 눌렸습니다!")
        );

        // 로컬 클래스로 복잡한 핸들러 생성
        system.addHandler(EventType.CUSTOM, createComplexHandler("커스텀 이벤트"));

        // 이벤트 발생 테스트
        system.fireEvent(new Event(EventType.CLICK, "버튼1", null));
        system.fireEvent(new Event(EventType.HOVER, "메뉴", null));
        system.fireEvent(new Event(EventType.KEY_PRESS, "텍스트필드", "A"));
        system.fireEvent(new Event(EventType.KEY_PRESS, "텍스트필드", "Enter"));
        system.fireEvent(new Event(EventType.CUSTOM, "커스텀소스", null));
        system.fireEvent(new Event(EventType.CUSTOM, "커스텀소스2", null));
    }
}
