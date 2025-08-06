package ch07.ex1;

public class MixedParameters {
    public static String formatMessage(String prefix, String... items) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(":");
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                sb.append(" ").append(items[i]);
                if (i < items.length - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static void printReport(String title, int year, double... values) {
        System.out.println("=== " + title + " (" + year + ") ===");
        double total = 0;
        for (int i = 0; i < values.length; i++) {
            System.out.printf("월 %d: %.2f\n", (i + 1), values[i]);
            total += values[i];
        }
        System.out.printf("연간 총계: %.2f\n", total);
        if (values.length > 0) {
            System.out.printf("월 평균: %.2f\n", total / values.length);
        }
        System.out.println("=========================");
    }


    public static void main(String[] args) {
        // formatMessage 사용
        System.out.println(formatMessage("과일", "사과", "바나나", "오렌지"));
        System.out.println(formatMessage("색상", "빨강", "파랑"));
        System.out.println(formatMessage("숫자"));  // 가변 인수 0개

        System.out.println();

        // printReport 사용
        printReport("월별 매출", 2024,
                150.5, 180.3, 165.7, 195.2, 210.5, 188.9);
    }
}