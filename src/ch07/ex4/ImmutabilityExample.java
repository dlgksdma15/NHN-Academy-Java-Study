package ch07.ex4;

import java.util.ArrayList;
import java.util.List;

public class ImmutabilityExample {
    record Transaction(String id, String accountNumber, String type, double amount, double balanceAfter, String timestamp) {}

    record AccountState(String accountNumber, double balance) {
        public AccountState deposit(double amount) {
            return new AccountState(accountNumber, balance + amount);
        }
        public AccountState withdraw(double amount) {
            if (balance < amount) throw new IllegalArgumentException("잔액 부족");
            return new AccountState(accountNumber, balance - amount);
        }
    }

    static class TransactionProcessor {
        private List<Transaction> transactions = new ArrayList<>();
        private int transactionId = 1;

        public AccountState processDeposit(AccountState account, double amount) {
            AccountState newState = account.deposit(amount);
            transactions.add(new Transaction("TXN" + transactionId++, account.accountNumber(), "입금",
                    amount, newState.balance(), java.time.LocalDateTime.now().toString()));
            return newState;
        }

        public AccountState processWithdrawal(AccountState account, double amount) {
            AccountState newState = account.withdraw(amount);
            transactions.add(new Transaction("TXN" + transactionId++, account.accountNumber(), "출금",
                    amount, newState.balance(), java.time.LocalDateTime.now().toString()));
            return newState;
        }

        public List<Transaction> getTransactionHistory(String accountNumber) {
            return transactions.stream()
                    .filter(t -> t.accountNumber().equals(accountNumber))
                    .toList();
        }
    }

    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();
        AccountState account = new AccountState("123-456-789", 100000);
        System.out.println("초기 상태: " + account);

        account = processor.processDeposit(account, 50000);
        System.out.println("입금 후: " + account);

        account = processor.processWithdrawal(account, 30000);
        System.out.println("출금 후: " + account);

        account = processor.processDeposit(account, 20000);
        System.out.println("입금 후: " + account);

        System.out.println("\n=== 거래 내역 ===");
        for (Transaction txn : processor.getTransactionHistory("123-456-789")) {
            System.out.printf("%s | %s | %,.0f원 | 잔액: %,.0f원\n",
                    txn.id(), txn.type(), txn.amount(), txn.balanceAfter());
        }
    }
}