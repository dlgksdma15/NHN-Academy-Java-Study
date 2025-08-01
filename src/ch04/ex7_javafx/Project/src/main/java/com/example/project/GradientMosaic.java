package com.example.project;

import com.example.mosaic.Mosaic;
import javafx.scene.paint.Color;

public class GradientMosaic {

    // 상수
    static final int ROWS = 20;
    static final int COLS = 30;
    static final int SIZE = 20;

    public static void main(String[] args) {
        createGradientDisplay();
    }

    static void createGradientDisplay() {
        // 모자이크 창 열기
        Mosaic.open(ROWS, COLS, SIZE, SIZE);

        // 무한 루프로 그라데이션 패턴 순환
        while (Mosaic.isOpen()) {
            horizontalGradient();
            Mosaic.delay(1000);

            verticalGradient();
            Mosaic.delay(1000);

            diagonalGradient();
            Mosaic.delay(1000);
        }
    }

    // 수평 그라데이션: 왼쪽 → 오른쪽 빨강 → 파랑
    static void horizontalGradient() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                double ratio = (double) col / (COLS - 1);
                Color color = Color.color(1 - ratio, 0, ratio); // 빨강→파랑
                Mosaic.setColor(row, col, color);
            }
        }
    }

    // 수직 그라데이션: 위 → 아래 초록 → 파랑
    static void verticalGradient() {
        for (int row = 0; row < ROWS; row++) {
            double ratio = (double) row / (ROWS - 1);
            for (int col = 0; col < COLS; col++) {
                Color color = Color.color(0, 1 - ratio, ratio); // 초록→파랑
                Mosaic.setColor(row, col, color);
            }
        }
    }

    // 대각선 그라데이션: 좌상단 → 우하단 무지개식 변환
    static void diagonalGradient() {
        int maxSum = ROWS + COLS - 2;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                double ratio = (double) (row + col) / maxSum;
                Color color = Color.color(ratio, 0.5 * (1 - ratio), 1 - ratio);
                Mosaic.setColor(row, col, color);
            }
        }
    }
}
