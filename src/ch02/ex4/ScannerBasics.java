package ch02.ex4;

import java.util.Scanner;

public class ScannerBasics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Scanner 입력 테스트 ===");

        // 정수 입력
        System.out.print("정수를 입력하세요: ");
        int intValue = input.nextInt();

        // 실수 입력
        System.out.print("실수를 입력하세요: ");
        double doubleValue = input.nextDouble();

        // 버퍼 비우기 (중요!)
        input.nextLine();

        // 문자열 입력
        System.out.print("이름을 입력하세요: ");
        String name = input.nextLine();

        // 단어 입력
        System.out.print("좋아하는 색을 입력하세요: ");
        String color = input.next();

        // 결과 출력
        System.out.println("\n=== 입력된 값 ===");
        System.out.printf("정수: %d%n", intValue);
        System.out.printf("실수: %.2f%n", doubleValue);
        System.out.printf("이름: %s%n", name);
        System.out.printf("색상: %s%n", color);
    }
}