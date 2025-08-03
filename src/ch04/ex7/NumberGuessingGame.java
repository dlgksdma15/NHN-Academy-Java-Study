package ch04.ex7;

import java.util.Scanner;

public class NumberGuessingGame {
    static int secretNumber;
    static int attempts;
    static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {
        initializeGame();
        showInstructions();

        boolean guessed = false;
        while (!guessed) {
            int guess = getUserInput();
            guessed = checkGuess(guess);
        }

        showResults();
    }

    static void initializeGame() {
        secretNumber = (int) (Math.random() * MAX_NUMBER) + 1;
        attempts = 0;
    }

    static void showInstructions() {
        System.out.println("=== 숫자 맞추기 게임 ===");
        System.out.println("1부터 " + MAX_NUMBER + " 사이의 숫자를 맞춰보세요!\n");
    }

    static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        while (true) {
            System.out.print("추측한 숫자: ");
            try {
                guess = Integer.parseInt(sc.nextLine());
                if (guess >= 1 && guess <= MAX_NUMBER) {
                    break;
                } else {
                    System.out.println("1부터 " + MAX_NUMBER + " 사이의 숫자를 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }
        return guess;
    }

    static boolean checkGuess(int guess) {
        attempts++;
        if (guess == secretNumber) {
            System.out.println("정답입니다!");
            return true;
        } else if (guess > secretNumber) {
            System.out.println("더 작은 수입니다.");
        } else {
            System.out.println("더 큰 수입니다.");
        }
        return false;
    }

    static void showResults() {
        System.out.println("\n축하합니다!");
        System.out.println(attempts + "번 만에 맞추셨습니다.");
        if (attempts <= 5) {
            System.out.println("훌륭합니다!");
        } else if (attempts <= 10) {
            System.out.println("괜찮아요!");
        } else {
            System.out.println("다음번엔 더 잘할 수 있어요!");
        }
    }
}
