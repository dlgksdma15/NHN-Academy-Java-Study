package ch05.ex4;

import java.util.Random;

/**
 * 카드 덱을 나타내는 클래스
 */


// 사용 예제
public class DeckExample {
    public static void main(String[] args) {
        System.out.println("=== 카드 덱 테스트 ===");

        // 덱 생성 및 셔플
        Deck deck = new Deck();
        deck.shuffle();

        // 카드 5장 뽑기
        System.out.println("\n카드 5장 뽑기:");
        for (int i = 1; i <= 5; i++) {
            Card card = deck.dealCard();
            System.out.printf("카드 %d: %s\n", i, card);
        }

        // 남은 카드 수 출력
        System.out.println("\n남은 카드 수: " + deck.cardsLeft());

        // 덱 다시 셔플
        deck.shuffle();
        System.out.println("덱을 다시 셔플했습니다.");
        System.out.println("남은 카드 수: " + deck.cardsLeft());
    }
}
