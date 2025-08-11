package ch10.ex4;

import java.util.*;

public class NestedMapExample {

    // 온라인 쇼핑몰 재고 관리
    // 카테고리 → 브랜드 → 제품 → 재고수
    static class InventorySystem {
        private Map<String, Map<String, Map<String, Integer>>> inventory;

        public InventorySystem() {
            inventory = new TreeMap<>();
        }

        // 제품 추가/수정
        public void updateProduct(String category, String brand,
                                  String product, int quantity) {
            inventory.computeIfAbsent(category, k -> new TreeMap<>())
                    .computeIfAbsent(brand, k -> new TreeMap<>())
                    .put(product, quantity);
        }

        // 재고 추가
        public void addStock(String category, String brand,
                             String product, int quantity) {
            inventory.computeIfAbsent(category, k -> new TreeMap<>())
                    .computeIfAbsent(brand, k -> new TreeMap<>())
                    .merge(product, quantity, Integer::sum);
        }

        // 특정 카테고리의 전체 재고
        public int getCategoryTotal(String category) {
            Map<String, Map<String, Integer>> categoryMap =
                    inventory.get(category);

            if (categoryMap == null) return 0;

            return categoryMap.values().stream()
                    .flatMap(brandMap -> brandMap.values().stream())
                    .mapToInt(Integer::intValue)
                    .sum();
        }

        // 브랜드별 제품 수
        public Map<String, Integer> getProductCountByBrand() {
            Map<String, Integer> result = new TreeMap<>();

            inventory.values().forEach(categoryMap ->
                    categoryMap.forEach((brand, products) ->
                            result.merge(brand, products.size(), Integer::sum)
                    )
            );

            return result;
        }

        // 재고 보고서
        public void printInventoryReport() {
            System.out.println("=== 재고 보고서 ===");

            inventory.forEach((category, brands) -> {
                System.out.println("\n카테고리: " + category);
                int categoryTotal = 0;

                brands.forEach((brand, products) -> {
                    System.out.println("  브랜드: " + brand);
                    int brandTotal = 0;

                    products.forEach((product, quantity) -> {
                        System.out.printf("    %-20s %3d개\n",
                                product, quantity);
                    });

                    brandTotal = products.values().stream()
                            .mapToInt(Integer::intValue).sum();
                    System.out.println("  브랜드 총계: " + brandTotal + "개");
                });

                categoryTotal = getCategoryTotal(category);
                System.out.println("카테고리 총계: " + categoryTotal + "개");
            });
        }

        // 품절 상품 찾기
        public List<String> findOutOfStock() {
            List<String> outOfStock = new ArrayList<>();

            inventory.forEach((category, brands) ->
                    brands.forEach((brand, products) ->
                            products.forEach((product, quantity) -> {
                                if (quantity == 0) {
                                    outOfStock.add(category + "/" + brand +
                                            "/" + product);
                                }
                            })
                    )
            );

            return outOfStock;
        }
    }

    public static void main(String[] args) {
        InventorySystem system = new NestedMapExample.InventorySystem();

        // 재고 입력
        system.updateProduct("전자제품", "삼성", "갤럭시S23", 50);
        system.updateProduct("전자제품", "삼성", "갤럭시버즈", 30);
        system.updateProduct("전자제품", "애플", "아이폰14", 40);
        system.updateProduct("전자제품", "애플", "에어팟", 25);

        system.updateProduct("의류", "나이키", "운동화", 100);
        system.updateProduct("의류", "나이키", "티셔츠", 80);
        system.updateProduct("의류", "아디다스", "운동화", 90);
        system.updateProduct("의류", "아디다스", "트레이닝복", 0);

        // 재고 추가
        system.addStock("전자제품", "삼성", "갤럭시S23", 20);

        // 보고서 출력
        system.printInventoryReport();

        // 통계
        System.out.println("\n=== 브랜드별 제품 수 ===");
        system.getProductCountByBrand().forEach((brand, count) ->
                System.out.println(brand + ": " + count + "개 제품")
        );

        // 품절 상품
        System.out.println("\n=== 품절 상품 ===");
        system.findOutOfStock().forEach(System.out::println);
    }
}