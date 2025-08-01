package ch03.ex5;

import textio.TextIO;

public class LengthConverter {
    public static void main(String[] args) {
        System.out.println("=== 길이 단위 변환기 ===");
        System.out.println("사용법: 숫자와 단위를 입력 (예: 5.5 feet)");
        System.out.println("지원 단위: inch(in), feet(ft), yard(yd), mile(mi)");
        System.out.println("종료: 0 입력\n");

        while (true) {
            System.out.print("측정값 입력: ");
            double measurement = TextIO.getlnDouble();

            if (measurement == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String unit = TextIO.getln().toLowerCase();

            // 인치로 변환
            double inches;
            if (unit.equals("inch") || unit.equals("in")) {
                inches = measurement;
            } else if (unit.equals("feet") || unit.equals("ft")) {
                inches = measurement * 12.0;
            } else if (unit.equals("yard") || unit.equals("yd")) {
                inches = measurement * 36.0;
            } else if (unit.equals("mile") || unit.equals("mi")) {
                inches = measurement * 12.0 * 5280.0;
            } else {
                System.out.println("지원하지 않는 단위입니다: " + unit);
                continue;
            }

            // 모든 단위로 변환
            double feet = inches / 12.0;
            double yards = inches / 36.0;
            double miles = inches / (12.0 * 5280.0);

            // 결과 출력
            System.out.println("\n변환 결과:");
            System.out.printf("  %,.2f inches%n", inches);
            System.out.printf("  %,.2f feet%n", feet);
            System.out.printf("  %,.2f yards%n", yards);
            System.out.printf("  %,.6f miles%n", miles);

            // 추가 정보 출력
            if (inches < 12) {
                System.out.println("  → 1피트보다 짧습니다.");
            } else if (inches < 36) {
                System.out.println("  → 1야드보다 짧지만 1피트 이상입니다.");
            } else if (inches < 12 * 5280) {
                System.out.println("  → 1마일보다 짧지만 1야드 이상입니다.");
            } else {
                System.out.println("  → 1마일 이상입니다.");
            }

            System.out.println();
        }
    }
}
