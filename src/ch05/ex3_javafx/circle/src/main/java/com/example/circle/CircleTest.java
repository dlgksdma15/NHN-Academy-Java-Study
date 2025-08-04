package com.example.circle;

import javafx.scene.paint.Color;

public class CircleTest {
    public static void main(String[] args) {
        System.out.println("=== 원 클래스 테스트 ===");

        // 원 1과 원 2 생성
        SimpleCircle circle1 = new SimpleCircle(100, 100, 50, Color.BLUE);
        SimpleCircle circle2 = new SimpleCircle(150, 150, 40, Color.GREEN);

        // 초기 정보 출력
        System.out.printf("원1: 위치(%.1f, %.1f), 반지름 %.1f\n", circle1.getX(), circle1.getY(), circle1.getRadius());
        System.out.printf("원2: 위치(%.1f, %.1f), 반지름 %.1f\n", circle2.getX(), circle2.getY(), circle2.getRadius());
        System.out.println("충돌 여부: " + circle1.collidesWith(circle2));

        // 원1 이동
        circle1.move(10, 10);
        System.out.println("\n원 이동 후:");
        System.out.printf("원1: 위치(%.1f, %.1f)\n", circle1.getX(), circle1.getY());
        System.out.println("충돌 여부: " + circle1.collidesWith(circle2));
    }
}
