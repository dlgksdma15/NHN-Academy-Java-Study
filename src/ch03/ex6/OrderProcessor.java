package ch03.ex6;

enum OrderStatus {
    PENDING, CONFIRMED, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

enum PaymentMethod {
    CREDIT_CARD, DEBIT_CARD, PAYPAL, BANK_TRANSFER, CRYPTO
}

public class OrderProcessor {
    public static void main(String[] args) {
        processOrder("ORD001", OrderStatus.PROCESSING, PaymentMethod.CREDIT_CARD, 150000);
        processOrder("ORD002", OrderStatus.CANCELLED, PaymentMethod.PAYPAL, 85000);
        processOrder("ORD003", OrderStatus.DELIVERED, PaymentMethod.BANK_TRANSFER, 230000);
    }

    public static void processOrder(String orderId, OrderStatus status,
                                    PaymentMethod payment, int amount) {
        System.out.println("\n=== 주문 처리: " + orderId + " ===");

        // 상태별 메시지
        String statusMessage = switch (status) {
            case PENDING -> "⏳ 주문 대기 중";
            case CONFIRMED -> "✅ 주문 확인됨";
            case PROCESSING -> "🔄 주문 처리 중";
            case SHIPPED -> "🚚 배송 중";
            case DELIVERED -> "📦 배송 완료";
            case CANCELLED -> "❌ 주문 취소됨";
        };

        // 결제 방법별 수수료
        double fee = switch (payment) {
            case CREDIT_CARD -> amount * 0.025; // 2.5%
            case DEBIT_CARD -> amount * 0.015;  // 1.5%
            case PAYPAL -> amount * 0.035;      // 3.5%
            case BANK_TRANSFER -> 1000;         // 고정 1000원
            case CRYPTO -> amount * 0.01;       // 1.0%
        };

        // 배송 예상 시간
        String deliveryTime = switch (status) {
            case PENDING, CONFIRMED -> "아직 배송 시작 안됨";
            case PROCESSING -> "1-2일 후 배송 시작";
            case SHIPPED -> {
                yield switch (payment) {
                    case CREDIT_CARD, DEBIT_CARD -> "1-2일 내 도착 예정";
                    case PAYPAL -> "2-3일 내 도착 예정";
                    case BANK_TRANSFER -> "3-5일 내 도착 예정";
                    case CRYPTO -> "당일 또는 다음날 도착 예정";
                };
            }
            case DELIVERED -> "이미 배송 완료";
            case CANCELLED -> "배송 취소";
        };

        // 사용자 액션
        String[] actions = switch (status) {
            case PENDING -> new String[]{"주문 확인", "주문 취소"};
            case CONFIRMED -> new String[]{"주문 상세보기", "주문 취소"};
            case PROCESSING -> new String[]{"주문 상세보기", "배송지 변경"};
            case SHIPPED -> new String[]{"배송 추적", "주문 상세보기"};
            case DELIVERED -> new String[]{"리뷰 작성", "교환/반품 신청"};
            case CANCELLED -> new String[]{"재주문", "취소 사유 확인"};
        };

        System.out.println("상태: " + statusMessage);
        System.out.printf("결제: %s (수수료: %.0f원)%n",
                getPaymentName(payment), fee);
        System.out.printf("금액: %,d원 (총 %,d원)%n",
                amount, Math.round(amount + fee));
        System.out.println("배송: " + deliveryTime);
        System.out.print("가능한 액션: ");
        for (int i = 0; i < actions.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(actions[i]);
        }
        System.out.println();
    }

    private static String getPaymentName(PaymentMethod payment) {
        return switch (payment) {
            case CREDIT_CARD -> "신용카드";
            case DEBIT_CARD -> "체크카드";
            case PAYPAL -> "페이팔";
            case BANK_TRANSFER -> "무통장입금";
            case CRYPTO -> "암호화폐";
        };
    }
}