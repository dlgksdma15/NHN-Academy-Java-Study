package ch02.ex2;

public class StringLiterals {
    public static void main(String[] args) {
        String greeting = "Hello, World!";
        String name = "Java Programming";
        String empty = "";

        String quoted = "그가 말했다: \"안녕하세요!\"";
        String path = "C:\\Users\\Documents\\file.txt";
        String multiline = "첫 번째 줄\n두 번째 줄\n세 번째 줄";
        String tabbed = "이름\t나이\t성적\n홍길동\t20\tA";

        System.out.println(greeting);
        System.out.println(quoted);
        System.out.println("파일 경로: " + path);
        System.out.println("\n여러 줄 텍스트:");
        System.out.println(multiline);
        System.out.println("\n탭으로 정렬:");
        System.out.println(tabbed);

        String firstName = "홍";
        String lastName = "길동";
        String fullName = firstName + lastName;
        System.out.println("\n전체 이름: " + fullName);
    }
}