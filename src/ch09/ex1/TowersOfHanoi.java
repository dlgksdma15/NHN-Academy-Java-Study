package ch09.ex1;

public class TowersOfHanoi {

    private static int moveCount = 0;

    /**
     * 기본 하노이의 탑 해결
     */
    public static void hanoi(int n, char from, char to, char aux) {
        // TODO 1: 기저 사례 - n이 1인 경우
        if (n == 1) {
            moveCount++;
            System.out.println("이동 " + moveCount + ": 원반 1을 " + from + "에서 " + to + "로");
            return;
        }

        // TODO 2: 재귀 사례 - 3단계로 해결
        // 단계 1: 위쪽 n-1개를 from에서 aux로 이동 (to를 임시로 사용)
        hanoi(n - 1, from, aux, to);

        // 단계 2: 가장 큰 원반(n번)을 from에서 to로 이동
        moveCount++;
        System.out.println("이동 " + moveCount + ": 원반 " + n + "을 " + from + "에서 " + to + "로");

        // 단계 3: aux에 있는 n-1개를 to로 이동 (from을 임시로 사용)
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        System.out.println("=== 하노이의 탑 예제 ===");

        int numberOfDisks = 3;
        hanoi(numberOfDisks, 'A', 'C', 'B');

        System.out.println("총 " + moveCount + "번의 이동 (이론값: " + (int)(Math.pow(2, numberOfDisks) - 1) + ")");
    }
}
