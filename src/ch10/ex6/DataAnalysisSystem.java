package ch10.ex6;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class DataAnalysisSystem {
    public static void main(String[] args) {
        // 샘플 주문 데이터 생성
        List<Order> orders = generateSampleOrders();

        DataAnalysisSystem analyzer = new DataAnalysisSystem();
        analyzer.performAnalysis(orders);
    }

    private void performAnalysis(List<Order> orders) {
        System.out.println("=== 주문 데이터 분석 시스템 ===");
        System.out.println("총 주문 수: " + orders.size());

        // 1. 월별 매출 분석
        System.out.println("\n1. 월별 매출:");
        Map<String, Double> monthlySales = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getDate().getYear() + "-" +
                                String.format("%02d", order.getDate().getMonthValue()),
                        Collectors.summingDouble(Order::getAmount)
                ));

        monthlySales.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.printf("%s: %.0f원%n", entry.getKey(), entry.getValue()));

        // 2. 고객별 구매 패턴 분석
        System.out.println("\n2. 고객별 구매 통계:");
        Map<String, CustomerStats> customerStats = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerId,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                orderList -> new CustomerStats(
                                        orderList.size(),
                                        orderList.stream().mapToDouble(Order::getAmount).sum(),
                                        orderList.stream().mapToDouble(Order::getAmount).average().orElse(0)
                                )
                        )
                ));

        customerStats.entrySet().stream()
                .sorted(Map.Entry.<String, CustomerStats>comparingByValue(
                        Comparator.comparing(CustomerStats::getTotalAmount)).reversed())
                .limit(5)
                .forEach(entry ->
                        System.out.printf("고객 %s: %d건, 총 %.0f원, 평균 %.0f원%n",
                                entry.getKey(),
                                entry.getValue().getOrderCount(),
                                entry.getValue().getTotalAmount(),
                                entry.getValue().getAverageAmount()));

        // 3. 제품 카테고리별 인기도
        System.out.println("\n3. 제품 카테고리별 판매량:");
        Map<String, Long> categoryPopularity = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.counting()
                ));

        categoryPopularity.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.printf("%s: %d건%n", entry.getKey(), entry.getValue()));

        // 4. 시간대별 주문 패턴
        System.out.println("\n4. 시간대별 주문 분포:");
        Map<Integer, Long> hourlyOrders = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getDate().getDayOfYear() % 24, // 간단한 시간 시뮬레이션
                        Collectors.counting()
                ));

        hourlyOrders.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.printf("%02d시: %d건%n", entry.getKey(), entry.getValue()));

        // 5. 고액 주문 분석
        System.out.println("\n5. 고액 주문 분석 (10만원 이상):");
        List<Order> highValueOrders = orders.stream()
                .filter(order -> order.getAmount() >= 100000)
                .sorted(Comparator.comparing(Order::getAmount).reversed())
                .collect(Collectors.toList());

        System.out.println("고액 주문 건수: " + highValueOrders.size());
        System.out.println("고액 주문 총액: " +
                highValueOrders.stream().mapToDouble(Order::getAmount).sum() + "원");

        System.out.println("\n상위 5건:");
        highValueOrders.stream()
                .limit(5)
                .forEach(System.out::println);

        // 6. 성장률 분석
        System.out.println("\n6. 전월 대비 성장률:");
        List<String> months = monthlySales.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 1; i < months.size(); i++) {
            String currentMonth = months.get(i);
            String previousMonth = months.get(i - 1);

            double currentSales = monthlySales.get(currentMonth);
            double previousSales = monthlySales.get(previousMonth);
            double growthRate = ((currentSales - previousSales) / previousSales) * 100;

            System.out.printf("%s: %.1f%%%n", currentMonth, growthRate);
        }
    }

    private static List<Order> generateSampleOrders() {
        Random random = new Random(42); // 재현 가능한 랜덤
        List<Order> orders = new ArrayList<>();

        String[] categories = {"전자제품", "의류", "도서", "식품", "생활용품"};
        String[] customers = {"C001", "C002", "C003", "C004", "C005", "C006", "C007", "C008", "C009", "C010"};

        LocalDate startDate = LocalDate.of(2023, 1, 1);

        for (int i = 0; i < 1000; i++) {
            String orderId = "ORD" + String.format("%04d", i + 1);
            String customerId = customers[random.nextInt(customers.length)];
            String category = categories[random.nextInt(categories.length)];
            double amount = 10000 + random.nextDouble() * 190000; // 1만원 ~ 20만원
            LocalDate date = startDate.plusDays(random.nextInt(365));

            orders.add(new Order(orderId, customerId, category, amount, date));
        }

        return orders;
    }
}

class Order {
    private String orderId;
    private String customerId;
    private String category;
    private double amount;
    private LocalDate date;

    public Order(String orderId, String customerId, String category, double amount, LocalDate date) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return String.format("주문 %s: 고객 %s, %s, %.0f원, %s",
                orderId, customerId, category, amount, date);
    }
}

class CustomerStats {
    private int orderCount;
    private double totalAmount;
    private double averageAmount;

    public CustomerStats(int orderCount, double totalAmount, double averageAmount) {
        this.orderCount = orderCount;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public int getOrderCount() { return orderCount; }
    public double getTotalAmount() { return totalAmount; }
    public double getAverageAmount() { return averageAmount; }
}