package ch03.ex3;

import textio.TextIO;

public class MultiplicationGame {
    public static void main(String[] args) {
        System.out.println("=== 구구단 게임 ===");
        System.out.println("문제를 풀어보세요! (0 입력시 종료)");

        int correct = 0;
        int wrong = 0;
        boolean playing = true;

        do {
            // 랜덤 문제 생성
            int a = (int)(Math.random() * 9) + 1;
            int b = (int)(Math.random() * 9) + 1;
            int correctAnswer = a * b;

            System.out.print("\n" + a + " × " + b + " = ");
            int answer = TextIO.getlnInt();

            if (answer == 0) {
                playing = false;
            } else if (answer == correctAnswer) {
                System.out.println("정답! ✓");
                correct++;
            } else {
                System.out.println("틀렸습니다. 정답은 " + correctAnswer + "입니다.");
                wrong++;
            }

            // 계속할지 묻기
            if (playing && (correct + wrong) % 5 == 0) {
                System.out.print("\n계속하시겠습니까? (y/n): ");
                char response = TextIO.getlnChar();
                if (response != 'y' && response != 'Y') {
                    playing = false;
                }
            }

        } while (playing);

        // 결과 출력
        System.out.println("\n=== 게임 결과 ===");
        System.out.println("정답: " + correct + "개");
        System.out.println("오답: " + wrong + "개");

        if (correct + wrong > 0) {
            double percentage = (double) correct / (correct + wrong) * 100;
            System.out.printf("정답률: %.1f%%%n", percentage);
        }
    }
}