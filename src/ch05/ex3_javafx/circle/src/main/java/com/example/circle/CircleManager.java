package com.example.circle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleManager {
    private SimpleCircle[] circles;
    private int circleCount;

    // 생성자
    public CircleManager(int maxCircles) {
        circles = new SimpleCircle[maxCircles];
        circleCount = 0;
    }

    // 원 추가
    public void addCircle(SimpleCircle circle) {
        if (circleCount < circles.length) {
            circles[circleCount++] = circle;
        }
    }

    // 모든 원 그리기
    public void drawAll(GraphicsContext g) {
        for (int i = 0; i < circleCount; i++) {
            circles[i].draw(g);
        }
    }

    // 충돌 체크
    public void checkCollisions() {
        for (int i = 0; i < circleCount; i++) {
            for (int j = i + 1; j < circleCount; j++) {
                if (circles[i].collidesWith(circles[j])) {
                    circles[i].setColor(Color.RED);
                    circles[j].setColor(Color.RED);
                }
            }
        }
    }
}
