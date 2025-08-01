package ch03.ex3;

import textio.TextIO;

public class SentinelPatterns {
    public static void main(String[] args) {
        // 숫자 센티넬 (0)
        System.out.println("=== 점수 입력 (0: 종료) ===");
        int scoreCount = 0;
        int scoreSum = 0;

        System.out.print("점수: ");
        int score = TextIO.getlnInt();

        while (score != 0) {
            if (score > 0 && score <= 100) {
                scoreSum += score;
                scoreCount++;
            } else if (score != 0) {
                System.out.println("유효하지 않은 점수입니다!");
            }

            System.out.print("점수: ");
            score = TextIO.getlnInt();
        }

        if (scoreCount > 0) {
            double average = (double) scoreSum / scoreCount;
            System.out.printf("평균 점수: %.2f%n", average);
        }

        // 문자열 센티넬 ("quit")
        System.out.println("\n=== 단어 입력 (quit: 종료) ===");
        int wordCount = 0;

        System.out.print("단어: ");
        String word = TextIO.getln();

        while (!word.equalsIgnoreCase("quit")) {
            wordCount++;
            System.out.println("입력한 단어: " + word);

            System.out.print("단어: ");
            word = TextIO.getln();
        }

        System.out.println("총 " + wordCount + "개의 단어를 입력했습니다.");

        // 특수 값 센티넬 (-1)
        System.out.println("\n=== 온도 입력 (-999: 종료) ===");
        double maxTemp = Double.NEGATIVE_INFINITY;
        double minTemp = Double.POSITIVE_INFINITY;
        boolean hasData = false;

        System.out.print("온도: ");
        double temp = TextIO.getlnDouble();

        while (temp != -999) {
            hasData = true;

            if (temp > maxTemp) {
                maxTemp = temp;
            }
            if (temp < minTemp) {
                minTemp = temp;
            }

            System.out.print("온도: ");
            temp = TextIO.getlnDouble();
        }

        if (hasData) {
            System.out.println("최고 온도: " + maxTemp);
            System.out.println("최저 온도: " + minTemp);
        } else {
            System.out.println("입력된 온도가 없습니다.");
        }
    }
}