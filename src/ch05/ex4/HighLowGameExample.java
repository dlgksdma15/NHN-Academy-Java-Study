package ch05.ex4;

import java.util.Random;

class HighLowGame {
    private Deck deck;
    private Card currentCard;
    private int correctGuesses;
    private boolean gameOver;

    // TODO 33: 게임 초기화
    public HighLowGame() {
        deck = new Deck();     // 새로운 덱 생성
        deck.shuffle();        // 셔플
        currentCard = deck.dealCard(); // 첫 번째 카드 뽑기
        correctGuesses = 0;
        gameOver = false;
    }

    // TODO 34: 현재 카드 반환
    public Card getCurrentCard() {
        return currentCard;
    }

    // TODO 35: 게임 종료 여부 확인
    public boolean isGameOver() {
        return gameOver;
    }

    // TODO 36: 현재 점수 반환
    public int getScore() {
        return correctGuesses;
    }

    // TODO 37: "다음 카드가 더 높다"고 추측
    public boolean guessHigher() {
        if (gameOver) return false;

        Card nextCard = deck.dealCard(); // 다음 카드 뽑기
        boolean result = nextCard.getValue() > currentCard.getValue();

        if (result) {
            correctGuesses++;
        } else {
            gameOver = true;
        }

        currentCard = nextCard; // 다음 카드로 갱신
        return result;
    }

    // TODO 38: "다음 카드가 더 낮다"고 추측
    public boolean guessLower() {
        if (gameOver) return false;

        Card nextCard = deck.dealCard();
        boolean result = nextCard.getValue() < currentCard.getValue();

        if (result) {
            correctGuesses++;
        } else {
            gameOver = true;
        }

        currentCard = nextCard;
        return result;
    }
}



public class HighLowGameExample {
    public static void main(String[] args) {
        System.out.println("=== High-Low 카드 게임 시작 ===");
        System.out.println("다음 카드가 더 높을지(Higher) 낮을지(Lower) 맞추세요.");
        System.out.println("10번 연속 맞추면 승리!\n");

        HighLowGame game = new HighLowGame();
        Random rand = new Random();

        // TODO 40: 게임 루프
        while (!game.isGameOver() && game.getScore() < 10) {
            Card current = game.getCurrentCard();
            System.out.println("현재 카드: " + current);

            // 랜덤하게 Higher 또는 Lower 선택
            boolean guessHigher = rand.nextBoolean();
            System.out.println("추측: " + (guessHigher ? "Higher" : "Lower"));

            boolean correct = guessHigher ? game.guessHigher() : game.guessLower();

            if (correct) {
                System.out.println("정답! 점수: " + game.getScore());
            } else {
                System.out.println("오답! 게임 종료!");
                break;
            }

            System.out.println("-------------------");
        }

        // TODO 41: 최종 점수 출력
        System.out.println("최종 점수: " + game.getScore());
    }
}