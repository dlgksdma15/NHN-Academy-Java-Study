package ch03.ex4;

import textio.TextIO;

public class ListLettersInText {
    public static void main(String[] args) {
        System.out.println("텍스트를 입력하세요:");
        String str = TextIO.getln();

        // 대문자로 변환
        str = str.toUpperCase();

        int count = 0;
        System.out.println("\n입력한 텍스트에 포함된 문자:");

        // === 알파벳 포함 여부 확인 ===
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            boolean found = false;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == letter) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.print(letter + " ");
                count++;
            }
        }

        System.out.println("\n\n서로 다른 문자의 개수: " + count);

        // === 알파벳 빈도수 계산 ===
        System.out.println("\n문자별 빈도수:");
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            int frequency = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == letter) {
                    frequency++;
                }
            }
            if (frequency > 0) {
                System.out.println(letter + ": " + frequency);
            }
        }
    }
}
