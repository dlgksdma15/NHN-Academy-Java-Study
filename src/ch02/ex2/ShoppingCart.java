package ch02.ex2;

public class ShoppingCart {
    public static void main(String[] args) {
        // TODO: 상품 정보를 저장할 변수들을 선언하세요
        String item1Name = "노트북", item2Name = "마우스", item3Name = "키보드";
        double item1Price = 1299.99, item2Price = 29.99, item3Price = 89.99;
        int item1Quantity = 1, item2Quantity = 2, item3Quantity = 1;

        // TODO: 각 상품의 소계를 계산하세요
        double subtotal1 = item1Price * item1Quantity;
        double subtotal2 = item2Price * item2Quantity;
        double subtotal3 = item3Price * item3Quantity;
        double subtotal = subtotal1 + subtotal2 + subtotal3;

        // TODO: 할인과 세금을 계산하세요
        double discountRate = 0.10;
        double taxRate = 0.08;
        double discount = subtotal * discountRate;
        double afterDiscount = subtotal - discount;
        double tax = afterDiscount * taxRate;
        double total = afterDiscount + tax;

        // TODO: 영수증을 출력하세요
        System.out.println("=== 쇼핑 카트 ===");
        System.out.println("상품명\t\t단가\t수량\t소계");
        System.out.println("----------------------------------------");
        System.out.println(item1Name + "\t" + item1Price + "\t" + item1Quantity + "\t" + subtotal1);
        System.out.println(item2Name + "\t" + item2Price + "\t" + item2Quantity + "\t" + subtotal2);
        System.out.println(item3Name + "\t" + item3Price + "\t" + item3Quantity + "\t" + subtotal3);
        System.out.println("----------------------------------------");
        System.out.println("소계: " + subtotal);
        System.out.println("할인: " + discount);
        System.out.println("세금: " + tax);
        System.out.println("========================================");
        System.out.println("총액: " + total);

        // TODO: 결제 방법을 출력하세요
        boolean useCredit = true;
        System.out.println("\n결제 방법: " + (useCredit ? "신용카드" : "현금"));
    }
}