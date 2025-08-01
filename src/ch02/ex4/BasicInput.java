package ch02.ex4;

import textio.TextIO;

public class BasicInput {
    public static void main(String[] args) {
        // TODO: TextIO를 사용하여 다양한 타입의 입력을 받고 출력하세요
        System.out.println("=== 기본 정보 입력 ===");

        System.out.print("나이 입력: ");
        int age = TextIO.getlnInt();

        System.out.print("키 입력 (cm): ");
        double height = TextIO.getlnDouble();

        System.out.print("혈액형을 입력 (예: A, B, O, AB 중 한 글자): ");
        char bloodType = TextIO.getlnChar();

        System.out.print("학생인가요? (true/false): ");
        boolean isStudent = TextIO.getlnBoolean();

        System.out.print("이름을 입력하세요(성만): ");
        String name = TextIO.getWord();

        System.out.print("주소를 입력하세요: ");
        String address = TextIO.getln();

        System.out.println("\n입력 결과:");
        System.out.printf("나이: %d세\n", age);
        System.out.printf("키: %.2fcm\n", height);
        System.out.printf("혈액형: %c형\n", bloodType);
        System.out.printf("학생 여부: %b\n", isStudent);
        System.out.printf("이름: %s\n", name);
        System.out.printf("주소: %s\n", address);
    }
}
