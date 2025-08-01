package ch02.ex5;

public class IncrementPractical {
    public static void main(String[] args) {
        // 카운터로 사용
        System.out.println("=== 방문자 카운터 ===");
        int visitorCount = 0;

        System.out.println("현재 방문자: " + visitorCount);
        visitorCount++;  // 새 방문자
        System.out.println("방문자 1 입장: " + visitorCount);
        visitorCount++;  // 또 새 방문자
        System.out.println("방문자 2 입장: " + visitorCount);

        // 배열 인덱스로 사용
        System.out.println("\n=== 배열 순회 ===");
        int[] scores = {85, 90, 78, 92, 88};
        int index = 0;

        System.out.println("점수 목록:");
        System.out.println("학생 " + (index + 1) + ": " + scores[index++]);
        System.out.println("학생 " + (index + 1) + ": " + scores[index++]);
        System.out.println("학생 " + (index + 1) + ": " + scores[index++]);

        // 문자 증가
        System.out.println("\n=== 문자 증가 ===");
        char ch = 'A';
        System.out.println("현재 문자: " + ch);
        ch++;
        System.out.println("다음 문자: " + ch);  // 'B'

        // 알파벳 출력
        System.out.print("알파벳: ");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}