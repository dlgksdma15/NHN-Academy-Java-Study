package ch02.ex4;

import textio.TextIO;

public class ReadFromFile {
    public static void main(String[] args) {
        // TODO: TextIO를 사용하여 파일을 읽어오는 프로그램을 만드세요

        System.out.println("=== 파일 읽기 프로그램 ===");
        System.out.print("읽을 파일 이름: ");
        String fileName = TextIO.getln();

        try {
            TextIO.readFile(fileName); // 파일 읽기 모드 전환
            System.out.println("\n=== 파일 내용 ===");
            int lineNumber = 1;

            while (!TextIO.eof()) {
                String line = TextIO.getln();
                System.out.printf("%3d: %s%n", lineNumber++, line);
            }

            System.out.println("\n파일 읽기 완료!");
            TextIO.readStandardInput(); // 표준 입력 복귀

        } catch (IllegalArgumentException e) {
            System.out.println("❌ 파일을 찾을 수 없습니다: " + fileName);
        }
    }
}
