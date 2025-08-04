package ch05.ex2;

class BankAccount {
    // TODO 11: private 인스턴스 변수 선언
    private String accountNumber;
    private String ownerName;
    private double balance;
    private String bankName;

    // TODO 12: 기본 생성자 (잔액 0원, 은행명 기본값)
    public BankAccount(String accountNumber, String ownerName) {
        // 유효성 검사
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("계좌번호는 필수 입력입니다.");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("예금주명은 필수 입력입니다.");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
        this.bankName = "Java Bank";

        System.out.printf("%s님의 계좌(%s)가 개설되었습니다.\n", ownerName, accountNumber);
    }

    // TODO 13: 초기 입금액 있는 생성자
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("계좌번호는 필수 입력입니다.");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("예금주명은 필수 입력입니다.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("초기 잔액은 0 이상이어야 합니다.");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.bankName = "Java Bank";

        System.out.printf("%s님의 계좌(%s)가 %.0f원으로 개설되었습니다.\n", ownerName, accountNumber, initialBalance);
    }

    // TODO 14: 은행명까지 지정하는 생성자
    public BankAccount(String accountNumber, String ownerName, double initialBalance, String bankName) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("계좌번호는 필수 입력입니다.");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("예금주명은 필수 입력입니다.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("초기 잔액은 0 이상이어야 합니다.");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.bankName = (bankName == null || bankName.trim().isEmpty()) ? "Java Bank" : bankName;

        System.out.printf("%s에서 %s님의 계좌(%s)가 %.0f원으로 개설되었습니다.\n", this.bankName, ownerName, accountNumber, initialBalance);
    }

    // TODO 15: getter 메서드들
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public String getBankName() {
        return bankName;
    }

    // TODO 16: 입금 메서드
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("%.0f원이 입금되었습니다. 현재 잔액: %.0f원\n", amount, balance);
        } else {
            System.out.println("입금액은 0원보다 커야 합니다.");
        }
    }

    // TODO 17: 계좌 정보 출력 메서드
    public void displayAccountInfo() {
        System.out.println("=== 계좌 정보 ===");
        System.out.println("은행: " + bankName);
        System.out.println("계좌번호: " + accountNumber);
        System.out.println("예금주: " + ownerName);
        System.out.printf("잔액: %.0f원\n", balance);
    }
}

// 사용 예제
public class BankAccountExample {
    public static void main(String[] args) {
        try {
            // TODO 19: 다양한 생성자 사용
            BankAccount account1 = new BankAccount("123-456-789", "김철수");
            BankAccount account2 = new BankAccount("987-654-321", "이영희", 100000);
            BankAccount account3 = new BankAccount("555-777-999", "박민수", 500000, "우리은행");

            // TODO 20: 계좌 정보 출력
            System.out.println("\n=== 계좌 정보 출력 ===");
            account1.displayAccountInfo();
            System.out.println();
            account2.displayAccountInfo();
            System.out.println();
            account3.displayAccountInfo();

            // TODO 21: 입금 테스트
            System.out.println("\n=== 입금 테스트 ===");
            account1.deposit(50000);

        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
