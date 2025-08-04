package ch05.ex4;

import java.util.ArrayList;

/**
 * 손에 든 카드들을 관리하는 클래스
 */

class Hand {
    private ArrayList<Card> hand;  // 손에 든 카드들

    // TODO 19: 빈 손패 생성자
    public Hand() {
        hand = new ArrayList<>();
    }

    // TODO 20: 손패 비우기
    public void clear() {
        hand.clear();
    }

    // TODO 21: 카드 추가
    public void addCard(Card c) {
        if (c == null) {
            throw new NullPointerException("카드는 null일 수 없습니다.");
        }
        hand.add(c);
    }

    // TODO 22: 특정 카드 제거
    public void removeCard(Card c) {
        hand.remove(c);
    }

    // TODO 23: 특정 위치 카드 제거
    public void removeCard(int position) {
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("위치가 유효하지 않습니다.");
        }
        hand.remove(position);
    }

    // TODO 24: 손패의 카드 수 반환
    public int getCardCount() {
        return hand.size();
    }

    // TODO 25: 특정 위치 카드 반환
    public Card getCard(int position) {
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("위치가 유효하지 않습니다.");
        }
        return hand.get(position);
    }

    // TODO 26: 무늬별 정렬
    public void sortBySuit() {
        ArrayList<Card> newHand = new ArrayList<>();
        while (!hand.isEmpty()) {
            int minIndex = 0;
            Card minCard = hand.get(0);
            for (int i = 1; i < hand.size(); i++) {
                Card card = hand.get(i);
                // 무늬 먼저 비교, 같으면 값 비교
                if (card.getSuit() < minCard.getSuit() ||
                        (card.getSuit() == minCard.getSuit() && card.getValue() < minCard.getValue())) {
                    minIndex = i;
                    minCard = card;
                }
            }
            newHand.add(hand.remove(minIndex));
        }
        hand = newHand;
    }

    // TODO 27: 값별 정렬
    public void sortByValue() {
        ArrayList<Card> newHand = new ArrayList<>();
        while (!hand.isEmpty()) {
            int minIndex = 0;
            Card minCard = hand.get(0);
            for (int i = 1; i < hand.size(); i++) {
                Card card = hand.get(i);
                // 값 먼저 비교, 같으면 무늬 비교
                if (card.getValue() < minCard.getValue() ||
                        (card.getValue() == minCard.getValue() && card.getSuit() < minCard.getSuit())) {
                    minIndex = i;
                    minCard = card;
                }
            }
            newHand.add(hand.remove(minIndex));
        }
        hand = newHand;
    }

    // 손패 출력용 메서드 (편의)
    public void printHand() {
        for (Card c : hand) {
            System.out.println(c);
        }
    }
}

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