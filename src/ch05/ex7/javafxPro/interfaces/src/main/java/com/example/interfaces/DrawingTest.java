package com.example.interfaces;

import javafx.scene.paint.Color;

public class DrawingTest {
    public static void main(String[] args) {
        // TODO 14: Line과 Rectangle 객체 생성하기
        Line line = new Line(10, 10, 100, 100);
        Rectangle rectangle = new Rectangle(50, 50, 80, 60);

        // TODO 15: Strokeable 배열로 처리하기
        Strokeable[] shapes = {line, rectangle};
        for (Strokeable shape : shapes) {
            shape.setStrokeColor(Color.RED);
            shape.setStrokeWidth(2);
        }

        // TODO 16: Rectangle을 Fillable로 형변환하여 처리하기
        if (rectangle instanceof Fillable) {
            Fillable fillable = (Fillable) rectangle;
            fillable.setFillColor(Color.BLUE);
        }

        // TODO 17: Rectangle을 Transformable로 형변환하여 처리하기
        if (rectangle instanceof Transformable) {
            Transformable transformable = (Transformable) rectangle;
            transformable.translate(10, 20);
            transformable.scale(1.5);
            transformable.rotate(45);
        }

        // TODO 18: 설정된 값들 출력하기 (그래픽 없이)
        System.out.println("Line 생성 완료");
        System.out.println("Rectangle 생성 및 변형 완료");
    }
}
