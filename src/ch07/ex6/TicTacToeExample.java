package ch07.ex6;

import java.util.Scanner;

public class TicTacToeExample {
    private static char[][] board = new char[3][3];
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== 틱택토 게임 ===");
        initializeBoard();

        char currentPlayer = PLAYER_X;
        boolean gameWon = false;
        int moves = 0;

        while (!gameWon && moves < 9) {
            printBoard();
            System.out.println("현재 플레이어: " + currentPlayer);

            if (makeMove(currentPlayer)) {
                moves++;
                gameWon = checkWinner(currentPlayer);

                if (gameWon) {
                    printBoard();
                    System.out.println("플레이어 " + currentPlayer + "가 승리했습니다!");
                } else {
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            }
        }

        if (!gameWon) {
            printBoard();
            System.out.println("무승부입니다!");
        }
    }

    // 보드 초기화
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    // 보드 출력
    public static void printBoard() {
        System.out.println("\n현재 보드:");
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("  ---------");
        }
        System.out.println();
    }

    // 플레이어 입력
    public static boolean makeMove(char player) {
        System.out.print("행과 열을 입력하세요 (예: 1 2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (isValidMove(row, col)) {
            board[row][col] = player;
            return true;
        } else {
            System.out.println("잘못된 위치입니다. 다시 시도하세요.");
            return false;
        }
    }

    // 유효성 검사
    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY;
    }

    // 승리 검사
    public static boolean checkWinner(char player) {
        // 행 검사
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }
        // 열 검사
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;
        }
        // 대각선 검사
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }
}
