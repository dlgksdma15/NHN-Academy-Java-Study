package ch02.ex4;

public class TextBlockPrintf {
    public static void main(String[] args) {
        // TODO: 텍스트 블록과 printf를 조합하여 영수증을 출력하세요
        String name = "홍길동";
        int itemCount = 3;
        double totalPrice = 45000.0;
        double unitPrice = totalPrice / itemCount;

        // 영수증 틀 (텍스트 블록)
        String receiptTemplate = """
                ┌─────────────────────────┐
                │       영수증            │
                ├─────────────────────────┤
                │ 고객명: %-10s       │
                │ 구매 수량: %3d개        │
                │ 총 금액: %9s원  │
                └─────────────────────────┘
                """;

        // 상세 내역 틀 (텍스트 블록)
        String detailTemplate = """
                === 상세 내역 ===
                단가: %s원
                수량: %d개
                ─────────────────
                합계: %s원
                """;

        // 숫자에 천 단위 콤마 붙이기 위한 문자열 포맷
        String formattedTotalPrice = String.format("%,d", (int) totalPrice);
        String formattedUnitPrice = String.format("%,d", (int) unitPrice);

        // 영수증 출력
        System.out.printf(receiptTemplate, name, itemCount, formattedTotalPrice);

        // 상세 내역 출력
        System.out.printf(detailTemplate, formattedUnitPrice, itemCount, formattedTotalPrice);
    }
}
