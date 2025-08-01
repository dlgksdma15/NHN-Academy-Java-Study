package ch02.ex5;

public class ParenthesesImportance {
    public static void main(String[] args) {
        System.out.println("=== 괄호의 중요성 ===");

        // 예제 1: 평균 계산
        int score1 = 80, score2 = 90, score3 = 70;

        // 잘못된 계산
        double wrongAvg = score1 + score2 + score3 / 3;  // 80 + 90 + 23.33...

        // 올바른 계산
        double correctAvg = (score1 + score2 + score3) / 3.0;

        System.out.println("점수: " + score1 + ", " + score2 + ", " + score3);
        System.out.println("잘못된 평균: " + wrongAvg);
        System.out.println("올바른 평균: " + correctAvg);

        // 예제 2: 조건식
        int age = 25;
        boolean hasLicense = true;
        boolean hasInsurance = false;

        // 의도가 불분명한 조건
        boolean unclear = age >= 18 && hasLicense || hasInsurance;

        // 명확한 조건 1
        boolean clear1 = (age >= 18 && hasLicense) || hasInsurance;

        // 명확한 조건 2
        boolean clear2 = age >= 18 && (hasLicense || hasInsurance);

        System.out.println("\nage = " + age + ", hasLicense = " +
                hasLicense + ", hasInsurance = " + hasInsurance);
        System.out.println("불명확: age >= 18 && hasLicense || hasInsurance = " + unclear);
        System.out.println("명확1: (age >= 18 && hasLicense) || hasInsurance = " + clear1);
        System.out.println("명확2: age >= 18 && (hasLicense || hasInsurance) = " + clear2);

        // 예제 3: 타입 캐스팅
        int a = 7, b = 2;

        // 잘못된 캐스팅
        double wrong = (double)(a / b);    // 3.0

        // 올바른 캐스팅
        double correct = (double)a / b;    // 3.5

        System.out.println("\n타입 캐스팅:");
        System.out.println("(double)(7 / 2) = " + wrong);
        System.out.println("(double)7 / 2 = " + correct);
    }
}