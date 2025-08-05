package ch05.ex4;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private ArrayList<Card> hand;  // 손에 든 카드들

    // 빈 손패 생성자
    public Hand() {
        hand = new ArrayList<>();
    }

    // 카드 리스트 복사본 반환
    public List<Card> getCards() {
        return new ArrayList<>(hand); // hand로 수정
    }

    // 손패 비우기
    public void clear() {
        hand.clear();
    }

    // 카드 추가
    public void addCard(Card c) {
        if (c == null) {
            throw new NullPointerException("카드는 null일 수 없습니다.");
        }
        hand.add(c);
    }

    // 특정 카드 제거
    public void removeCard(Card c) {
        hand.remove(c);
    }

    // 특정 위치 카드 제거
    public void removeCard(int position) {
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("위치가 유효하지 않습니다.");
        }
        hand.remove(position);
    }

    // 손패의 카드 수 반환
    public int getCardCount() {
        return hand.size();
    }

    // 특정 위치 카드 반환
    public Card getCard(int position) {
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("위치가 유효하지 않습니다.");
        }
        return hand.get(position);
    }

    // 무늬별 정렬
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

    // 값별 정렬
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
