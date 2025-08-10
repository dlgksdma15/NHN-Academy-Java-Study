package ch10.ex3;

import java.util.*;

public class MapViews {

    public static void main(String[] args) {
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("노트북", 1500000.0);
        productPrices.put("마우스", 30000.0);
        productPrices.put("키보드", 80000.0);
        productPrices.put("모니터", 400000.0);
        productPrices.put("스피커", 150000.0);

        // 1. keySet() - 키 집합
        System.out.println("=== 키 집합 (keySet) ===");
        Set<String> products = productPrices.keySet();
        System.out.println("제품 목록: " + products);

        // 키를 통한 순회
        System.out.println("\n제품별 가격:");
        for (String product : products) {
            System.out.printf("%s: %,.0f원%n", product, productPrices.get(product));
        }

        // 2. values() - 값 컬렉션
        System.out.println("\n=== 값 컬렉션 (values) ===");
        Collection<Double> prices = productPrices.values();

        // 가격 통계
        double total = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (Double price : prices) {
            total += price;
            max = Math.max(max, price);
            min = Math.min(min, price);
        }

        System.out.printf("총액: %,.0f원%n", total);
        System.out.printf("평균: %,.0f원%n", total / prices.size());
        System.out.printf("최고가: %,.0f원%n", max);
        System.out.printf("최저가: %,.0f원%n", min);

        // 3. entrySet() - 엔트리 집합
        System.out.println("\n=== 엔트리 집합 (entrySet) ===");
        Set<Map.Entry<String, Double>> entries = productPrices.entrySet();

        // 가격 인상 (10%)
        System.out.println("10% 가격 인상:");
        for (Map.Entry<String, Double> entry : entries) {
            double oldPrice = entry.getValue();
            double newPrice = oldPrice * 1.1;
            entry.setValue(newPrice);
            System.out.printf("%s: %,.0f원 → %,.0f원%n",
                    entry.getKey(), oldPrice, newPrice);
        }

        // 뷰의 특성 - 원본 맵과 연결됨
        System.out.println("\n=== 뷰의 특성 ===");
        System.out.println("키 집합에서 제거:");
        products.remove("스피커");
        System.out.println("맵에도 반영됨: " + productPrices);
    }
}