package ch09.ex1;

public class BlobCounting {

    private static boolean[][] visited;

    /**
     * 4방향 연결 blob 크기 계산
     */
    public static int getBlobSize4(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // TODO 1: 경계 체크 및 기저 사례
        if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        if (visited[row][col]) return 0;
        if (grid[row][col] == 0) return 0;

        // TODO 2: 현재 위치 방문 표시
        visited[row][col] = true;

        // TODO 3: 4방향 재귀 호출
        int size = 1;
        size += getBlobSize4(grid, row - 1, col); // 위
        size += getBlobSize4(grid, row + 1, col); // 아래
        size += getBlobSize4(grid, row, col - 1); // 왼쪽
        size += getBlobSize4(grid, row, col + 1); // 오른쪽

        return size;
    }


    public static void main(String[] args) {
        System.out.println("=== Blob 카운팅 예제 ===");

        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        visited = new boolean[grid.length][grid[0].length];
        System.out.println("(0,0) 위치의 blob 크기: " + getBlobSize4(grid, 0, 0));

        visited = new boolean[grid.length][grid[0].length];
        System.out.println("(2,4) 위치의 blob 크기: " + getBlobSize4(grid, 2, 4));

        visited = new boolean[grid.length][grid[0].length];
        System.out.println("(3,0) 위치의 blob 크기: " + getBlobSize4(grid, 3, 0));
    }

}