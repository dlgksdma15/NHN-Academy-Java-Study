package ch03.ex4;

public class StringProcessing {
    public static void main(String[] args) {
        String text = "Hello, World!";

        // 문자열의 각 문자 출력
        System.out.println("문자열의 각 문자:");
        for (int i = 0; i < text.length(); i++) {
            System.out.println("인덱스 " + i + ": " + text.charAt(i));
        }

        // TODO: 문자열 역순 출력
        // 힌트:
        // 1. "역순: "
        // 2. i를 text.length()-1부터 0까지 감소시키며:
        //    - text.charAt(i) 출력
        System.out.print("\n역순: ");
        // 여기에 코드를 작성하세요
        for(int i = text.length() -1; i > 0; i--){
            System.out.print(text.charAt(i));
        }

        System.out.println();

        // TODO: 모음 개수 세기
        // 힌트:
        // 1. vowelCount를 0으로 초기화
        // 2. vowels = "aeiouAEIOU" 문자열 생성
        // 3. text의 각 문자에 대해:
        //    - 현재 문자가 vowels에 포함되면 vowelCount 증가
        //    - vowels.indexOf(ch) >= 0 사용

        // 여기에 코드를 작성하세요
        int vowelCount = 0;
        String vowels = "aeiouAEIOU";
        for(int i = 0; i < vowels.length() - 1; i++){
            for(int j = 0; j < text.length() - 1; j++){
                char c = text.charAt(j); // 13
                System.out.println(c);
                if(c == vowels.charAt(i)){
                    vowelCount++;
                }
            }
        }

       System.out.println("\n모음 개수: " + vowelCount);
    }
}