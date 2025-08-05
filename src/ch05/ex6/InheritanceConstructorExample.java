package ch05.ex6;

abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        System.out.println("Shape 생성자 호출");
    }

    public Shape(String color) {
        this(color, false);
    }

    public Shape() {
        this("검정");
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
        System.out.println("Rectangle 생성자 호출");
    }

    public Rectangle(double width, double height, String color) {
        this(width, height, color, false);
    }

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
        System.out.println("Rectangle 생성자 호출");
    }

    @Override
    public String toString() {
        return color + " 사각형 (" + width + " x " + height + ")" + (filled ? " [채움]" : "");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
        System.out.println("Circle 생성자 호출");
    }

    public Circle(double radius) {
        this(radius, "빨강", true);
    }

    @Override
    public String toString() {
        return color + " 원 (반지름: " + radius + ")" + (filled ? " [채움]" : "");
    }
}

// 테스트
public class InheritanceConstructorExample {
    public static void main(String[] args) {
        System.out.println("=== Rectangle 생성 ===");
        Rectangle r1 = new Rectangle(10, 5, "파랑", true);
        System.out.println(r1);

        System.out.println("\n=== Rectangle 생성 (크기만) ===");
        Rectangle r2 = new Rectangle(7, 3);
        System.out.println(r2);

        System.out.println("\n=== Circle 생성 ===");
        Circle c1 = new Circle(5);
        System.out.println(c1);
    }
}
