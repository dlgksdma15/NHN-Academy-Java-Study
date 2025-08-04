package ch05.ex2;

/**
 * 자동 ID 생성 기능이 있는 Product 클래스
 */
class Product {
    // TODO 64: static 변수 선언하기
    private static int nextProductId = 1000;
    private static int totalProducts = 0;

    // TODO 65: 인스턴스 변수 선언하기
    private final int productId;   // 변경 불가
    private String name;
    private String category;
    private double price;
    private boolean inStock;

    // TODO 66: 생성자 구현하기
    public Product(String name, double price, String category) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("상품명은 필수입니다.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
        }

        this.productId = nextProductId++;
        this.name = name;
        this.price = price;
        this.category = (category == null || category.trim().isEmpty()) ? "기타" : category;
        this.inStock = true;
        totalProducts++;

        System.out.println("상품 생성: ID=" + productId + ", 이름=" + name);
    }

    // TODO 67: static 메서드들 구현하기
    public static int getTotalProducts() {
        return totalProducts;
    }

    public static int getNextProductId() {
        return nextProductId;
    }

    public static void resetIdCounter(int startId) {
        nextProductId = startId;
    }

    // TODO 68: getter 메서드들 구현하기
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isInStock() {
        return inStock;
    }

    // TODO 69: setter 메서드들 구현하기
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    // TODO 70: 정보 출력 메서드 구현하기
    public void displayInfo() {
        System.out.printf("ID: %d, 상품명: %s, 가격: %.0f원, 카테고리: %s, 재고: %s%n",
                productId, name, price, category, (inStock ? "있음" : "없음"));
    }
}
public class AutoIdExample {
    public static void main(String[] args) {
        System.out.println("=== 자동 ID 생성 시스템 ===");

        // TODO 72: 여러 상품 생성하기
        Product product1 = new Product("노트북", 1500000, "전자제품");
        Product product2 = new Product("마우스", 25000, "전자제품");
        Product product3 = new Product("의자", 150000, "가구");
        Product product4 = new Product("책", 15000, "도서");

        // TODO 73: 상품 정보 출력하기
        System.out.println("\n=== 상품 정보 ===");
        product1.displayInfo();
        product2.displayInfo();
        product3.displayInfo();
        product4.displayInfo();

        // TODO 74: 통계 정보 출력하기
        System.out.println("\n=== 통계 정보 ===");
        System.out.println("총 생성된 상품 수: " + Product.getTotalProducts());
        System.out.println("다음 상품 ID: " + Product.getNextProductId());

        // TODO 75: ID 카운터 재설정 테스트하기
        System.out.println("\n=== ID 카운터 재설정 ===");
        Product.resetIdCounter(5000);
        Product product5 = new Product("키보드", 80000, "전자제품");
        product5.displayInfo();

        System.out.println("총 생성된 상품 수: " + Product.getTotalProducts());
    }
}


