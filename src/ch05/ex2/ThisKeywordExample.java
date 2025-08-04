package ch05.ex2;

/**
 * this 키워드의 다양한 사용법을 보여주는 클래스
 */
/**
 * this 키워드의 다양한 사용법을 보여주는 클래스
 */
class Rectangle {
    // TODO 39: private 인스턴스 변수 선언하기
    private double width;
    private double height;
    private String color;

    // TODO 40: this로 인스턴스 변수와 매개변수 구분하는 생성자 구현하기
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.color = "흰색";
    }

    // TODO 41: 색상까지 받는 생성자 구현하기
    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // TODO 42: this()를 사용한 생성자 체이닝 - 기본 생성자
    public Rectangle() {
        this(1.0, 1.0, "흰색");  // 체이닝
    }

    // TODO 43: this()를 사용한 생성자 체이닝 - 정사각형 생성자
    public Rectangle(double size) {
        this(size, size, "흰색");  // 체이닝
    }

    // TODO 44: 메서드 체이닝을 위한 setter 구현하기
    public Rectangle setWidth(double width) {
        this.width = width;
        return this;
    }

    public Rectangle setHeight(double height) {
        this.height = height;
        return this;
    }

    public Rectangle setColor(String color) {
        this.color = color;
        return this;
    }

    // TODO 45: getter 메서드들 구현하기
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public String getColor() { return color; }

    // TODO 46: 넓이 계산 메서드 구현하기
    public double getArea() {
        return width * height;
    }

    // TODO 47: 정보 출력 메서드 구현하기
    public void displayInfo() {
        System.out.printf("사각형 정보: %.1f x %.1f (%s), 넓이: %.1f\n",
                width, height, color, getArea());
    }

    // TODO 48: this를 매개변수로 사용하는 비교 메서드 구현하기
    public boolean isLargerThan(Rectangle other) {
        return this.getArea() > other.getArea();
    }
}

// TODO 49: 사용 예제 완성하기
public class ThisKeywordExample {
    public static void main(String[] args) {
        System.out.println("=== this 키워드 활용 예제 ===");

        // TODO 50: 다양한 생성자로 사각형 생성하기
        Rectangle rect1 = new Rectangle();                  // 기본 생성자
        Rectangle rect2 = new Rectangle(5.0);               // 정사각형
        Rectangle rect3 = new Rectangle(3.0, 4.0);          // 크기 지정
        Rectangle rect4 = new Rectangle(2.0, 6.0, "빨간색"); // 크기+색상 지정

        // TODO 51: 생성된 사각형 정보 출력하기
        System.out.println("\n=== 생성된 사각형들 ===");
        rect1.displayInfo();
        rect2.displayInfo();
        rect3.displayInfo();
        rect4.displayInfo();

        // TODO 52: 메서드 체이닝 사용하기
        System.out.println("\n=== 메서드 체이닝 ===");
        Rectangle rect5 = new Rectangle()
                .setWidth(10.0)
                .setHeight(5.0)
                .setColor("파란색");
        rect5.displayInfo();

        // TODO 53: 크기 비교하기
        System.out.println("\n=== 크기 비교 ===");
        if (rect3.isLargerThan(rect4)) {
            System.out.println("rect3이 rect4보다 큽니다.");
        } else {
            System.out.println("rect4가 rect3보다 크거나 같습니다.");
        }
    }
}
