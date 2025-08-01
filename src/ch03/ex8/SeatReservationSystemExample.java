package ch03.ex8;

import textio.TextIO;

public class SeatReservationSystemExample {
    public static void main(String[] args) {
        final int ROWS = 5;
        final int COLS = 6;
        boolean[][] seats = new boolean[ROWS][COLS];  // false = 빈 좌석, true = 예약됨

        System.out.println("=== 극장 좌석 예약 시스템 ===");
        System.out.println("좌석 배치: " + ROWS + "행 × " + COLS + "열");

        while (true) {
            // 좌석 현황 표시
            displaySeats(seats);

            // 메뉴
            System.out.println("\n1. 좌석 예약");
            System.out.println("2. 예약 취소");
            System.out.println("3. 예약률 확인");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int choice = TextIO.getlnInt();

            switch (choice) {
                case 1: // 예약
                    System.out.print("예약할 행 번호 (1-" + ROWS + "): ");
                    int row = TextIO.getlnInt() - 1;
                    System.out.print("예약할 열 번호 (1-" + COLS + "): ");
                    int col = TextIO.getlnInt() - 1;

                    if (isValidSeat(row, col, ROWS, COLS)) {
                        if (!seats[row][col]) {
                            seats[row][col] = true;
                            System.out.println("✅ 좌석이 예약되었습니다.");
                        } else {
                            System.out.println("❌ 이미 예약된 좌석입니다.");
                        }
                    } else {
                        System.out.println("❌ 유효하지 않은 좌석 번호입니다.");
                    }
                    break;

                case 2: // 취소
                    System.out.print("취소할 행 번호 (1-" + ROWS + "): ");
                    row = TextIO.getlnInt() - 1;
                    System.out.print("취소할 열 번호 (1-" + COLS + "): ");
                    col = TextIO.getlnInt() - 1;

                    if (isValidSeat(row, col, ROWS, COLS)) {
                        if (seats[row][col]) {
                            seats[row][col] = false;
                            System.out.println("✅ 예약이 취소되었습니다.");
                        } else {
                            System.out.println("❌ 예약되지 않은 좌석입니다.");
                        }
                    } else {
                        System.out.println("❌ 유효하지 않은 좌석 번호입니다.");
                    }
                    break;

                case 3: // 예약률
                    showReservationStats(seats);
                    break;

                case 0: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("❌ 잘못된 선택입니다.");
            }
        }
    }

    public static void displaySeats(boolean[][] seats) {
        System.out.print("   "); // 열 번호 출력 공간
        for (int col = 0; col < seats[0].length; col++) {
            System.out.printf("%2d ", col + 1);
        }
        System.out.println();

        for (int row = 0; row < seats.length; row++) {
            System.out.printf("%2d ", row + 1);  // 행 번호 출력
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col]) {
                    System.out.print("■  ");  // 예약된 좌석
                } else {
                    System.out.print("□  ");  // 빈 좌석
                }
            }
            System.out.println();
        }
    }

    public static void showReservationStats(boolean[][] seats) {
        int totalSeats = seats.length * seats[0].length;
        int reservedSeats = 0;

        // 예약된 좌석 수 계산
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col]) reservedSeats++;
            }
        }

        double reservationRate = (reservedSeats * 100.0) / totalSeats;

        System.out.println("\n=== 예약 통계 ===");
        System.out.println("전체 좌석: " + totalSeats + "석");
        System.out.println("예약된 좌석: " + reservedSeats + "석");
        System.out.println("빈 좌석: " + (totalSeats - reservedSeats) + "석");
        System.out.printf("예약률: %.1f%%%n", reservationRate);

        // 행별 예약률
        System.out.println("\n행별 예약 현황:");
        for (int row = 0; row < seats.length; row++) {
            int rowReserved = 0;
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col]) rowReserved++;
            }
            System.out.printf("%d행: %d/%d석 (%.0f%%)%n",
                    row + 1, rowReserved, seats[row].length,
                    (rowReserved * 100.0) / seats[row].length);
        }
    }
    // 좌석 유효성 검사 메서드
    public static boolean isValidSeat(int row, int col, int maxRow, int maxCol) {
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

}