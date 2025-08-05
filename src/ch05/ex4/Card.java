package ch05.ex4;

public class Card {

    // 무늬를 나타내는 상수
    public final static int SPADES = 0;   // 스페이드
    public final static int HEARTS = 1;   // 하트
    public final static int DIAMONDS = 2; // 다이아몬드
    public final static int CLUBS = 3;    // 클럽

    // 카드 값을 나타내는 상수
    public final static int ACE = 1;      // 에이스
    public final static int JACK = 11;    // 잭
    public final static int QUEEN = 12;   // 퀸
    public final static int KING = 13;    // 킹

    // 카드의 무늬 (0-3 중 하나)
    private final int suit;

    // 카드의 값 (1-13 중 하나)
    private final int value;

    /**
     * 지정된 값과 무늬로 카드를 생성
     */
    public Card(int theValue, int theSuit) {
        // TODO 1: value와 suit 초기화하기
        // value = theValue
        // suit = theSuit
        this.value = theValue;
        this.suit = theSuit;
    }

    /**
     * 카드의 값을 반환
     */
    public int getValue() {
        // TODO 2: value 반환하기
        return value;
    }

    /**
     * 카드의 무늬를 반환
     */
    public int getSuit() {
        // TODO 3: suit 반환하기
        return suit;
    }

    /**
     * 카드의 무늬를 문자열로 반환
     */
    public String getSuitAsString() {
        // TODO 4: suit 값에 따라 문자열 반환하기
        // switch문 사용
        // SPADES -> "스페이드"
        // HEARTS -> "하트"
        // DIAMONDS -> "다이아몬드"
        // CLUBS -> "클럽"
        // default -> "??"
        String suit = switch (getSuit()){
            case SPADES -> "스페이드";
            case HEARTS -> "하트";
            case DIAMONDS -> "다이아몬드";
            case CLUBS -> "클럽";
            default -> throw new IllegalStateException("Unexpected suit: " + getSuit());
        };
        return suit;
    }

    /**
     * 카드의 값을 문자열로 반환
     */
    public String getValueAsString() {
        // TODO 5: value 값에 따라 문자열 반환하기
        // switch문 사용
        // 1 -> "에이스"
        // 2~10 -> 숫자 그대로
        // 11 -> "잭"
        // 12 -> "퀸"
        // 13 -> "킹"
        // default -> "??"
        String value = switch (getValue()){
            case 1 -> "에이스";
            case 11 -> "잭";
            case 12 -> "퀸";
            case 13 -> "킹";
            default -> String.valueOf(getValue());
        };
        return value;

    }

    /**
     * 카드를 문자열로 표현
     */
    public String toString() {
        // TODO 6: 카드를 "값 무늬" 형식의 문자열로 반환하기
        // 예: "에이스 스페이드", "킹 하트"
        return getValueAsString() + " " + getSuitAsString();
    }
}