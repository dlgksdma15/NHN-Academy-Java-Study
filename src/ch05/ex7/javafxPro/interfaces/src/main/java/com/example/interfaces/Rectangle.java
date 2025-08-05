package com.example.interfaces;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 그래픽 객체를 위한 기본 인터페이스들
 */
// 외곽선을 그릴 수 있는 객체
interface Strokeable {
    void stroke(GraphicsContext gc);
    void setStrokeColor(Color color);
    void setStrokeWidth(double width);
}

// 내부를 채울 수 있는 객체
interface Fillable {
    void fill(GraphicsContext gc);
    void setFillColor(Color color);
}

// 변형 가능한 객체
interface Transformable {
    void translate(double dx, double dy);
    void rotate(double angle);
    void scale(double factor);
}

// Line 클래스 - Strokeable만 구현
class Line implements Strokeable {
    private double x1, y1, x2, y2;
    private Color strokeColor = Color.BLACK;
    private double strokeWidth = 1;

    public Line(double x1, double y1, double x2, double y2) {
        // TODO 1: 좌표 초기화하기
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void stroke(GraphicsContext gc) {
        // TODO 2: 선 그리기 구현하기
        gc.setStroke(strokeColor);
        gc.setLineWidth(strokeWidth);
        gc.strokeLine(x1, y1, x2, y2);
    }

    @Override
    public void setStrokeColor(Color color) {
        // TODO 3: 선 색상 설정하기
        this.strokeColor = color;
    }

    @Override
    public void setStrokeWidth(double width) {
        // TODO 4: 선 두께 설정하기
        this.strokeWidth = width;
    }
}

// Rectangle 클래스 - 여러 인터페이스 구현
public class Rectangle implements Strokeable, Fillable, Transformable {
    private double x, y, width, height;
    private Color strokeColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private double strokeWidth = 1;

    public Rectangle(double x, double y, double width, double height) {
        // TODO 5: 사각형 속성 초기화하기
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void stroke(GraphicsContext gc) {
        // TODO 6: 사각형 외곽선 그리기
        gc.setStroke(strokeColor);
        gc.setLineWidth(strokeWidth);
        gc.strokeRect(x, y, width, height);
    }

    @Override
    public void fill(GraphicsContext gc) {
        // TODO 7: 사각형 내부 채우기
        gc.setFill(fillColor);
        gc.fillRect(x, y, width, height);
    }

    @Override
    public void setStrokeColor(Color color) {
        // TODO 8: 외곽선 색상 설정하기
        this.strokeColor = color;
    }

    @Override
    public void setStrokeWidth(double width) {
        // TODO 9: 외곽선 두께 설정하기
        this.strokeWidth = width;
    }

    @Override
    public void setFillColor(Color color) {
        // TODO 10: 채움 색상 설정하기
        this.fillColor = color;
    }

    @Override
    public void translate(double dx, double dy) {
        // TODO 11: 위치 이동하기
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void rotate(double angle) {
        // TODO 12: 회전 구현하기 (간단히 출력만)
        System.out.println("사각형을 " + angle + "도 회전합니다.");
    }

    @Override
    public void scale(double factor) {
        // TODO 13: 크기 조정하기
        this.width *= factor;
        this.height *= factor;
    }
}
