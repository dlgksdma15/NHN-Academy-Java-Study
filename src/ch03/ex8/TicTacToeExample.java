package ch03.ex8;

import textio.TextIO;

public class TicTacToeExample {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);

        System.out.println("=== 틱택토 게임 ===");
        System.out.println("플레이어 1: X, 플레이어 2: O");

        boolean player1Turn = true;
        int moves = 0;

        while (moves < 9) {
            displayBoard(board);

            char currentPlayer = player1Turn ? 'X' : 'O';
            System.out.println("\n플레이어 " + (player1Turn ? "1" : "2") + "의 차례 (" + currentPlayer + ")");

            // 유효한 위치 입력받기
            int row, col;
            while (true) {
                System.out.print("행 번호 (1-3): ");
                row = TextIO.getlnInt() - 1;
                System.out.print("열 번호 (1-3): ");
                col = TextIO.getlnInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    break;
                }
                System.out.println("❌ 유효하지 않은 위치입니다. 다시 입력하세요.");
            }

            // 수 놓기
            board[row][col] = currentPlayer;
            moves++;

            // 승리 확인
            if (checkWin(board, currentPlayer)) {
                displayBoard(board);
                System.out.println("\n🎉 플레이어 " + (player1Turn ? "1" : "2") + " 승리!");
                return;
            }

            // 턴 교체
            player1Turn = !player1Turn;
        }

        // 무승부
        displayBoard(board);
        System.out.println("\n🤝 무승부!");
    }

    public static void initializeBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("\n  1   2   3");
        for (int row = 0; row < board.length; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < board[row].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < board.length - 1) {
                System.out.println("  ---|---|---");
            }
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        // 행 검사
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) {
                return true;
            }
        }

        // 열 검사
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player &&
                    board[1][j] == player &&
                    board[2][j] == player) {
                return true;
            }
        }

        // 대각선 검사
        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) {
            return true;
        }

        return false;
    }
}
