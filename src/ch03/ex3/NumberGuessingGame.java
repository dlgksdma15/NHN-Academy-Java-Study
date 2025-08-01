package ch03.ex3;

import textio.TextIO;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("=== 숫자 맞추기 게임 ===");

        boolean playAgain;

        do {
            // 1-100 사이의 랜덤 숫자 생성
            int secretNumber = (int)(Math.random() * 100) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\n1부터 100 사이의 숫자를 맞춰보세요!");

            while (!guessed) {
                System.out.print("추측: ");
                int guess = TextIO.getlnInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("1부터 100 사이의 숫자를 입력하세요!");
                    continue;
                }

                // TODO: 숫자 맞추기 로직
                // 힌트:
                // 1. guess가 secretNumber보다 작으면: "더 큰 숫자입니다."
                // 2. guess가 secretNumber보다 크면: "더 작은 숫자입니다."
                // 3. 같으면:
                //    - guessed를 true로 설정
                //    - 성공 메시지 출력
                //    - attempts에 따른 평가 메시지 출력

                // 여기에 코드를 작성하세요
                if (guess < secretNumber){
                    System.out.println("더 큰 숫자입니다.");
                } else if(guess > secretNumber){
                    System.out.println("더 작은 숫자입니다.");
                } else{
                    guessed = true;
                    System.out.printf("정답! %d번 만에 맞췄습니다!", attempts);
                }
            }

            // 다시 플레이할지 묻기
            System.out.print("\n다시 플레이하시겠습니까? (y/n): ");
            char answer = TextIO.getlnChar();
            playAgain = (answer == 'y' || answer == 'Y');

        } while (playAgain);

        System.out.println("\n게임을 종료합니다. 감사합니다!");
    }
}