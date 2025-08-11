package ch10.ex6;

import java.util.*;
import java.util.stream.*;

public class TerminalOperationsExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("노트북", 1200000, "전자제품"),
                new Product("마우스", 25000, "전자제품"),
                new Product("키보드", 80000, "전자제품"),
                new Product("의자", 150000, "가구"),
                new Product("책상", 300000, "가구"),
                new Product("모니터", 250000, "전자제품"),
                new Product("램프", 45000, "가구")
        );

        System.out.println("=== 종단 연산 예제 ===");

        // 1. forEach() - 각 요소에 작업 수행
        System.out.println("모든 제품:");
        products.stream().forEach(System.out::println);

        // 2. collect() - 리스트로 수집
        List<String> productNames = products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println("\n제품명 리스트: " + productNames);

        // 3. count() - 개수 세기
        long electronicCount = products.stream()
                .filter(p -> p.getCategory().equals("전자제품"))
                .count();
        System.out.println("\n전자제품 개수: " + electronicCount);

        // 4. min(), max() - 최솟값, 최댓값
        Optional<Product> cheapest = products.stream()
                .min(Comparator.comparing(Product::getPrice));
        cheapest.ifPresent(p -> System.out.println("가장 저렴한 제품: " + p));

        Optional<Product> mostExpensive = products.stream()
                .max(Comparator.comparing(Product::getPrice));
        mostExpensive.ifPresent(p -> System.out.println("가장 비싼 제품: " + p));

        // 5. reduce() - 집계
        // TODO 10: products 스트림을 가격(int)으로 매핑
        // TODO 11: reduce를 사용하여 모든 가격 합계 계산
        // 힌트: 초기값 0, Integer::sum 사용
        int totalPrice = products.stream()
                .mapToInt(Product::getPrice)
                .reduce(0, Integer::sum);
        System.out.println("\n총 가격: " + totalPrice + "원");

        // 6. anyMatch(), allMatch(), noneMatch() - 조건 확인
        boolean hasExpensiveItem = products.stream()
                .anyMatch(p -> p.getPrice() > 1000000);
        System.out.println("100만원 이상 제품 존재: " + hasExpensiveItem);

        boolean allAffordable = products.stream()
                .allMatch(p -> p.getPrice() < 2000000);
        System.out.println("모든 제품이 200만원 미만: " + allAffordable);

        // 7. findFirst(), findAny() - 요소 찾기
        Optional<Product> firstFurniture = products.stream()
                .filter(p -> p.getCategory().equals("가구"))
                .findFirst();
        firstFurniture.ifPresent(p -> System.out.println("첫 번째 가구: " + p));

        // 8. 그룹화
        // TODO 12: products를 카테고리별로 그룹화
        // 힌트: Collectors.groupingBy 사용
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("\n카테고리별 제품:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(p -> System.out.println("  " + p));
        });

        // 9. 통계 수집
        IntSummaryStatistics priceStats = products.stream()
                .mapToInt(Product::getPrice)
                .summaryStatistics();

        System.out.println("\n가격 통계:");
        System.out.println("평균: " + priceStats.getAverage());
        System.out.println("최대: " + priceStats.getMax());
        System.out.println("최소: " + priceStats.getMin());
        System.out.println("합계: " + priceStats.getSum());
        System.out.println("개수: " + priceStats.getCount());
    }
}

class Product {
    private String name;
    private int price;
    private String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("%s(%d원, %s)", name, price, category);
    }
}