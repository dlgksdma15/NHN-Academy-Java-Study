package ch02.ex2;

public class CharAndBoolean {
    public static void main(String[] args) {
        // TODO: char 타입 변수들을 선언하고 값을 할당하세요
        // 힌트:
        char grade = 'A';
        char digit = '7';
        char space = ' ';
        char newline = '\n';
        char tab = '\t';
        char backslash = '\\';
        char quote = '\'';
        char unicodeChar = '\u0041';

        // TODO: char 변수들을 사용하여 출력하세요
        // 힌트:
        System.out.println("성적: " + grade);
        System.out.println("특수문자 예제:");
        System.out.println("탭   문자");
        System.out.println("줄바꿈\n문자");
        System.out.println("유니코드: " + grade);

        // TODO: boolean 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        boolean isStudent = true;
        boolean hasLicense = false;

        // TODO: 나이를 기반으로 성인 여부를 판단하세요
        // 힌트:
        int age = 20;
        boolean isAdult = age >= 18;

        // TODO: boolean 값들을 출력하세요
        // 힌트:
        System.out.println("\n논리값 예제:");
        System.out.println("학생입니까? " + isStudent);
        System.out.println("성인입니까? " + isAdult);

        // TODO: 논리 연산을 수행하고 결과를 출력하세요
        // 힌트:
        boolean canDrive = isAdult && hasLicense;
        System.out.println("운전 가능? " + canDrive);

        // 여기에 코드를 작성하세요
    }
}