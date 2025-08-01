package com.example.project;


import com.example.mosaic.Mosaic;
import javafx.scene.paint.Color;

public class MultiWalkerMosaic {

    // 상수
    static final int ROWS = 25;
    static final int COLS = 40;
    static final int SIZE = 15;
    static final int NUM_WALKERS = 3;

    // 워커 상태
    static int[] walkerRows = new int[NUM_WALKERS];
    static int[] walkerCols = new int[NUM_WALKERS];
    static Color[] walkerColors = new Color[NUM_WALKERS];

    public static void main(String[] args) {
        runMultiWalkerAnimation();
    }

    static void runMultiWalkerAnimation() {
        initializeDisplay();
        initializeWalkers();

        while (Mosaic.isOpen()) {
            updateAllWalkers();
            Mosaic.delay(50);
        }
    }

    // 디스플레이 초기화
    static void initializeDisplay() {
        Mosaic.open(ROWS, COLS, SIZE, SIZE);
        Mosaic.setUse3DEffect(false);
        Mosaic.fill(Color.BLACK); // 배경 어둡게
    }

    // 워커 초기화 (랜덤 위치/색상)
    static void initializeWalkers() {
        for (int i = 0; i < NUM_WALKERS; i++) {
            walkerRows[i] = (int) (Math.random() * ROWS);
            walkerCols[i] = (int) (Math.random() * COLS);
            walkerColors[i] = Color.color(Math.random(), Math.random(), Math.random());
        }
    }

    // 모든 워커 업데이트
    static void updateAllWalkers() {
        for (int i = 0; i < NUM_WALKERS; i++) {
            leaveColorTrail(walkerRows[i], walkerCols[i], walkerColors[i]);
            moveWalker(i);
        }
    }

    // 흔적 남기기 (현재 색상 + 새 색상 혼합)
    static void leaveColorTrail(int row, int col, Color color) {
        Color current = Mosaic.getColor(row, col);
        Color mixed = current.interpolate(color, 0.5); // 기존 색과 반반 섞기
        Mosaic.setColor(row, col, mixed);
    }

    // 워커 이동 (랜덤 방향 + wrap-around)
    static void moveWalker(int i) {
        int direction = (int) (Math.random() * 4);

        switch (direction) {
            case 0 -> walkerRows[i]--; // 위
            case 1 -> walkerRows[i]++; // 아래
            case 2 -> walkerCols[i]--; // 왼쪽
            case 3 -> walkerCols[i]++; // 오른쪽
        }

        // wrap-around 처리
        if (walkerRows[i] < 0) walkerRows[i] = ROWS - 1;
        if (walkerRows[i] >= ROWS) walkerRows[i] = 0;
        if (walkerCols[i] < 0) walkerCols[i] = COLS - 1;
        if (walkerCols[i] >= COLS) walkerCols[i] = 0;
    }
}
