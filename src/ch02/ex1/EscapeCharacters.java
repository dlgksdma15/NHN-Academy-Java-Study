package ch02.ex1;

public class EscapeCharacters {
    public static void main(String[] args) {
        // TODO: 이스케이프 문자를 사용하여 특수 문자를 출력하세요
        // 힌트:
        // 1. 큰따옴표 출력: \"를 사용
        //    - "그가 말했다: \"안녕하세요!\""
        // 2. 역슬래시 출력: \\를 사용
        //    - "파일 경로: C:\\Program Files\\Java"
        // 3. 탭 문자로 표 만들기: \t 사용
        //    - 헤더: "이름\t나이\t직업"
        //    - 데이터: "홍길동\t30\t개발자"
        //    - 데이터: "김영희\t25\t디자이너"
        // 4. 줄바꿈 문자: \n 사용
        //    - "첫 줄\n두 번째 줄\n세 번째 줄"
        // 5. 작은따옴표:
        //    - "It's a beautiful day!" (이스케이프 없이)
        //    - "It\'s a beautiful day!" (이스케이프 사용)

        // 여기에 코드를 작성하세요
        System.out.println("그가 말했다: \"안녕하세요!\"");
        System.out.println("파일 경로: C:\\Program Files\\Java");
        System.out.println("이름\t\t나이\t\t직업");
        System.out.println("홍길동\t30\t\t개발자");
        System.out.println("김영희\t25\t\t디자이너");
        System.out.println("첫 줄\n두 번째 줄\n세 번째 줄\n");
        System.out.println("It's a beautiful day!");
        System.out.println("It\'s a beautiful day!");
    }
}