package ch05.ex4;

import java.util.Random;

/**
 * 카드 덱을 나타내는 클래스
 */
class Deck {
    private Card[] deck;     // 카드 배열
    private int cardsUsed;   // 사용된 카드 수

    /**
     * 52장의 표준 카드 덱을 생성
     */
    public Deck() {
        // TODO 10: 52장의 카드로 이루어진 덱 생성하기
        // deck = new Card[52] 생성
        // 이중 for문 사용:
        //   - 바깥쪽: suit (0~3)
        //   - 안쪽: value (1~13)
        // 각 조합으로 Card 객체 생성하여 deck 배열에 저장
        // cardsUsed = 0으로 초기화
        deck = new Card[52];
        int index = 0;
        for(int suit = 0; suit <= 3; suit++){
            for(int value = 1; value <= 13; value++){
                deck[index++] = new Card(value, suit);
            }
        }
        cardsUsed = 0;
    }

    /**
     * 카드를 섞는다
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // 0 ~ i 범위의 랜덤 인덱스
            // swap
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        cardsUsed = 0; // 섞으면 사용된 카드 초기화
    }

    /**
     * 남은 카드 수를 반환
     */
    public int cardsLeft() {
        // TODO 12: 남은 카드 수 반환하기
        // 전체 카드 수 - 사용된 카드 수
        return deck.length - cardsUsed;
    }

    /**
     * 카드 한 장을 나누어준다
     */
    public Card dealCard() {
        // TODO 13: 카드 한 장 나누어주기
        // 카드가 없으면 IllegalStateException 발생
        // cardsUsed 증가시키고 해당 위치의 카드 반환
        if(cardsUsed == deck.length){
            throw new IllegalStateException("댁에 남은 카드가 없습니다.");
        }
        return deck[cardsUsed++];
    }

    /**
     * 덱에 조커가 있는지 확인
     */
    public boolean hasJoker() {
        // TODO 14: 조커 포함 여부 반환하기 (기본 덱은 조커 없음)
        return false;
    }
}

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
