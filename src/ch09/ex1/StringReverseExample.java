package ch09.ex1;

public class StringReverseExample {

    /**
     * 재귀를 사용한 문자열 뒤집기
     */
    public static String reverseString(String str) {
        // TODO 1: 기저 사례 구현
        // 힌트: 빈 문자열 또는 한 글자인 경우 그대로 반환
        if(str == "" || str.length() == 1){
            return str;
        }
        // TODO 2: 재귀 사례 구현
        // 힌트: 첫 글자를 맨 뒤로 보내고, 나머지는 재귀적으로 뒤집기
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i >= 0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString(); // 임시 반환값
    }

    /**
     * 회문(palindrome) 검사
     */
    public static boolean isPalindrome(String str) {
        // 전처리: 소문자 변환, 공백/특수문자 제거
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isPalindromeHelper(cleaned, 0, cleaned.length() - 1);
    }

    private static boolean isPalindromeHelper(String str, int left, int right) {
        // TODO 1: 기저 사례 - 포인터가 만나거나 교차
        if(left >= right){
            return false;
        }
        // TODO 2: 양 끝 문자가 다르면 false
        if(str.charAt(left) != str.charAt(right)){
            return false;
        }
        // TODO 3: 재귀 호출 - 한 칸씩 안쪽으로
        return isPalindromeHelper(str,left + 1,right - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== 문자열 뒤집기 예제 ===");

        // 실행 결과:
        // "hello" → "olleh"
        // "Java" → "avaJ"
        // "recursion" → "noisrucer"
        // "a" → "a"
        // "" → ""
        System.out.println(reverseString("hello"));
        System.out.println(reverseString("Java"));
        System.out.println(reverseString("recursion"));
        System.out.println(reverseString("a"));
        System.out.println(reverseString(""));

        System.out.println("\n=== 회문 검사 ===");
        // "racecar" → 회문
        // "A man a plan a canal Panama" → 회문
        // "race a car" → 회문 아님
        // "hello" → 회문 아님

        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("A man a plan a canal Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("hello"));
    }
}