package ch03.ex1;

public class BlockExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        System.out.println("블록 실행 전: x = " + x + ", y = " + y);

        // TODO: 값을 교환하는 블록
        // 힌트:
        // 1. temp 변수를 선언하여 임시 저장
        // 2. x와 y의 값을 교환
        // 3. 블록이 끝나면 temp는 사용할 수 없음
        {
            int temp;
            temp = x;
            x = y;
            y = temp;
        }
        // temp는 여기서 사용할 수 없음

        System.out.println("블록 실행 후: x = " + x + ", y = " + y);
    }
}
