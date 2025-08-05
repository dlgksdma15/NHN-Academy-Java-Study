package ch05.ex4;

import java.util.ArrayList;

/**
 * 손에 든 카드들을 관리하는 클래스
 */



// 사용 예제
public class HandExample {
    public static void main(String[] args) {
        System.out.println("=== 손패 관리 테스트 ===");

        // 덱 생성 및 셔플
        Deck deck = new Deck();
        deck.shuffle();

        // 손 객체 생성
        Hand hand = new Hand();

        // 카드 5장 받기
        System.out.println("\n카드 5장 받기:");
        for (int i = 0; i < 5; i++) {
            Card card = deck.dealCard();
            hand.addCard(card);
            System.out.println("받은 카드: " + card);
        }

        // 손패 카드 수 출력
        System.out.println("\n손패 카드 수: " + hand.getCardCount());

        // 무늬별 정렬 후 출력
        System.out.println("\n무늬별 정렬:");
        hand.sortBySuit();
        hand.printHand();

        // 값별 정렬 후 출력
        System.out.println("\n값별 정렬:");
        hand.sortByValue();
        hand.printHand();
    }
}