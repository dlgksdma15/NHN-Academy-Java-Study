package ch05.ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * protected 접근 제어자의 활용을 보여주는 예제
 */
class BankAccount {
    private String accountNumber;
    protected double balance;  // 서브클래스에서 접근 가능
    protected List<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        // TODO 14: 필드 초기화하기
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("계좌 개설: " + initialBalance + "원");
    }

    public void deposit(double amount) {
        // TODO 15: 입금 기능 구현하기
        if (amount > 0) {
            balance += amount;
            addTransaction("입금: " + amount + "원");
        }
    }

    public void withdraw(double amount) {
        // TODO 16: 출금 기능 구현하기
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("출금: " + amount + "원");
        }
    }

    protected void addTransaction(String transaction) {
        // TODO 17: 거래 내역 추가하기
        Date now = new Date();
        transactionHistory.add(now + " - " + transaction);
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        // TODO 18: 거래 내역 출력하기
        System.out.println("=== 거래 내역 ===");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// 프리미엄 계좌 - 특별 기능 추가
class PremiumAccount extends BankAccount {
    private double creditLimit;
    private double interestRate;

    public PremiumAccount(String accountNumber, double initialBalance,
                          double creditLimit, double interestRate) {
        // TODO 19: 부모 생성자 호출하고 추가 필드 초기화하기
        super(accountNumber, initialBalance);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    // 오버라이딩: 마이너스 통장 기능
    @Override
    public void withdraw(double amount) {
        // TODO 20: 신용 한도를 포함한 출금 기능 구현하기
        if (amount > 0 && amount <= balance + creditLimit) {
            balance -= amount; // protected이므로 직접 접근 가능
            addTransaction("출금: " + amount + "원 (잔액: " + balance + "원)");
            if (balance < 0) {
                addTransaction("신용 한도 사용 중: " + Math.abs(balance) + "원");
            }
        } else {
            System.out.println("출금 한도 초과!");
        }
    }

    // 새로운 기능: 이자 지급
    public void applyInterest() {
        // TODO 21: 이자 지급 기능 구현하기
        if (balance > 0) {
            double interest = balance * (interestRate / 100);
            balance += interest;
            addTransaction("이자 지급: " + interest + "원");
        }
    }

    // 새로운 기능: VIP 혜택
    public void applyVIPBenefit() {
        // TODO 22: VIP 혜택금 지급하기
        balance += 10000;
        addTransaction("VIP 혜택금 지급: 10000원");
    }
}

// 테스트
public class BankAccountTest {
    public static void main(String[] args) {
        // TODO 23: 일반 계좌와 프리미엄 계좌 생성하기
        BankAccount normalAccount = new BankAccount("1234", 100000);
        PremiumAccount premiumAccount = new PremiumAccount("5678", 100000, 50000, 2.5);

        // TODO 24: 일반 계좌 테스트하기
        System.out.println("=== 일반 계좌 테스트 ===");
        normalAccount.deposit(50000);  // 50000원 입금
        normalAccount.withdraw(30000); // 30000원 출금
        normalAccount.withdraw(200000); // 200000원 출금 시도 (잔액 부족)
        System.out.println("일반 계좌 잔액: " + normalAccount.getBalance() + "원");
        System.out.println();

        // TODO 25: 프리미엄 계좌 테스트하기
        System.out.println("=== 프리미엄 계좌 테스트 ===");
        premiumAccount.deposit(50000);     // 50000원 입금
        premiumAccount.withdraw(170000);   // 170000원 출금(신용한도 사용)
        premiumAccount.applyInterest();    // 이자 지급
        premiumAccount.applyVIPBenefit();  // VIP 혜택 적용
        System.out.println("프리미엄 계좌 잔액: " + premiumAccount.getBalance() + "원");
        System.out.println();

        // TODO 26: 프리미엄 계좌 거래 내역 출력하기
        premiumAccount.printTransactionHistory();
    }
}