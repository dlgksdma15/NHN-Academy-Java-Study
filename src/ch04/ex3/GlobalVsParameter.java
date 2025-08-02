package ch04.ex3;

public class GlobalVsParameter {
    // 92: 전역 변수 방식
    static int globalBalance = 1000;

    public static void main(String[] args) {
        System.out.println("=== 전역 변수 vs 매개변수 비교 ===\n");

        // 93: 전역 변수 방식 테스트
        System.out.println("1. 전역 변수 방식:");
        System.out.println("초기 전역 잔액: " + globalBalance);
        depositGlobal(500);   // +500
        withdrawGlobal(200);  // -200
        System.out.println("최종 전역 잔액: " + globalBalance);

        // 94: 매개변수 방식 테스트
        System.out.println("\n2. 매개변수 방식:");
        int balance = 1000;
        System.out.println("초기 잔액: " + balance);
        balance = depositParameter(balance, 500);   // +500
        balance = withdrawParameter(balance, 200);  // -200
        System.out.println("최종 잔액: " + balance);

        // 95: 부작용 시연
        System.out.println("\n=== 비교 ===");
        demonstrateSideEffects();
    }

    // 96: 전역 변수 방식 메서드
    static void depositGlobal(int amount) {
        globalBalance += amount;
        System.out.println(amount + "원 입금 (전역): 현재 잔액 = " + globalBalance);
    }

    static void withdrawGlobal(int amount) {
        if (amount > globalBalance) {
            System.out.println("잔액 부족 (전역)");
        } else {
            globalBalance -= amount;
            System.out.println(amount + "원 출금 (전역): 현재 잔액 = " + globalBalance);
        }
    }

    // 97: 매개변수 방식 메서드
    static int depositParameter(int balance, int amount) {
        balance += amount;
        System.out.println(amount + "원 입금 (매개변수): 현재 잔액 = " + balance);
        return balance;
    }

    static int withdrawParameter(int balance, int amount) {
        if (amount > balance) {
            System.out.println("잔액 부족 (매개변수)");
        } else {
            balance -= amount;
            System.out.println(amount + "원 출금 (매개변수): 현재 잔액 = " + balance);
        }
        return balance;
    }

    // 98: 부작용 시연
    static void demonstrateSideEffects() {
        System.out.println("전역 변수는 모든 메서드에서 값이 변할 수 있어 예측이 어려움");
        System.out.println("매개변수 방식은 각 메서드 호출 시 값이 전달되고 반환되어 명시적");
        someComplexOperation();
    }

    static void someComplexOperation() {
        System.out.println("복잡한 연산 중 전역 변수 값 변경 → 다른 코드에 영향 미침 (부작용 발생 가능)");
    }
}
