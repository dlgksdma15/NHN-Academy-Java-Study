package ch07.ex5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardShuffleExample {
    public static void main(String[] args) {
        List<Card> deck = createDeck();
        System.out.println("=== 초기 카드 덱 ===");
        printDeck(deck);

        shuffleDeck(deck);
        System.out.println("\n=== 섞인 카드 덱 ===");
        printDeck(deck);

        System.out.println("\n=== 플레이어에게 카드 나누기 ===");
        dealCards(deck, 4, 5); // 4명의 플레이어에게 5장씩 나누기
    }

    // TODO: 52장의 카드 덱을 생성하는 메서드를 작성하세요
    // 메서드명: createDeck, 반환값: List<Card>
    public static List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    // TODO: 카드 덱을 섞는 메서드를 작성하세요
    // 메서드명: shuffleDeck, 매개변수: List<Card> deck
    // 힌트: Collections.shuffle() 사용
    public static void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    // TODO: 카드 덱을 출력하는 메서드를 작성하세요
    // 메서드명: printDeck, 매개변수: List<Card> deck
    public static void printDeck(List<Card> deck) {
        for (int i = 0; i < deck.size(); i++) {
            System.out.printf("%18s", deck.get(i));
            if ((i + 1) % 4 == 0) { // 한 줄에 4장씩 출력
                System.out.println();
            }
        }
        System.out.println();
    }

    // TODO: 플레이어에게 카드를 나누어주는 메서드를 작성하세요
    // 메서드명: dealCards, 매개변수: List<Card> deck, int numPlayers, int cardsPerPlayer
    public static void dealCards(List<Card> deck, int numPlayers, int cardsPerPlayer) {
        if (deck.size() < numPlayers * cardsPerPlayer) {
            System.out.println("카드가 부족하여 모든 플레이어에게 나눌 수 없습니다.");
            return;
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("\n--- 플레이어 " + (i + 1) + "의 카드 ---");
            for (int j = 0; j < cardsPerPlayer; j++) {
                System.out.println(deck.remove(0)); // 덱의 맨 위 카드 제거 및 제공
            }
        }
    }
}
