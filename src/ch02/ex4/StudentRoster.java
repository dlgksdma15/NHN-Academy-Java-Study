package ch02.ex4;

import textio.TextIO;


public class StudentRoster {
    public static void main(String[] args) {
        System.out.println("=== 학생 명부 관리 시스템 ===");

        // 메뉴 선택
        System.out.println("1. 새 학생 추가");
        System.out.println("2. 명부 보기");
        System.out.print("선택: ");
        int choice = TextIO.getlnInt();

        if (choice == 1) {
            // 학생 정보 입력
            System.out.print("학번: ");
            int id = TextIO.getlnInt();
            System.out.print("이름: ");
            String name = TextIO.getln();
            System.out.print("학과: ");
            String major = TextIO.getln();
            System.out.print("학년: ");
            int year = TextIO.getlnInt();

            // 파일에 추가 (append 모드)
            TextIO.writeFile("students.txt");
            TextIO.putf("%d,%s,%s,%d%n", id, name, major, year);

            TextIO.writeStandardOutput();
            System.out.println("학생 정보가 추가되었습니다.");

        } else if (choice == 2) {
            // 명부 읽기
            try {
                TextIO.readFile("students.txt");

                System.out.println("\n=== 학생 명부 ===");
                System.out.printf("%-10s %-15s %-20s %s%n",
                        "학번", "이름", "학과", "학년");
                System.out.println("─".repeat(55));

                while (!TextIO.eof()) {
                    String line = TextIO.getln();
                    // 간단한 파싱 (실제로는 더 정교한 방법 필요)
                    System.out.println(line);
                }

                TextIO.readStandardInput();
            } catch (IllegalArgumentException e) {
                System.out.println("명부 파일이 없습니다.");
            }
        }
    }
}