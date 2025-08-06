package ch07.ex5;

import java.util.Scanner;

public class QuizShuffleExample {
    static class Question {
        String question;
        String[] options;
        int correctAnswer;  // 정답 인덱스 (0-3)

        Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public void display(int questionNumber) {
            System.out.printf("\n%d. %s\n", questionNumber, question);
            for (int i = 0; i < options.length; i++) {
                System.out.printf("  %d) %s\n", i + 1, options[i]);
            }
        }

        public boolean isCorrect(int userAnswer) {
            return userAnswer - 1 == correctAnswer;  // 1-4를 0-3으로 변환
        }

        public String getCorrectAnswerText() {
            return options[correctAnswer];
        }
    }

    public static void main(String[] args) {
        // 퀴즈 문제들 생성
        Question[] questions = {
                new Question("Java에서 배열의 크기를 얻는 방법은?",
                        new String[]{"array.size()", "array.length", "array.count()", "array.getSize()"},
                        1),
                new Question("다음 중 올바른 변수명은?",
                        new String[]{"2name", "class", "userName", "user-name"},
                        2),
                new Question("Java에서 문자열을 비교할 때 사용하는 메서드는?",
                        new String[]{"compare()", "equals()", "same()", "match()"},
                        1),
                new Question("배열의 인덱스는 몇부터 시작하나요?",
                        new String[]{"1", "0", "-1", "배열에 따라 다름"},
                        1),
                new Question("다음 중 반복문이 아닌 것은?",
                        new String[]{"for", "while", "if", "do-while"},
                        2)
        };

        System.out.println("=== Java 기초 퀴즈 ===");
        System.out.println("총 " + questions.length + "문제입니다.");

        // 문제 순서 섞기
        shuffleQuestions(questions);

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // 퀴즈 진행
        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            q.display(i + 1);

            System.out.print("답 (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("정답입니다! ✓");
                score++;
            } else {
                System.out.println("틀렸습니다. ✗");
                System.out.println("정답: " + q.getCorrectAnswerText());
            }
        }

        // 결과 출력
        System.out.printf("\n=== 퀴즈 결과 ===\n");
        System.out.printf("점수: %d/%d (%.1f%%)\n",
                score, questions.length, (score * 100.0 / questions.length));

        if (score == questions.length) {
            System.out.println("완벽합니다! 🎉");
        } else if (score >= questions.length * 0.8) {
            System.out.println("잘했습니다! 👍");
        } else if (score >= questions.length * 0.6) {
            System.out.println("괜찮습니다. 조금 더 공부해보세요!");
        } else {
            System.out.println("더 공부가 필요합니다. 화이팅! 💪");
        }

        scanner.close();
    }

    public static void shuffleQuestions(Question[] questions) {
        for (int i = questions.length - 1; i > 0; i--) {
            int randomIndex = (int)(Math.random() * (i + 1));

            // 문제 순서 섞기
            Question temp = questions[i];
            questions[i] = questions[randomIndex];
            questions[randomIndex] = temp;
        }
    }
}
