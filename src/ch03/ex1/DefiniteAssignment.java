package ch03.ex1;

public class DefiniteAssignment {
    public static void main(String[] args) {
        int x = 5;
        int y;  // 선언만 하고 초기화하지 않음

        // 올바른 예: else가 있어서 y가 반드시 값을 가짐
        if (x > 0) {
            y = 1;
        } else {
            y = -1;
        }
        System.out.println("y = " + y);  // OK

        // 변수 z의 조건부 초기화
        int z;
        if (x > 0 && x < 10) {
            z = x * 2;
        } else if (x >= 10) {
            z = x + 5;
        } else {
            z = 0;
        }
        System.out.println("z = " + z);  // OK - 모든 경우 처리됨
    }
}