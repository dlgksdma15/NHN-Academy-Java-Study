package ch07.ex1;

public class ArrayStatistics {
    public static void main(String[] args) {
        double[] temperatures = {23.5, 25.2, 22.8, 24.1, 26.3, 23.9, 25.5};

        // TODO: for-each 루프를 사용하여 모든 온도의 합을 계산하세요
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }

        double average = sum / temperatures.length;

        // TODO: 최고/최저 온도를 찾으세요
        // 힌트: 첫 번째 요소로 초기화한 후 for-each 루프 사용
        double max = temperatures[0];
        double min = temperatures[0];
        for (double temp : temperatures) {
            if (temp > max) {
                max = temp;
            }
            if (temp < min) {
                min = temp;
            }
        }


        System.out.println("=== 주간 온도 통계 ===");
        System.out.printf("평균 온도: %.1f°C\n", average);
        System.out.printf("최고 온도: %.1f°C\n", max);
        System.out.printf("최저 온도: %.1f°C\n", min);
        System.out.printf("온도 차이: %.1f°C\n", max - min);
    }
}