package ch09.ex1;

public class FactorialExample {

    /**
     * 재귀를 사용한 팩토리얼 계산
     * n! = n × (n-1) × (n-2) × ... × 1
     */
    public static long factorial(int n) {
        // TODO 1: 입력 검증 - n이 음수인 경우 IllegalArgumentException 던지기
        if(n < 0){
            throw new IllegalArgumentException("음수가 올 수 없습니다.");
        }
        // TODO 2: 기저 사례 구현
        // 힌트: 0! = 1, 1! = 1
        if(n <= 1){
            return 1;
        }
        // TODO 3: 재귀 사례 구현
        // 힌트: n! = n × (n-1)!
        return n * factorial(n - 1); // 임시 반환값
    }

    /**
     * 재귀 과정을 시각화하는 팩토리얼
     */
    public static long factorialWithTrace(int n, String indent) {
        System.out.println(indent + "factorial(" + n + ") 계산 시작");
        //factorial(4) = 4 × 6 = 24
        // TODO: 기저 사례와 재귀 사례를 구현하면서 각 단계를 출력
        if(n < 0){
            throw new IllegalArgumentException();
        }
        if(n <= 1){
            return 1;
        }
        int total = 0;
        for(int i = n; i > 0; i--){
            if(i != 1){
                System.out.print(i + " x ");
            }
            total += factorial(n - 1);
        }
        System.out.println("1 = " +  total);
        return 0; // 임시 반환값
    }

    public static void main(String[] args) {
        System.out.println("=== 팩토리얼 예제 ===");
        factorial(0);
        factorial(1);
        factorial(2);
        factorial(3);
        factorial(4);
        factorial(5);

        // 실행 결과:
        // 0! = 1
        // 1! = 1
        // 2! = 2
        // 3! = 6
        // 4! = 24
        // 5! = 120

        System.out.println("\n=== 재귀 과정 추적 ===");

        // factorial(4) 계산 시작
        //   factorial(3) 계산 시작
        //     factorial(2) 계산 시작
        //       factorial(1) 계산 시작
        //       기저 사례: factorial(1) = 1
        //     factorial(2) = 2 × 1 = 2
        //   factorial(3) = 3 × 2 = 6
        // factorial(4) = 4 × 6 = 24
        factorialWithTrace(5,"");
        factorialWithTrace(4,"");
    }
}