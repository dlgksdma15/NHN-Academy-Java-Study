package ch10.ex5;
import java.util.*;

public class NumberProcessor<T extends Number> {
    private List<T> numbers;

    public NumberProcessor() {
        this.numbers = new ArrayList<>();
    }

    public void add(T number) {
        if (number != null) {
            numbers.add(number);
        }
    }

    public void addAll(Collection<? extends T> collection) {
        numbers.addAll(collection);
    }

    // Number의 메서드들을 사용할 수 있음
    public double sum() {
        double total = 0.0;
        for (T number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    public double average() {
        if (numbers.isEmpty()) {
            return 0.0;
        }
        return sum() / numbers.size();
    }

    public T max() {
        if (numbers.isEmpty()) {
            return null;
        }

        T maximum = numbers.get(0);
        for (T number : numbers) {
            if (number.doubleValue() > maximum.doubleValue()) {
                maximum = number;
            }
        }
        return maximum;
    }

    public T min() {
        if (numbers.isEmpty()) {
            return null;
        }

        T minimum = numbers.get(0);
        for (T number : numbers) {
            if (number.doubleValue() < minimum.doubleValue()) {
                minimum = number;
            }
        }
        return minimum;
    }

    // 통계 정보
    public void printStatistics() {
        if (numbers.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return;
        }

        System.out.println("=== 통계 정보 ===");
        System.out.println("개수: " + numbers.size());
        System.out.printf("합계: %.2f\n", sum());
        System.out.printf("평균: %.2f\n", average());
        System.out.println("최댓값: " + max());
        System.out.println("최솟값: " + min());
    }

    // 조건에 맞는 숫자들 필터링
    public List<T> filter(double minValue, double maxValue) {
        List<T> filtered = new ArrayList<>();
        for (T number : numbers) {
            double value = number.doubleValue();
            if (value >= minValue && value <= maxValue) {
                filtered.add(number);
            }
        }
        return filtered;
    }

    @Override
    public String toString() {
        return "NumberProcessor" + numbers.toString();
    }

    public static void main(String[] args) {
        // Integer 처리
        NumberProcessor<Integer> intProcessor = new NumberProcessor<>();
        intProcessor.add(10);
        intProcessor.add(20);
        intProcessor.add(15);
        intProcessor.add(30);
        intProcessor.add(5);

        System.out.println("Integer 프로세서: " + intProcessor);
        intProcessor.printStatistics();

        System.out.println("10~20 범위: " + intProcessor.filter(10, 20));

        // Double 처리
        System.out.println("\n" + "=".repeat(40));
        NumberProcessor<Double> doubleProcessor = new NumberProcessor<>();
        doubleProcessor.addAll(Arrays.asList(1.5, 2.3, 3.7, 1.2, 4.8));

        System.out.println("Double 프로세서: " + doubleProcessor);
        doubleProcessor.printStatistics();

        // Float 처리
        System.out.println("\n" + "=".repeat(40));
        NumberProcessor<Float> floatProcessor = new NumberProcessor<>();
        floatProcessor.add(1.1f);
        floatProcessor.add(2.2f);
        floatProcessor.add(3.3f);

        System.out.println("Float 프로세서: " + floatProcessor);
        floatProcessor.printStatistics();

        // 컬렉션 추가 테스트
        List<Integer> moreInts = Arrays.asList(100, 200, 300);
        intProcessor.addAll(moreInts);
        System.out.println("\n추가 후 Integer 프로세서: " + intProcessor);
        intProcessor.printStatistics();
    }
}