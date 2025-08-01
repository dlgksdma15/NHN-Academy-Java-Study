package ch02.ex5;

public class LogicalOperators {
    public static void main(String[] args) {
        System.out.println("=== 논리 연산자 ===\n");

        // AND 연산
        System.out.println("AND 연산 (&&):");
        System.out.println("true && true = " + (true && true));
        System.out.println("true && false = " + (true && false));
        System.out.println("false && true = " + (false && true));
        System.out.println("false && false = " + (false && false));

        // OR 연산
        System.out.println("\nOR 연산 (||):");
        System.out.println("true || true = " + (true || true));
        System.out.println("true || false = " + (true || false));
        System.out.println("false || true = " + (false || true));
        System.out.println("false || false = " + (false || false));

        // NOT 연산
        System.out.println("\nNOT 연산 (!):");
        System.out.println("!true = " + (!true));
        System.out.println("!false = " + (!false));

        // 실제 예제
        System.out.println("\n=== 실제 예제 ===");
        int age = 25;
        boolean hasLicense = true;
        boolean isInsured = false;

        // 운전 가능: 나이가 18세 이상이고 면허가 있어야 함
        boolean canDrive = age >= 18 && hasLicense;

        // 차량 대여 가능: 운전 가능하고 보험에 가입되어 있어야 함
        boolean canRentCar = canDrive && isInsured;

        // 할인 대상: 65세 이상이거나 보험 미가입자
        boolean isDiscountEligible = age >= 65 || !isInsured;

        System.out.println("운전 가능: " + canDrive);
        System.out.println("차량 대여 가능: " + canRentCar);
        System.out.println("할인 대상: " + isDiscountEligible);
    }
}
