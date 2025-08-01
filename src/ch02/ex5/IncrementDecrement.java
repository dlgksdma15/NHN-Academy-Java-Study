package ch02.ex5;

public class IncrementDecrement {
    public static void main(String[] args) {
        // TODO: 전위/후위 증가/감소 연산자의 차이를 보여주세요
        System.out.println("=== 증가/감소 연산자 ===");

        // 후위 증가: 사용한 뒤 증가
        int x = 5;
        System.out.println("\n후위 증가 x++:");
        System.out.println("x = 5");
        System.out.println("x++ 결과: " + (x++)); // 출력 후 증가
        System.out.println("x = " + x);         // 증가된 값 확인

        // 전위 증가: 증가한 후 사용
        x = 5;
        System.out.println("\n전위 증가 ++x:");
        System.out.println("x = 5");
        System.out.println("++x 결과: " + (++x)); // 먼저 증가 후 출력
        System.out.println("x = " + x);

        // 후위 감소: 사용한 뒤 감소
        x = 5;
        System.out.println("\n후위 감소 x--");
        System.out.println("x = 5");
        System.out.println("x-- = " + (x--)); // 출력 후 감소
        System.out.println("x 값: " + x);

        // 전위 감소: 감소한 후 사용
        x = 5;
        System.out.println("\n전위 감소 --x");
        System.out.println("x = 5");
        System.out.println("--x = " + (--x)); // 먼저 감소 후 출력
        System.out.println("x 값: " + x);
    }
}
