package ch04.ex3;

public class GameWithGlobalState {
    // 85: 게임 상태 전역 변수
    static int score = 0;
    static int round = 0;
    static int wins = 0;
    static int losses = 0;

    public static void main(String[] args) {
        System.out.println("=== 주사위 게임 (전역 변수 사용) ===\n");

        // 86: 게임 진행 (5라운드 예시)
        for (int i = 0; i < 5; i++) {
            playRound();
        }

        // 87: 최종 결과 출력
        showFinalResult();
    }

    // 88: 한 라운드 플레이
    static void playRound() {
        round++;
        int dice1 = rollDice();
        int dice2 = rollDice();
        int sum = dice1 + dice2;

        System.out.printf("라운드 %d: 주사위 1 = %d, 주사위 2 = %d, 합계 = %d\n",
                round, dice1, dice2, sum);

        if (sum >= 7) {
            wins++;
            score += 10;
            System.out.println("승리! +10점");
        } else {
            losses++;
            score -= 5;
            System.out.println("패배! -5점");
        }

        showCurrentScore();
        System.out.println();
    }

    // 89: 주사위 굴리기
    static int rollDice() {
        return (int) (Math.random() * 6) + 1; // 1~6 사이 랜덤
    }

    // 90: 현재 점수 출력
    static void showCurrentScore() {
        System.out.printf("현재 점수: %d점 (승리: %d, 패배: %d)\n", score, wins, losses);
    }

    // 91: 최종 결과 출력
    static void showFinalResult() {
        System.out.println("=== 게임 종료 ===");
        System.out.printf("총 라운드: %d, 승리: %d, 패배: %d, 최종 점수: %d점\n",
                round, wins, losses, score);
    }
}
