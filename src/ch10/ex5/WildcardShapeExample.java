package ch10.ex5;

import java.util.*;

// 기본 도형 클래스
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract void draw();
    public abstract double getArea();

    @Override
    public String toString() {
        return name;
    }
}

// 구체적인 도형들
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        super("사각형");
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("사각형을 그립니다 (" + width + " x " + height + ")");
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("원");
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("원을 그립니다 (반지름: " + radius + ")");
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    private double base, height;

    public Triangle(double base, double height) {
        super("삼각형");
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("삼각형을 그립니다 (밑변: " + base + ", 높이: " + height + ")");
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class WildcardShapeExample {

    // extends 와일드카드 - 읽기 전용
    public static void drawAllShapes(Collection<? extends Shape> shapes) {
        System.out.println("=== 모든 도형 그리기 ===");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    // extends 와일드카드 - 총 면적 계산
    public static double calculateTotalArea(Collection<? extends Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    // super 와일드카드 - 쓰기 전용
    public static void addShapes(Collection<? super Rectangle> shapes) {
        shapes.add(new Rectangle(5, 3));
        shapes.add(new Rectangle(2, 4));
        // shapes.add(new Circle(3)); // 컴파일 오류!
    }

    // 복사 메서드 - PECS 패턴
    public static <T> void copy(Collection<? extends T> source,
                                Collection<? super T> destination) {
        for (T item : source) {
            destination.add(item);
        }
    }

    // 무제한 와일드카드
    public static void printCollection(Collection<?> collection) {
        System.out.println("컬렉션 내용:");
        for (Object item : collection) {
            System.out.println("  " + item);
        }
    }

    // 도형 필터링 (extends 와일드카드)
    public static List<Shape> filterByMinArea(Collection<? extends Shape> shapes, double minArea) {
        List<Shape> filtered = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.getArea() >= minArea) {
                filtered.add(shape);
            }
        }
        return filtered;
    }

    public static void main(String[] args) {
        // 다양한 도형 컬렉션 생성
        List<Rectangle> rectangles = Arrays.asList(
                new Rectangle(3, 4),
                new Rectangle(5, 2)
        );

        List<Circle> circles = Arrays.asList(
                new Circle(2),
                new Circle(3)
        );

        List<Triangle> triangles = Arrays.asList(
                new Triangle(4, 3),
                new Triangle(6, 5)
        );

        List<Shape> allShapes = new ArrayList<>();
        allShapes.addAll(rectangles);
        allShapes.addAll(circles);
        allShapes.addAll(triangles);

        // extends 와일드카드 테스트
        System.out.println("=== Rectangle 그리기 ===");
        drawAllShapes(rectangles);

        System.out.println("\n=== Circle 그리기 ===");
        drawAllShapes(circles);

        System.out.println("\n=== 모든 도형 그리기 ===");
        drawAllShapes(allShapes);

        // 면적 계산
        System.out.println("\n=== 면적 계산 ===");
        System.out.printf("사각형 총 면적: %.2f\n", calculateTotalArea(rectangles));
        System.out.printf("원 총 면적: %.2f\n", calculateTotalArea(circles));
        System.out.printf("전체 총 면적: %.2f\n", calculateTotalArea(allShapes));

        // super 와일드카드 테스트
        System.out.println("\n=== Super 와일드카드 테스트 ===");
        List<Shape> shapeList = new ArrayList<>();
        List<Rectangle> rectList = new ArrayList<>();

        addShapes(shapeList);  // Rectangle을 Shape 리스트에 추가
        addShapes(rectList);   // Rectangle을 Rectangle 리스트에 추가

        System.out.println("추가된 Shape 리스트:");
        printCollection(shapeList);

        // 복사 테스트 (PECS)
        System.out.println("\n=== 복사 테스트 ===");
        List<Shape> copiedShapes = new ArrayList<>();
        copy(rectangles, copiedShapes);  // Rectangle → Shape
        copy(circles, copiedShapes);     // Circle → Shape

        System.out.println("복사된 도형들:");
        printCollection(copiedShapes);

        // 필터링 테스트
        System.out.println("\n=== 필터링 테스트 ===");
        List<Shape> largeShapes = filterByMinArea(allShapes, 10.0);
        System.out.println("면적 10 이상인 도형들:");
        for (Shape shape : largeShapes) {
            System.out.printf("%s (면적: %.2f)\n", shape, shape.getArea());
        }
    }
}