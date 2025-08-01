package ch03.ex6;

import textio.TextIO;

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        System.out.println("🍽️ 레스토랑 주문 시스템에 오신 것을 환영합니다!");

        while (true) {
            showMainMenu();
            int choice = TextIO.getlnInt();

            if (choice == 0) {
                System.out.println("이용해 주셔서 감사합니다! 👋");
                break;
            }

            processMenuChoice(choice);
        }
    }

    public static void showMainMenu() {
        System.out.println("""
            
            === 메인 메뉴 ===
            1. 🍝 파스타 메뉴
            2. 🍕 피자 메뉴
            3. 🥗 샐러드 메뉴
            4. 🍰 디저트 메뉴
            5. ☕ 음료 메뉴
            6. 🛒 주문 확인
            7. 💳 결제하기
            0. 종료
            
            선택하세요: """);
    }

    public static void processMenuChoice(int choice) {
        switch (choice) {
            case 1 -> showSubMenu("파스타", new String[]{"알리오 올리오", "까르보나라", "봉골레"});
            case 2 -> showSubMenu("피자", new String[]{"마르게리타", "페퍼로니", "고르곤졸라"});
            case 3 -> showSubMenu("샐러드", new String[]{"시저 샐러드", "그릭 샐러드", "닭가슴살 샐러드"});
            case 4 -> showSubMenu("디저트", new String[]{"티라미수", "치즈케이크", "마카롱"});
            case 5 -> showSubMenu("음료", new String[]{"아메리카노", "라떼", "레몬에이드"});
            case 6 -> System.out.println("🛒 현재 주문 내역: (구현 예정)");
            case 7 -> processPayment();
            default -> System.out.println("잘못된 선택입니다. 0~7번 사이에서 선택해주세요.");
        }
    }


    public static void showSubMenu(String category, String[] items) {
        System.out.println("\n=== " + category + " 상세 메뉴 ===");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }
        System.out.println("메인 메뉴로 돌아가려면 엔터를 누르세요.");
        TextIO.getln();
    }

    public static void processPayment() {
        System.out.print("결제 방법을 선택하세요 (card/cash/mobile): ");
        String paymentMethod = TextIO.getln().toLowerCase();

        // TODO: 결제 방법별 처리
        // 힌트: switch 표현식과 yield
        String message = switch (paymentMethod) {
            case "card" -> "💳 카드 결제가 완료되었습니다.";
            case "cash" -> "💵 현금 결제가 완료되었습니다.";
            case "mobile" -> "📱 모바일 결제가 완료되었습니다.";
            default -> "❌ 유효하지 않은 결제 수단입니다.";
        };

        System.out.println(message);
        if (!message.startsWith("❌")) {
            System.out.println("주문이 접수되었습니다. 조리 시간은 15-20분입니다. 🍽️");
        }
    }
}