package ch07.ex6;

import java.util.Random;

public class GameOfLifeExample {
    private boolean[][] grid;
    private int rows, cols;

    public GameOfLifeExample(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }

    public static void main(String[] args) {
        GameOfLifeExample game = new GameOfLifeExample(10, 20);

        System.out.println("=== Conway의 생명 게임 ===");

        // 글라이더 패턴 설정
        game.setGliderPattern(1, 1);

        // 5세대 진화 시뮬레이션
        for (int generation = 0; generation < 5; generation++) {
            System.out.println("세대 " + generation + ":");
            game.printGrid();
            System.out.println();

            game.nextGeneration();

            try {
                Thread.sleep(1000); // 시각적 딜레이
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("세대 5:");
        game.printGrid();
    }

    public void setCell(int row, int col, boolean alive) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = alive;
        }
    }

    public void setGliderPattern(int startRow, int startCol) {
        // 글라이더 패턴:
        //  .X.
        //  ..X
        //  XXX
        setCell(startRow, startCol + 1, true);
        setCell(startRow + 1, startCol + 2, true);
        setCell(startRow + 2, startCol, true);
        setCell(startRow + 2, startCol + 1, true);
        setCell(startRow + 2, startCol + 2, true);
    }

    // 다음 세대 계산
    public void nextGeneration() {
        boolean[][] nextGrid = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = countNeighbors(i, j);
                if (grid[i][j]) {
                    // 살아있는 셀
                    nextGrid[i][j] = (neighbors == 2 || neighbors == 3);
                } else {
                    // 죽은 셀
                    nextGrid[i][j] = (neighbors == 3);
                }
            }
        }
        grid = nextGrid;
    }

    // 주변 이웃 세기
    private int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 격자 출력
    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] ? "●" : "○");
            }
            System.out.println();
        }
    }

    // 랜덤 초기화
    public void randomize(double probability) {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextDouble() < probability;
            }
        }
    }
}
