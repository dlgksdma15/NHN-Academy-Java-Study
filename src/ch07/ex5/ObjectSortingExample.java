package ch07.ex5;

import java.util.Arrays;
import java.util.Comparator;

public class ObjectSortingExample {
    public static void main(String[] args) {
        Product[] products = {
            new Product("Laptop", 1200.0, 10),
            new Product("Mouse", 25.0, 50),
            new Product("Keyboard", 75.0, 20),
            new Product("Monitor", 300.0, 5),
            new Product("Webcam", 50.0, 30)
        };

        System.out.println("=== 원본 상품 목록 ===");
        printProducts(products);

        // TODO: 가격 기준으로 정렬
        System.out.println("\n=== 가격 오름차순 정렬 ===");
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
        printProducts(products);

        // TODO: 재고 기준으로 정렬
        System.out.println("\n=== 재고 내림차순 정렬 ===");
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Integer.compare(p2.getStock(), p1.getStock()); // 내림차순
            }
        });
        printProducts(products);

        // TODO: 이름 기준으로 정렬
        System.out.println("\n=== 이름 오름차순 정렬 ===");
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
