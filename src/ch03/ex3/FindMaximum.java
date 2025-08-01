package ch03.ex3;

import textio.TextIO;

public class FindMaximum {
    public static void main(String[] args) {
        System.out.println("=== 최댓값 찾기 ===");
        System.out.println("숫자를 입력하세요 (-999 입력시 종료):");

        // 첫 번째 입력
        System.out.print("숫자: ");
        double number = TextIO.getlnDouble();

        if (number == -999) {
            System.out.println("입력된 숫자가 없습니다!");
            return;
        }

        double max = number;

        while (true) {
            System.out.print("숫자: ");
            number = TextIO.getlnDouble();

            if (number == -999) {
                break;
            }

            if (number > max) {
                max = number;
            }
        }

        System.out.println("\n최댓값: " + max);
    }
}
