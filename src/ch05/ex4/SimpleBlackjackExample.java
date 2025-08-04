package ch05.ex4;

class BlackjackHand extends Hand {

    /**
     * 블랙잭에서의 손패 값 계산
     */
    public int getBlackjackValue() {
        int val = 0;
        boolean ace = false;

        for (int i = 0; i < getCardCount(); i++) {
            Card card = getCard(i);
            int cardVal = card.getValue();

            if (cardVal > 10) {
                cardVal = 10;   // J, Q, K는 10으로 계산
            }
            if (cardVal == 1) {
                ace = true;     // 에이스 발견
            }
            val = val + cardVal;
        }

        // 에이스가 있고 11로 계산해도 21을 넘지 않으면
        if (ace && val + 10 <= 21) {
            val = val + 10;
        }

        return val;
    }
}


public class SimpleBlackjackExample {
    public static void main(String[] args) {
        System.out.println("=== 간단한 블랙잭 게임 ===");

        int playerWins = 0;
        int dealerWins = 0;
        int ties = 0;

        for (int round = 1; round <= 5; round++) {
            System.out.println("\n--- 라운드 " + round + " ---");

            // 덱 준비 및 셔플
            Deck deck = new Deck();
            deck.shuffle();

            // 플레이어와 딜러 손 준비
            BlackjackHand player = new BlackjackHand();
            BlackjackHand dealer = new BlackjackHand();

            // 초기 2장씩 배분
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());

            // 플레이어 턴
            System.out.println("플레이어 초기 카드: " + player.getBlackjackValue());
            while (player.getBlackjackValue() <= 17) {
                player.addCard(deck.dealCard());
                System.out.println("플레이어 히트! 합계: " + player.getBlackjackValue());
            }
            if (player.getBlackjackValue() > 21) {
                System.out.println("플레이어 버스트! 딜러 승리!");
                dealerWins++;
                continue;
            }

            // 딜러 턴
            System.out.println("딜러 초기 카드: " + dealer.getBlackjackValue());
            while (dealer.getBlackjackValue() <= 16) {
                dealer.addCard(deck.dealCard());
                System.out.println("딜러 히트! 합계: " + dealer.getBlackjackValue());
            }
            if (dealer.getBlackjackValue() > 21) {
                System.out.println("딜러 버스트! 플레이어 승리!");
                playerWins++;
                continue;
            }

            // 승부 판정
            int playerTotal = player.getBlackjackValue();
            int dealerTotal = dealer.getBlackjackValue();

            if (playerTotal > dealerTotal) {
                System.out.println("플레이어 승리!");
                playerWins++;
            } else if (dealerTotal > playerTotal) {
                System.out.println("딜러 승리!");
                dealerWins++;
            } else {
                System.out.println("무승부!");
                ties++;
            }
        }

        // 최종 통계
        System.out.println("\n=== 최종 결과 ===");
        System.out.println("플레이어 승: " + playerWins);
        System.out.println("딜러 승: " + dealerWins);
        System.out.println("무승부: " + ties);
    }
}

