package com.example.circle;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * 간단한 원 클래스
 */
public class SimpleCircle {
    private double x, y;
    private double radius;
    private Color color;

    // 생성자
    public SimpleCircle(double x, double y, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    // 원 그리기
    public void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    // 원 이동
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // 충돌 감지
    public boolean collidesWith(SimpleCircle other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        return distance < (this.radius + other.radius);
    }

    // Getter & Setter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
