package ch04.ex2;

public class BankSimulation {
    // 멤버 변수들
    private static String accountHolder = "홍길동"; // 기본 이름
    private static double balance = 0.0;
    private static int transactionCount = 0;
    private static double totalDeposits = 0.0;
    private static double totalWithdrawals = 0.0;

    public static void main(String[] args) {
        System.out.println("=== 은행 계좌 시뮬레이션 ===");
        System.out.println("계좌 소유자: " + accountHolder);

        // 테스트 호출
        deposit(10000);
        withdraw(3000);
        deposit(5000);
        withdraw(15000); // 잔액 부족
        showStatistics();
    }

    // 입금
    public static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("유효하지 않은 금액입니다.");
            return;
        }
        balance += amount;
        totalDeposits += amount;
        transactionCount++;
        System.out.printf("입금 완료: %.0f원, 현재 잔액: %.0f원\n", amount, balance);
    }

    // 출금
    public static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("유효하지 않은 금액입니다.");
            return;
        }
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        balance -= amount;
        totalWithdrawals += amount;
        transactionCount++;
        System.out.printf("출금 완료: %.0f원, 현재 잔액: %.0f원\n", amount, balance);
    }

    // 잔액 조회
    public static void checkBalance() {
        System.out.printf("현재 잔액: %.0f원\n", balance);
    }

    // 통계 출력
    public static void showStatistics() {
        System.out.println("\n--- 거래 통계 ---");
        System.out.printf("총 거래 횟수: %d회\n", transactionCount);
        System.out.printf("총 입금액: %.0f원\n", totalDeposits);
        System.out.printf("총 출금액: %.0f원\n", totalWithdrawals);
        System.out.printf("현재 잔액: %.0f원\n", balance);
        if (transactionCount > 0) {
            double avg = (totalDeposits + totalWithdrawals) / transactionCount;
            System.out.printf("평균 거래액: %.0f원\n", avg);
        }
    }
}
