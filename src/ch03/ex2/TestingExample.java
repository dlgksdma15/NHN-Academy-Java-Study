package ch03.ex2;

public class TestingExample {
    public static void main(String[] args) {
        System.out.println("=== 최대공약수(GCD) 계산 테스트 ===");

        // 테스트 케이스
        int[][] testCases = {
                {48, 18, 6},    // a, b, 예상 GCD
                {100, 50, 50},
                {17, 5, 1},     // 서로소
                {0, 5, 5},      // 특수 케이스
                {7, 7, 7}       // 같은 수
        };

        // 각 테스트 케이스 실행
        int testNumber = 1;
        while (testNumber <= testCases.length) {
            int a = testCases[testNumber - 1][0];
            int b = testCases[testNumber - 1][1];
            int expected = testCases[testNumber - 1][2];

            // TODO: 유클리드 호제법으로 GCD 계산
            int x = a;
            int y = b;

            // 힌트:
            // 1. x가 0이면 GCD는 y
            // 2. y가 0이 아닌 동안:
            //    - temp = y
            //    - y = x % y (나머지)
            //    - x = temp
            // 3. 최종적으로 x가 GCD

            // 여기에 코드를 작성하세요
            int result = x;
            if(x == 0){ // {48,18,6}
                result = y;
            }else{
                while (y != 0){
                    int temp = y; // temp = 18, temp = 12, temp = 6
                    y = x % y; // y = 12, y = 6, y = 0
                    x = temp; // x = 18, x = 12, x = 6
                }
                result = x;
            }

            // 결과 검증
            System.out.print("테스트 " + testNumber + ": ");
            System.out.print("GCD(" + a + ", " + b + ") = " + result);

            if (result == expected) { // 18 == 6
                System.out.println(" ✅ 통과");
            } else {
                System.out.println(" ❌ 실패 (예상: " + expected + ")");
            }

            testNumber = testNumber + 1;
        }
    }
}