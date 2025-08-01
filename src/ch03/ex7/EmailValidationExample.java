package ch03.ex7;

import textio.TextIO;

public class EmailValidationExample {
    public static void main(String[] args) {
        System.out.println("=== 이메일 검증 예제 ===");

        String email = getValidEmail();
        System.out.println("등록된 이메일: " + email);

        // 이메일 정보 분석
        analyzeEmail(email);
    }

    public static String getValidEmail() {
        while (true) {
            System.out.print("이메일 주소를 입력하세요: ");
            String input = TextIO.getln().trim();

            try {
                validateEmail(input);
                System.out.println("✅ 유효한 이메일입니다.");
                return input; // 유효하면 반환
            } catch (IllegalArgumentException e) {
                System.out.println("❌ 유효하지 않은 이메일입니다: " + e.getMessage());
            }
        }
    }

    public static void validateEmail(String email) {
        if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("이메일은 '@'를 포함하고, 앞뒤에 글자가 있어야 합니다.");
        }
        if (!email.contains(".")) {
            throw new IllegalArgumentException("도메인에 '.'이 포함되어야 합니다.");
        }
    }

    public static void analyzeEmail(String email) {
        String[] parts = email.split("@");
        String username = parts[0];
        String domain = parts[1];

        System.out.println("🧾 이메일 분석 결과:");
        System.out.println("• 사용자명: " + username);
        System.out.println("• 도메인: " + domain);
    }

}