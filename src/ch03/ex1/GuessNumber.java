package ch03.ex1;

import textio.TextIO;

public class GuessNumber {
    public static void main(String[] args) {
        int secretNumber = (int)(Math.random() * 100) + 1;  // 1~100
        int guess;
        int attempts = 0;

        System.out.println("1부터 100 사이의 숫자를 맞춰보세요!");

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            guess = TextIO.getlnInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("정답입니다! 시도 횟수: " + attempts + "번");
                break;
            } else if (guess < secretNumber) {
                System.out.println("더 큰 수입니다.");
            } else {
                System.out.println("더 작은 수입니다.");
            }
        }
    }
}
