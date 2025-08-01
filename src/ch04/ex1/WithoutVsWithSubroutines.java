package ch04.ex1;

public class WithoutVsWithSubroutines {
    public static void main(String[] args) {
        System.out.println("=== 서브루틴 없이 vs 서브루틴 사용 ===\n");

        // TODO 21: 서브루틴 없이 코드 작성하기
        System.out.println("방법 1: 서브루틴 없이");
        // 두 개의 동일한 10x5 사각형을 직접 출력해보세요 (코드 중복)'
        drawRectangle();

        System.out.println("\n방법 2: 서브루틴 사용");
        // TODO 22: 서브루틴을 사용하여 간단하게 작성하기
        // drawRectangle() 메서드를 두 번 호출해보세요
        drawRectangle();
        drawRectangle();

        System.out.println("\n방법 3: 매개변수화된 서브루틴");
        // TODO 23: 매개변수화된 서브루틴 사용하기
        // 다양한 크기의 사각형을 그려보세요
        drawCustomRectangle(5,5);
        drawCustomRectangle(5,4);
        drawCustomRectangle(10,6);
    }

    // TODO 24: 고정된 크기의 사각형 그리기 메서드 구현하기
    public static void drawRectangle() {
        // 10x5 크기의 사각형을 그리는 코드를 작성하세요
        int width = 10;
        int height = 5;
        for(int i = 0; i < width; i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i = 0; i < height - 2; i++){
            System.out.print("*");
            for(int j = 0; j < width - 2; j++){
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for(int i = 0; i < width; i++){
            System.out.print("*");
        }
        System.out.println();
    }

    // TODO 25: 크기를 조절할 수 있는 사각형 그리기 메서드 구현하기
    public static void drawCustomRectangle(int width, int height) {
        // 매개변수로 받은 크기의 사각형을 그리는 코드를 작성하세요
        // 힌트: 상단 테두리, 중간 부분, 하단 테두리로 나누어 생각해보세요

        for(int i = 0; i < width; i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i = 0; i < height - 2; i++){
            System.out.print("*");
            for(int j = 0; j < width - 2; j++){
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for(int i = 0; i < width; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}