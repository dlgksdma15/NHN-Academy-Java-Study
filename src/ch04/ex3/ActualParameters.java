package ch04.ex3;

public class ActualParameters {
    public static void main(String[] args) {
        System.out.println("=== 실제 매개변수 예제 ===\n");

        // 11: 리터럴 값 전달하기
        calculate(5, 10);

        // 12: 변수 전달하기
        int x = 15;
        int y = 25;
        calculate(x, y);

        // 13: 표현식 전달하기
        calculate(x + 5, y * 2);

        // 14: 메서드 반환값 전달하기
        calculate(getNumber(), getNumber());

        // 15: 복잡한 표현식 전달하기
        calculate((x + y) / 2, getNumber() * 3);
    }

    // 16: calculate 메서드 구현하기
    static void calculate(int first, int second) {
        int sum = first + second;
        int product = first * second;
        System.out.printf("%d + %d = %d, %d * %d = %d\n",
                first, second, sum, first, second, product);
    }

    // 17: getNumber 메서드 구현하기
    static int getNumber() {
        return (int) (Math.random() * 100); // 0~99 랜덤 숫자 반환
    }
}
