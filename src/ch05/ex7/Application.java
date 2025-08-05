package ch05.ex7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 이벤트 처리를 위한 인터페이스 시스템
 */
// 이벤트 리스너 인터페이스
interface EventListener {
    void onEvent(Event event);
}

// 이벤트 클래스
class Event {
    private String type;
    private Object source;
    private long timestamp;
    private Map<String, Object> data;

    public Event(String type, Object source) {
        // TODO 75: type, source, timestamp 초기화
        this.type = type;
        this.source = source;
        this.timestamp = System.currentTimeMillis();
        this.data = new HashMap<>();
    }

    // getter 메서드들
    public String getType() { return type; }
    public Object getSource() { return source; }
    public long getTimestamp() { return timestamp; }

    public void setData(String key, Object value) {
        // TODO 76
        data.put(key, value);
    }

    public Object getData(String key) {
        // TODO 77
        return data.get(key);
    }
}

// 특정 이벤트 리스너들
interface ClickListener extends EventListener {
    @Override
    default void onEvent(Event event) {
        if ("click".equals(event.getType())) {
            onClick(event);
        }
    }

    void onClick(Event event);
}

// 이벤트 발생자 인터페이스
interface EventEmitter {
    void addEventListener(String eventType, EventListener listener);
    void removeEventListener(String eventType, EventListener listener);
    void emit(Event event);
}

// 버튼 클래스 - 이벤트 발생자
class Button implements EventEmitter {
    private String text;
    private Map<String, List<EventListener>> listeners;

    public Button(String text) {
        // TODO 78
        this.text = text;
        this.listeners = new HashMap<>();
    }

    @Override
    public void addEventListener(String eventType, EventListener listener) {
        // TODO 79
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    @Override
    public void removeEventListener(String eventType, EventListener listener) {
        // TODO 80
        List<EventListener> list = listeners.get(eventType);
        if (list != null) {
            list.remove(listener);
        }
    }

    @Override
    public void emit(Event event) {
        // TODO 81
        List<EventListener> list = listeners.get(event.getType());
        if (list != null) {
            for (EventListener listener : list) {
                listener.onEvent(event);
            }
        }
    }

    // 버튼 클릭 시뮬레이션
    public void click() {
        // TODO 82
        Event event = new Event("click", this);
        event.setData("button", text);
        emit(event);
    }

    public String getText() {
        return text;
    }
}

// 애플리케이션 - 이벤트 처리
public class Application {
    private Button saveButton;
    private Button cancelButton;

    public Application() {
        // TODO 83
        saveButton = new Button("저장");
        cancelButton = new Button("취소");

        // TODO 84: 저장 버튼 클릭 리스너 등록 (익명 클래스)
        saveButton.addEventListener("click", new ClickListener() {
            @Override
            public void onClick(Event event) {
                System.out.println("저장 버튼 클릭!");
                save();
            }
        });

        // TODO 85: 취소 버튼 클릭 리스너 등록 (람다 표현식)
        cancelButton.addEventListener("click", (event) -> {
            System.out.println("취소 버튼 클릭!");
            cancel();
        });
    }

    private void save() {
        System.out.println("데이터를 저장합니다...");
    }

    private void cancel() {
        System.out.println("작업을 취소합니다...");
    }

    public void run() {
        // TODO 86
        saveButton.click();
        cancelButton.click();
    }

    public static void main(String[] args) {
        // TODO 87
        Application application = new Application();
        application.run();
    }
}
