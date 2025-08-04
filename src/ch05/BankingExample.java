package ch05;

/**
 * 은행 계좌 클래스 - 완전한 캡슐화 예제
 */
class BankAccount {
    // Private 인스턴스 변수
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String password;
    private boolean isLocked;

    // 생성자
    public BankAccount(String accountNumber, String accountHolder, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.password = password;
        this.balance = 0.0;
        this.isLocked = false;
    }

    // Getter 메서드들
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("계좌가 잠겨있습니다.");
            return 0;
        }
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    // Setter 메서드들 (제한적)
    public void setAccountHolder(String newHolder) {
        if (newHolder != null && !newHolder.trim().isEmpty()) {
            this.accountHolder = newHolder;
            System.out.println("계좌 소유자가 변경되었습니다.");
        } else {
            System.out.println("유효하지 않은 이름입니다.");
        }
    }

    // 비밀번호 변경 (기존 비밀번호 확인 필요)
    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            if (newPassword.length() >= 4) {
                this.password = newPassword;
                System.out.println("비밀번호가 변경되었습니다.");
                return true;
            } else {
                System.out.println("비밀번호는 4자 이상이어야 합니다.");
            }
        } else {
            System.out.println("기존 비밀번호가 일치하지 않습니다.");
        }
        return false;
    }

    // 입금 메서드
    public void deposit(double amount) {
        if (isLocked) {
            System.out.println("계좌가 잠겨있어 입금할 수 없습니다.");
            return;
        }

        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다. 잔액: " + balance);
        } else {
            System.out.println("입금액은 0보다 커야 합니다.");
        }
    }

    // 출금 메서드 (비밀번호 확인)
    public boolean withdraw(double amount, String password) {
        if (isLocked) {
            System.out.println("계좌가 잠겨있어 출금할 수 없습니다.");
            return false;
        }

        if (!this.password.equals(password)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다. 잔액: " + balance);
            return true;
        } else {
            System.out.println("출금액이 잘못되었거나 잔액이 부족합니다.");
            return false;
        }
    }

    // 계좌 잠금/해제
    public void lockAccount() {
        isLocked = true;
        System.out.println("계좌가 잠겼습니다.");
    }

    public void unlockAccount(String password) {
        if (this.password.equals(password)) {
            isLocked = false;
            System.out.println("계좌 잠금이 해제되었습니다.");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }
}

// 사용 예제
public class BankingExample {
    public static void main(String[] args) {
        // 계좌 생성
        BankAccount account = new BankAccount("123-456-789", "김철수", "1234");

        // 계좌 정보 확인
        System.out.println("계좌번호: " + account.getAccountNumber());
        System.out.println("예금주: " + account.getAccountHolder());
        System.out.println("잔액: " + account.getBalance());

        // 거래
        account.deposit(100000);
        account.withdraw(30000, "1234");  // 성공
        account.withdraw(20000, "0000");  // 실패 (잘못된 비밀번호)

        // 비밀번호 변경
        account.changePassword("1234", "5678");

        // 계좌 잠금
        account.lockAccount();
        account.deposit(50000);  // 실패 (계좌 잠김)

        // 계좌 잠금 해제
        account.unlockAccount("5678");
        account.deposit(50000);  // 성공
    }
}