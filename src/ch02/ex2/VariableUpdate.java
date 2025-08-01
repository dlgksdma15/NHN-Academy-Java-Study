package ch02.ex2;

public class VariableUpdate {
    public static void main(String[] args) {
        // TODO: score 변수를 0으로 초기화하고 출력하세요
        int score = 0;
        System.out.println("초기점수 = " + score);

        // TODO: score를 10으로 변경하고 출력하세요
        score = 10;
        System.out.println("첫 번쨰 점수: " + score);
        score += 5;
        System.out.println("두 번쨰 점수: " + score);

        // TODO: score를 2배로 만들고 출력하세요
        score = score * 2;
        System.out.println("최종 점수: " + score);

        // TODO: 계좌 잔액 시뮬레이션을 구현하세요
        // 힌트:
        double balance = 1000.0;
        double interestRate = 0.05;
        System.out.println("\n계좌 잔액 변화:");

        // 4. 초기 잔액 출력
        System.out.println("초기 잔액: $" + balance);
        double interest = balance * interestRate;
        balance = balance + interest;
        System.out.println("이자 후 잔액: $" + balance);

        double withdrawal = 200.0;
        balance = balance - withdrawal;
        // 10. 출금 후 잔액 출력
        System.out.println("출금 후 잔액: $" + balance);

        // 여기에 코드를 작성하세요
    }
}