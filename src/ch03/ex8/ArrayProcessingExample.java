package ch03.ex8;

public class ArrayProcessingExample {
    public static void main(String[] args) {
        double[] temperatures = {23.5, 25.0, 22.8, 26.3, 24.1, 25.5, 23.9};
        String[] days = {"월", "화", "수", "목", "금", "토", "일"};

        System.out.println("=== 주간 온도 데이터 ===");

        // 1. 데이터 출력
        for (int i = 0; i < temperatures.length; i++) {
            System.out.printf("%s요일: %.1f°C%n", days[i], temperatures[i]);
        }

        // 합계와 평균 계산
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        double avg = sum / temperatures.length;
        System.out.printf("\n 합계: %.1f°C, 평균: %.2f°C%n", sum, avg);

        // 최고 온도와 최저 온도 찾기
        double max = temperatures[0];
        double min = temperatures[0];
        String maxDay = days[0];
        String minDay = days[0];

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > max) {
                max = temperatures[i];
                maxDay = days[i];
            }
            if (temperatures[i] < min) {
                min = temperatures[i];
                minDay = days[i];
            }
        }
        System.out.printf("📈 최고 온도: %.1f°C (%s요일)%n", max, maxDay);
        System.out.printf("📉 최저 온도: %.1f°C (%s요일)%n", min, minDay);

        // 평균보다 높은 날 찾기
        System.out.println("\n 평균보다 높은 온도의 날:");
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] > avg) {
                System.out.printf("• %s요일 (%.1f°C)%n", days[i], temperatures[i]);
            }
        }
    }
}
