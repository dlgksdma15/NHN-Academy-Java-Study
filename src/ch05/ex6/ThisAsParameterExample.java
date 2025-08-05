package ch05.ex6;

// 이벤트 리스너 인터페이스
interface ClickListener {
    void onClick(Button source);
}

// 버튼 클래스
class Button {
    private String label;
    private ClickListener listener;

    public Button(String label) {
        this.label = label;
    }

    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        System.out.println(label + " 버튼이 클릭되었습니다.");
        // listener가 null이 아니면 onClick 호출
        if (listener != null) {
            listener.onClick(this); // this 전달
        }
    }

    public String getLabel() {
        return label;
    }
}

// 애플리케이션 클래스
class Application implements ClickListener {
    private Button saveButton;
    private Button cancelButton;

    public Application() {
        // 버튼 생성
        saveButton = new Button("저장");
        cancelButton = new Button("취소");

        // 리스너 등록 (자기 자신 등록)
        saveButton.setClickListener(this);
        cancelButton.setClickListener(this);
    }

    @Override
    public void onClick(Button source) {
        if (source == saveButton) {
            System.out.println("저장 작업을 수행합니다.");
        } else if (source == cancelButton) {
            System.out.println("작업을 취소합니다.");
        }
    }

    public void run() {
        saveButton.click();
        cancelButton.click();
    }
}

// 테스트
public class ThisAsParameterExample {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
