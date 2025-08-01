package ch03.ex1;

public class ScopeExample {
    public static void main(String[] args) {
        int outer = 100;  // 외부 변수

        System.out.println("외부 변수: " + outer); // 100

        {
            // 내부 블록
            int inner = 200;  // 내부 변수
            System.out.println("블록 내부에서:");
            System.out.println("  outer = " + outer);  // 접근 가능
            System.out.println("  inner = " + inner);  // 접근 가능

            // 외부 변수 수정
            outer = 150;
        }

        System.out.println("블록 밖에서:");
        System.out.println("  outer = " + outer);  // 수정된 값
        // System.out.println("  inner = " + inner);  // 오류! inner는 접근 불가
    }
}