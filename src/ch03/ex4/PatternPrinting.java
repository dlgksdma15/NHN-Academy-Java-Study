package ch03.ex4;

public class PatternPrinting {
    public static void main(String[] args) {
        // 패턴 1: 직각삼각형
        System.out.println("=== 패턴 1: 직각삼각형 ===");

        // TODO: 직각삼각형 패턴
        // 힌트:
        // 1. i를 1부터 5까지 반복 (줄 수)
        // 2. 각 줄에서 j를 1부터 i까지 반복
        // 3. "* " 출력
        // 4. 줄바꿈

        // 여기에 코드를 작성하세요
        for(int i = 1; i <= 5; i++){
            for(int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println();

        }

        // 패턴 2: 역삼각형
        System.out.println("\n=== 패턴 2: 역삼각형 ===");

        // TODO: 역삼각형 패턴
        // 힌트:
        // 1. i를 5부터 1까지 감소시키며 반복
        // 2. 각 줄에서 j를 1부터 i까지 반복
        // 3. "* " 출력
        // 4. 줄바꿈
        for(int i = 0; i < 5;i++){
            for(int j = 5; j > i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }

        // 여기에 코드를 작성하세요

        // 패턴 3: 피라미드
        System.out.println("\n=== 패턴 3: 피라미드 ===");
        int height = 5;


        // TODO: 피라미드 패턴
        // 힌트:
        // 1. i를 1부터 height까지 반복
        // 2. 각 줄에서:
        //    - 공백을 (height - i)개 출력
        //    - 별을 (2 * i - 1)개 출력
        //    - 줄바꿈

        // 여기에 코드를 작성하세요
        for(int i = 0; i < height; i++){
            for(int j = 0; j < height - i - 1; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < 2 * i + 1; k++){
                System.out.print("*");
            }
            System.out.println();

        }

        // 패턴 4: 다이아몬드
        System.out.println("\n=== 패턴 4: 다이아몬드 ===");
        int size = 5;

        // TODO: 다이아몬드 패턴
        // 힌트:
        // 1. 상단부: i를 1부터 size까지
        //    - 공백 (size - i)개
        //    - 별 (2 * i - 1)개
        // 2. 하단부: i를 size-1부터 1까지
        //    - 공백 (size - i)개
        //    - 별 (2 * i - 1)개

        // 여기에 코드를 작성하세요
        // 윗부분 (정삼각형)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 아랫부분 (역삼각형)
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}