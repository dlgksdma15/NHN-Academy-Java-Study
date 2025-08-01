package ch02.ex4;

import textio.TextIO;

public class MultipleInputs {
    public static void main(String[] args) {
        // TODO: TextIO의 getln과 get의 차이를 활용하여 좌표 입력 프로그램을 만드세요
        System.out.println("=== 좌표 입력 프로그램 ===\n");

        // 방법 1: 줄마다 하나씩 입력
        System.out.println("[방법 1] 각 값을 별도의 줄에 입력:");
        System.out.print("x 좌표: ");
        int x1 = TextIO.getlnInt();

        System.out.print("y 좌표: ");
        int y1 = TextIO.getlnInt();

        System.out.printf("입력된 좌표: (%d, %d)\n\n", x1, y1);

        // getln() 한 줄 입력 후, split으로 처리
        System.out.print("x y 좌표 입력: ");
        String[] coords2 = TextIO.getln().split("\\s+");
        int x2 = Integer.parseInt(coords2[0]);
        int y2 = Integer.parseInt(coords2[1]);

        System.out.printf("입력된 좌표: (%d, %d)\n\n", x2, y2);

        // 방법 3 - 3D 좌표
        System.out.println("[방법 3] 3차원 좌표 입력:");
        System.out.print("x y z 좌표 입력: ");
        String[] coords3 = TextIO.getln().split("\\s+");
        int x3 = Integer.parseInt(coords3[0]);
        int y3 = Integer.parseInt(coords3[1]);
        int z3 = Integer.parseInt(coords3[2]);

        TextIO.getln(); // 줄 정리

        System.out.printf("입력된 3D 좌표: (%d, %d, %d)\n\n", x3, y3, z3);

        // 거리 계산
        double dist2D = Math.sqrt(x2 * x2 + y2 * y2);
        double dist3D = Math.sqrt(x3 * x3 + y3 * y3 + z3 * z3);

        System.out.printf("2D 원점으로부터의 거리: %.2f\n", dist2D);
        System.out.printf("3D 원점으로부터의 거리: %.2f\n", dist3D);
    }
}
