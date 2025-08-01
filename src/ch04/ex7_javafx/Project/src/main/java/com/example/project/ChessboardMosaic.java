package com.example.project;

import com.example.mosaic.Mosaic;
import javafx.scene.paint.Color;

public class ChessboardMosaic {
    // 상수 선언
    static final int ROWS = 8;
    static final int COLS = 8;
    static final int SQUARE_SIZE = 50;

    public static void main(String[] args) {
        drawChessboard();
    }

    static void drawChessboard() {
        // 1. 모자이크 창 열기
        Mosaic.open(ROWS, COLS, SQUARE_SIZE, SQUARE_SIZE);

        // 2. 체스판 패턴 채우기
        fillChessboardPattern();

        // 3. 프로그램 유지 (창 닫을 때까지 대기)
        while (Mosaic.isOpen()) {
            Mosaic.delay(100);
        }
    }

    static void fillChessboardPattern() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // (row + col) % 2 → 0일 때 흰색, 1일 때 검정색
                if ((row + col) % 2 == 0) {
                    Mosaic.setColor(row, col, Color.WHITE);
                } else {
                    Mosaic.setColor(row, col, Color.BLACK);
                }
            }
        }
    }
}
