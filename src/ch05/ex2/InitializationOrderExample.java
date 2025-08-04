package ch05.ex2;

/**
 * 다양한 초기화 방법을 보여주는 클래스
 */
class InitializationExample {
    // TODO 22: 인스턴스 변수 선언 시 초기화하기
    private String name = "기본이름";
    private int count = 0;

    // TODO 23: 인스턴스 초기화 블록 구현하기
    {
        System.out.println("인스턴스 초기화 블록 실행");
        count = 10;
        name = "초기화블록에서설정";
    }

    // TODO 24: static 변수와 static 초기화 블록 구현하기
    // private static String className 선언
    private static String className;
    static {
        System.out.println("static 초기화 블록 실행");
        className = "InitializationExample";
    }

    // TODO 25: 기본 생성자 구현하기
    public InitializationExample() {
        System.out.println("기본 생성자 실행");
        name = "생성자에서설정";
        count = 100;
    }

    // TODO 26: 매개변수 생성자 구현하기
    public InitializationExample(String customName) {
        System.out.println("매개변수 생성자 실행");
        this.name = customName;
        this.count = 200;
    }

    // TODO 27: 정보 출력 메서드 구현하기
    public void displayInfo() {
        // "클래스명: [className]", "이름: [name]", "카운트: [count]" 출력하고 빈 줄
        System.out.println("클래스명: " + className);
        System.out.println("이름: " + name);
    }
}

// TODO 28: 사용 예제 완성하기
public class InitializationOrderExample {
    public static void main(String[] args) {
        // TODO 29: 첫 번째 객체 생성하고 정보 출력하기
        System.out.println("=== 첫 번째 객체 생성 ===");
        // 기본 생성자로 obj1 생성하고 displayInfo() 호출
        InitializationExample obj1 = new InitializationExample();
        obj1.displayInfo();


        // TODO 30: 두 번째 객체 생성하고 정보 출력하기
        System.out.println("=== 두 번째 객체 생성 ===");
        // "커스텀이름"으로 obj2 생성하고 displayInfo() 호출
        InitializationExample obj2 = new InitializationExample("커스텀이름");
        obj2.displayInfo();

    }
}