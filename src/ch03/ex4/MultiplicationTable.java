package ch03.ex4;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("=== 구구단 표 (1-12) ===\n");

        // 헤더 출력
        System.out.print("    ");
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        // 구분선
        System.out.print("    ");
        for (int i = 1; i <= 12; i++) {
            System.out.print("----");
        }
        System.out.println();

        // TODO: 구구단 표 본문
        // 힌트:
        // 1. row를 1부터 12까지 반복 (외부 루프)
        // 2. 각 row에 대해:
        //    - row 번호 출력 (형식: "%2d |")
        //    - col을 1부터 12까지 반복 (내부 루프)
        //    - row * col 출력 (형식: "%4d")
        //    - 줄바꿈

        // 여기에 코드를 작성하세요
        for(int i = 1; i <= 12; i++){
            System.out.printf("%2d | ", i);

            for(int j = 1; j <= 12; j++){
                System.out.printf("%3d\t", i * j);
                if(j == 12){
                    System.out.println();
                }
            }
        }
    }
}