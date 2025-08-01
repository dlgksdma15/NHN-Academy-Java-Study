package ch02.ex4;


import textio.TextIO;

public class ShoppingCalculator {
    public static void main(String[] args) {
        // TODO: 쇼핑 계산기 프로그램을 만드세요

        System.out.println("=== 쇼핑 계산기 ===");

        String receipt = "";
        int totalItems = 0;
        int totalPrice = 0;

        while (true) {
            System.out.print("\n상품명 (종료: 'quit'): ");
            String name = TextIO.getln();
            if (name.equalsIgnoreCase("quit")) break;

            System.out.print("가격: ");
            int price = TextIO.getlnInt();

            System.out.print("수량: ");
            int quantity = TextIO.getlnInt();

            int subtotal = price * quantity;
            totalPrice += subtotal;
            totalItems++;

            System.out.printf("%s %d개 = %,d원%n", name, quantity, subtotal);
            receipt += String.format("%s %d개 = %,d원%n", name, quantity, subtotal);
        }

        System.out.println("\n==============================");
        System.out.println("영수증");
        System.out.println("==============================");

        int discount = (totalPrice >= 100_000) ? (int)(totalPrice * 0.10) : 0;
        int finalPrice = totalPrice - discount;

        System.out.printf("구매 품목: %d개%n", totalItems);
        System.out.printf("총액: %,d원%n", totalPrice);
        System.out.printf("할인(10%%): -%,d원%n", discount);
        System.out.printf("결제금액: %,d원%n", finalPrice);
        System.out.println("==============================");

        // 파일 저장 여부 확인
        System.out.print("\n영수증을 파일로 저장하시겠습니까? (yes/no): ");
        String save = TextIO.getln();

        if (save.equalsIgnoreCase("yes")) {
            TextIO.writeFile("receipt.txt");
            TextIO.putln("=== 영수증 ===");
            TextIO.putln(receipt.trim());
            TextIO.putln("==============================");
            TextIO.putf("구매 품목: %d개%n", totalItems);
            TextIO.putf("총액: %,d원%n", totalPrice);
            TextIO.putf("할인(10%%): -%,d원%n", discount);
            TextIO.putf("결제금액: %,d원%n", finalPrice);
            TextIO.putln("==============================");
            TextIO.writeStandardOutput();
            System.out.println("영수증이 receipt.txt에 저장되었습니다.");
        }
    }
}
