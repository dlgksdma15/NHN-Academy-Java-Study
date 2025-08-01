package ch04.ex2;

public class DiceGame {
    // TODO 50: 게임 통계 변수들 선언하기
    private static int gamesPlayed,playerWins, computerWins, draws;

    public static void main(String[] args) {
        System.out.println("=== 주사위 게임 ===");
        System.out.println("주사위를 3번 굴려 합이 큰 쪽이 승리합니다!");

        // TODO 51: 게임을 여러 번 실행하기
        playOneGame();
        // playOneGame();
        // playOneGame();
        // showFinalStatistics();
    }

    // TODO 52: 한 게임 플레이 메서드 구현하기
    public static void playOneGame() {
        while(gamesPlayed < 3) {
            gamesPlayed++;
            System.out.printf("=== 게임 #%d ===\n", gamesPlayed);
            int playerTotal = 0;
            int computerTotal = 0;
            for (int i = 1; i <= 3; i++) {
                int n = rollDice();
                playerTotal += n;
                System.out.printf("주사위 %d: %d\n", i, n);
            }
            System.out.println("플레이어 총점: " + playerTotal);

            System.out.println();

            System.out.println("켬퓨터 차례: ");
            for (int i = 1; i <= 3; i++) {
                int n = rollDice();
                computerTotal += n;
                System.out.printf("주사위 %d: %d\n", i, n);
            }
            System.out.println("컴퓨터 총점: " + computerTotal + "\n");
            System.out.println("=== 결과 ===");
            if(playerTotal > computerTotal){
                System.out.println("플레이어 승리!");
                playerWins++;
            }else if(playerTotal < computerTotal){
                System.out.println("컴퓨터 승리!");
                computerWins++;
            }else{
                System.out.println("무승부!");
                draws++;
            }
            String whoWin = playerTotal > computerTotal ? "플레이어 승리!" : "컴퓨터 승리!";
            System.out.println(whoWin + "\n");
        }
        showFinalStatistics();

    }

    // TODO 53: 주사위 굴리기 메서드 구현하기
    public static int rollDice() {
        // 1~6 사이의 랜덤 숫자 반환 (Math.random() 사용)
        int n = (int)(Math.random() * 6 + 1);
        return n;
    }

    // TODO 54: 최종 통계 메서드 구현하기
    public static void showFinalStatistics() {
        // 총 게임 수, 플레이어 승리 수, 컴퓨터 승리 수, 무승부 수 출력
        // 게임 수가 0보다 크면 승률도 계산하여 출력
        System.out.println("=== 최종 통계 ===");
        System.out.println("총 게임 수: " + gamesPlayed);
        System.out.println("플레이어 승리: " + playerWins);
        System.out.println("컴퓨터 승리: " + computerWins);
        System.out.println("무승부: " + draws);
        if(gamesPlayed > 0){
            System.out.printf("승률: %.1f%%" , (double)playerWins / gamesPlayed * 100.0);
        }


    }
}