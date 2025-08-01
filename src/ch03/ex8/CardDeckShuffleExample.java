package ch03.ex8;

import java.util.Random;

public class CardDeckShuffleExample {
    public static void main(String[] args) {
        System.out.println("=== 카드 덱 셔플링 ===");

        // 카드 덱 생성 (52장)
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];

        // 덱 초기화
        int cardIndex = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[cardIndex] = suit + rank;
                cardIndex++;
            }
        }

        // 원본 덱 출력
        System.out.println("원본 덱:");
        printDeck(deck);

        // 셔플링
        shuffleDeck(deck);

        // 셔플된 덱 출력
        System.out.println("\n셔플된 덱:");
        printDeck(deck);

        // 5장 뽑기
        System.out.println("\n뽑은 카드 5장:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + deck[i]);
        }
    }

    public static void shuffleDeck(String[] deck) {
        Random random = new Random();
        // Fisher-Yates 셔플
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);  // 0부터 i까지 랜덤 인덱스 선택

            // deck[i]와 deck[j] 교환
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static void printDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            System.out.print(deck[i] + " ");
            if ((i + 1) % 13 == 0) {
                System.out.println();  // 13장마다 줄바꿈
            }
        }
    }
}
