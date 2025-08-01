package ch02.ex2;

public class BankAccount {
    public static void main(String[] args) {
        // TODO: 계좌 정보를 저장할 변수들을 선언하고 초기화하세요
        String accountHolder = "홍길동";
        String accountNumber = "1234-5678-9012";
        double balance = 10000.0;
        double interestRate = 0.02;
        boolean isActive = true;

        // TODO: 계좌 정보를 출력하세요
        System.out.println("=== 은행 계좌 정보 ===");
        System.out.println("예금주: " + accountHolder);
        System.out.println("계좌번호: " + accountNumber);
        System.out.println("현재 잔액: " + balance);
        System.out.println("이자율: " + (interestRate * 100) + "%");
        System.out.println("계좌 상태: " + (isActive ? "활성" : "비활성"));

        // TODO: 거래 시뮬레이션을 구현하세요
        System.out.println("\n=== 거래 내역 ===");
        double deposit = 2500.0;
        balance += deposit;
        System.out.println("입금: " + deposit);
        System.out.println("입금 후 잔액: " + balance);

        // TODO: 출금 처리를 구현하세요
        double withdrawal = 1000.0;
        if (balance >= withdrawal) {
            balance -= withdrawal;
            System.out.println("출금: " + withdrawal);
            System.out.println("출금 후 잔액: " + balance);
        } else {
            System.out.println("잔액 부족!");
        }

        // TODO: 월 이자를 계산하고 적용하세요
        double monthlyRate = interestRate / 12;
        double monthlyInterest = balance * monthlyRate;
        balance += monthlyInterest;
        System.out.println("\n=== 월 이자 적용 ===");
        System.out.println("월 이자율: " + (monthlyRate * 100) + "%");
        System.out.println("이자: " + monthlyInterest);
        System.out.println("최종 잔액: " + balance);
    }
}