package ch03.ex4;

public class AlphabetLoop {
    public static void main(String[] args) {
        // 대문자 알파벳
        System.out.println("대문자 알파벳:");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println(); // 줄바꿈

        // 소문자 알파벳
        System.out.println("\n소문자 알파벳:");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println(); // 줄바꿈

        // 알파벳과 ASCII 코드
        System.out.println("\n알파벳과 ASCII 코드:");
        for (char ch = 'A'; ch <= 'F'; ch++) {
            System.out.println(ch + " = " + (int)ch);
        }
    }
}
