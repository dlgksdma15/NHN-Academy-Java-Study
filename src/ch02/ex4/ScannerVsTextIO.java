package ch02.ex4;

import java.util.Scanner;
import textio.TextIO;

public class ScannerVsTextIO {
    public static void main(String[] args) {
        System.out.println("=== Scanner vs TextIO 비교 ===");

        // Scanner 사용
        System.out.println("\n[Scanner 사용]");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Scanner - 숫자 입력 (문자 입력시 오류): ");
        try {
            int num1 = scanner.nextInt();
            System.out.println("입력된 숫자: " + num1);
        } catch (Exception e) {
            System.out.println("오류 발생! Scanner는 재입력을 요구하지 않습니다.");
            scanner.nextLine(); // 버퍼 정리
        }

        // TextIO 사용
        System.out.println("\n[TextIO 사용]");
        System.out.print("TextIO - 숫자 입력 (문자 입력시 재입력 요구): ");
        int num2 = TextIO.getlnInt();
        System.out.println("입력된 숫자: " + num2);

        // 특징 비교
        System.out.println("\n=== 특징 비교 ===");
        System.out.println("Scanner:");
        System.out.println("- Java 표준 클래스");
        System.out.println("- 오류시 예외 발생");
        System.out.println("- import java.util.Scanner 필요");

        System.out.println("\nTextIO:");
        System.out.println("- 별도 클래스 파일 필요");
        System.out.println("- 자동 오류 처리 및 재입력");
        System.out.println("- import textio.TextIO 필요");
    }
}