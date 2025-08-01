package ch02.ex3;

public class StringBasics {
    public static void main(String[] args) {
        // TODO: 문자열 선언하고 기본 정보를 출력하세요
        // 힌트:
        // 1. str = "Hello, Java Programming!" 선언
        // 2. 문자열과 길이 출력 (str.length() 사용)

        // TODO: 문자 접근 예제를 출력하세요
        // 힌트:
        // 1. "\n문자 접근:" 출력
        // 2. 첫 번째 문자: str.charAt(0)
        // 3. 마지막 문자: str.charAt(str.length() - 1)

        // TODO: 모든 문자를 한 글자씩 출력하세요
        // 힌트:
        // 1. "한 글자씩: " 출력 (print 사용, 줄바꿈 없이)
        // 2. for 루프로 str.charAt(i) 공백과 함께 출력
        // 3. 마지막에 줄바꿈 출력

        // TODO: 부분 문자열 예제를 출력하세요
        // 힌트:
        // 1. "\n부분 문자엱:" 출력
        // 2. substring(0, 5) 결과 출력
        // 3. substring(7) 결과 출력
        // 4. substring(7, 11) 결과 출력

        // 여기에 코드를 작성하세요
        String str = "Hello, Java Programming!";
        System.out.println(str);
        System.out.println("길이: " + str.length());
        System.out.println("\n문자 접근:");
        System.out.println("첫 번째 문자: str.charAt(0)");
        System.out.println("마지막 문자: str.charAt(str.length() - 1)");

        System.out.print("한 글자씩: ");
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i) + " ");
        }

        System.out.println("\n\n부분 문자열:");
        System.out.println(str.substring(0, 5));
        System.out.println(str.substring(7));
        System.out.println(str.substring(7,11));
    }
}