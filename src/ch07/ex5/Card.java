package ch07.ex5;

public class Card {
    private String suit; // 슈트 (하트, 다이아몬드, 클럽, 스페이드)
    private String rank; // 랭크 (A, 2, ..., 10, J, Q, K)

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}