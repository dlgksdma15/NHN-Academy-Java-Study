package ch07.ex4;

import java.util.ArrayList;
import java.util.List;

public class RecordListExample {
    record Product(String id, String name, double price, int stock) {
        public double stockValue() { return price * stock; }
        public boolean isLowStock() { return stock < 10; }
    }

    static class ProductManager {
        private List<Product> products = new ArrayList<>();
        public void addProduct(Product product) {
            products.add(product);
        }
        public List<Product> getLowStockProducts() {
            return products.stream().filter(Product::isLowStock).toList();
        }
        public double getTotalStockValue() {
            return products.stream().mapToDouble(Product::stockValue).sum();
        }
        public List<Product> findByPriceRange(double min, double max) {
            return products.stream()
                    .filter(p -> p.price() >= min && p.price() <= max).toList();
        }
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(new Product("P001", "노트북", 1200000, 5));
        manager.addProduct(new Product("P002", "마우스", 25000, 50));
        manager.addProduct(new Product("P003", "키보드", 85000, 8));
        manager.addProduct(new Product("P004", "모니터", 450000, 12));
        manager.addProduct(new Product("P005", "USB", 15000, 3));

        System.out.println("=== 재고 부족 상품 ===");
        for (Product p : manager.getLowStockProducts()) {
            System.out.printf("%s - %s: %d개\n", p.id(), p.name(), p.stock());
        }

        System.out.println("\n=== 10만원 이하 상품 ===");
        for (Product p : manager.findByPriceRange(0, 100000)) {
            System.out.printf("%s: %,.0f원\n", p.name(), p.price());
        }

        System.out.printf("\n총 재고 가치: %,.0f원\n", manager.getTotalStockValue());
    }
}
