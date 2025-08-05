package ch05.ex6;

/**
 * GUI 컴포넌트 시스템 구현
 */
// 기본 컴포넌트 클래스
abstract class Component {
    protected int x, y;
    protected int width, height;
    protected boolean visible;
    protected Component parent;

    public Component(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = true;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }

    public void show() {
        this.visible = true;
        redraw();
    }

    public void hide() {
        this.visible = false;
        if (parent != null) {
            parent.redraw();  // 부모에게 다시 그리기 요청
        }
    }

    public abstract void draw();

    public void redraw() {
        if (visible) {
            draw();
        }
    }
}

// 컨테이너 클래스
class Container extends Component {
    protected Component[] children;
    protected int childCount;

    public Container(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.children = new Component[10];
        this.childCount = 0;
    }

    public void add(Component child) {
        // 자식 컴포넌트 추가
        if (childCount < children.length) {
            children[childCount++] = child;
            child.setParent(this);
        }
    }

    @Override
    public void draw() {
        System.out.println("Container 그리기 at (" + x + ", " + y + ")");
        // 모든 자식 컴포넌트 그리기
        for (int i = 0; i < childCount; i++) {
            children[i].redraw();
        }
    }

    @Override
    public void redraw() {
        super.redraw();
        // 부모에게 다시 그리기 요청 제거
        // if (parent != null) {
        //     parent.redraw();
        // }
    }

}

// 버튼 클래스
class SimpleButton extends Component {
    private String text;

    public SimpleButton(int x, int y, int width, int height, String text) {
        super(x, y, width, height);
        this.text = text;
    }

    public SimpleButton(int x, int y, String text) {
        // 기본 크기 100x30
        this(x, y, 100, 30, text);
    }

    @Override
    public void draw() {
        System.out.println("Button [" + text + "] at (" + x + ", " + y + ")");
    }

    public void click() {
        System.out.println(text + " 버튼이 클릭되었습니다.");
        highlight();
    }

    private void highlight() {
        System.out.println(text + " 버튼 하이라이트");
        redraw();
    }
}

// 텍스트 필드 클래스
class TextField extends Component {
    private String value;
    private String placeholder;

    public TextField(int x, int y, int width, String placeholder) {
        super(x, y, width, 25);  // 높이는 고정
        this.placeholder = placeholder;
        this.value = "";
    }

    public void setText(String value) {
        this.value = value;
        redraw();
    }

    @Override
    public void draw() {
        String display = value.isEmpty() ? placeholder : value;
        System.out.println("TextField [" + display + "] at (" + x + ", " + y + ")");
    }
}

// 테스트
public class GUISystemExample {
    public static void main(String[] args) {
        // GUI 컴포넌트 계층 구조 만들기
        Container mainPanel = new Container(0, 0, 800, 600);
        Container loginForm = new Container(100, 100, 300, 200);

        TextField idField = new TextField(10, 10, 200, "아이디 입력");
        TextField pwField = new TextField(10, 50, 200, "비밀번호 입력");
        SimpleButton loginBtn = new SimpleButton(10, 100, "로그인");
        SimpleButton cancelBtn = new SimpleButton(120, 100, "취소");

        // 계층 구조 구성
        loginForm.add(idField);
        loginForm.add(pwField);
        loginForm.add(loginBtn);
        loginForm.add(cancelBtn);

        mainPanel.add(loginForm);

        // 초기 화면 출력
        System.out.println("=== 초기 화면 ===");
        mainPanel.redraw();

        // 사용자 입력 시뮬레이션
        System.out.println("\n=== 아이디 입력 ===");
        idField.setText("user123");

        System.out.println("\n=== 로그인 버튼 클릭 ===");
        loginBtn.click();
    }
}
