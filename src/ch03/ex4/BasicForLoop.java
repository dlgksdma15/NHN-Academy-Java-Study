package ch03.ex4;
public class BasicForLoop {
    public static void main(String[] args) {
        // 1부터 10까지 출력
        System.out.println("1부터 10까지:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // 줄바꿈

        // 0부터 9까지 출력 (프로그래머 스타일)
        System.out.println("\n0부터 9까지:");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 10부터 1까지 역순
        System.out.println("\n10부터 1까지:");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
