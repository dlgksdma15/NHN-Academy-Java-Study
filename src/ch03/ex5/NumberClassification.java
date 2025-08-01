package ch03.ex5;

import textio.TextIO;

public class NumberClassification {
    public static void main(String[] args) {
        System.out.print("숫자를 입력하세요: ");
        double number = TextIO.getlnDouble();

        if (number > 0) {
            System.out.println("양수입니다.");
        } else if (number < 0) {
            System.out.println("음수입니다.");
        } else {
            System.out.println("0입니다.");
        }
    }
}
