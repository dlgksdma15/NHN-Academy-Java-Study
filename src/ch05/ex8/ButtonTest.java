package ch05.ex8;

import java.util.ArrayList;
import java.util.List;

/**
 * 간단한 GUI 버튼 클래스
 */
class CustomButton {
    private String text;
    private boolean enabled = true;
    private List<ClickListener> listeners;

    public CustomButton(String text) {
        // TODO 50
        this.text = text;
        this.listeners = new ArrayList<>();
    }

    // 클릭 이벤트를 처리하는 내부 클래스
    public class ClickEvent {
        private long timestamp;
        private int x, y;  // 클릭 좌표

        public ClickEvent(int x, int y) {
            // TODO 51
            this.timestamp = System.currentTimeMillis();
            this.x = x;
            this.y = y;
        }

        public String getButtonText() {
            // TODO 52
            return CustomButton.this.text;
        }

        public boolean isButtonEnabled() {
            // TODO 53
            return CustomButton.this.enabled;
        }

        @Override
        public String toString() {
            // TODO 54
            return "ClickEvent[button=" + text + ", pos=(" + x + "," + y + "), time=" + timestamp + "]";
        }
    }

    // 클릭 리스너 인터페이스
    public interface ClickListener {
        void onClick(ClickEvent event);
    }

    public void addClickListener(ClickListener listener) {
        // TODO 55
        listeners.add(listener);
    }

    // 버튼 클릭 시뮬레이션
    public void click(int x, int y) {
        // TODO 56
        if (!enabled) {
            System.out.println("버튼이 비활성화되어 있습니다.");
            return;
        }
        ClickEvent event = new ClickEvent(x, y);
        for (ClickListener listener : listeners) {
            listener.onClick(event);
        }
    }

    public void setEnabled(boolean enabled) {
        // TODO 57
        this.enabled = enabled;
    }

    public String getText() {
        // TODO 58
        return text;
    }
}

// 테스트
public class ButtonTest {
    public static void main(String[] args) {
        // TODO 59
        CustomButton button = new CustomButton("확인");

        // TODO 60: 익명 클래스 리스너
        button.addClickListener(new CustomButton.ClickListener() {
            @Override
            public void onClick(CustomButton.ClickEvent event) {
                System.out.println("버튼 클릭됨: " + event);
            }
        });

        // TODO 61: 람다 리스너
        button.addClickListener(event -> {
            System.out.println("람다 리스너: " + event.getButtonText() + " 클릭!");
        });

        // TODO 62: 버튼 클릭
        button.click(100, 50);

        // TODO 63: 비활성화 후 다시 클릭
        button.setEnabled(false);
        button.click(200, 100);
    }
}
