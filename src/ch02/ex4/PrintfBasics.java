package ch02.ex4;

public class PrintfBasics {
    public static void main(String[] args) {
        // TODO: printf를 사용하여 다양한 타입을 서식에 맞게 출력하세요
        int intValue = 42;
        double doubleValue = 3.14159;
        String stringValue = "Java";
        char charValue = 'A';
        boolean boolValue = true;

        System.out.printf("정수: %d\n", intValue);
        System.out.printf("실수: %.2f\n", doubleValue);
        System.out.printf("문자열: %s\n", stringValue);
        System.out.printf("문자: %c\n", charValue);
        System.out.printf("불린: %b\n", boolValue);

        System.out.printf("\n%s 언어의 버전 %d는 원주율 %.2f를 지원합니다.\n", stringValue, intValue, doubleValue);

        System.out.println("백분율 출력: 50%");
        System.out.println("탭 문자: Hello \t World");
        System.out.println("따옴표: \"Java\"");

    }
}
