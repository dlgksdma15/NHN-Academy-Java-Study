package ch03.ex5;

import textio.TextIO;

public class LoginSystem {
    public static void main(String[] args) {
        // 미리 설정된 사용자 정보
        String validUsername = "admin";
        String validPassword = "1234";
        boolean isAccountLocked = false;
        int loginAttempts = 0;

        while (loginAttempts < 3) {
            System.out.println("=== 로그인 시스템 ===");

            if (isAccountLocked) {
                System.out.println("계정이 잠겨 있습니다. 관리자에게 문의하세요.");
                break; // 계정 잠겼으면 반복 종료
            }

            System.out.print("사용자명: ");
            String username = TextIO.getln();

            if (username.equals(validUsername)) {
                System.out.print("비밀번호: ");
                String password = TextIO.getln();

                if (password.equals(validPassword)) {
                    System.out.println("로그인 성공! 환영합니다, " + username + "님!");

                    if (username.equals("admin")) {
                        System.out.println("관리자 권한이 있습니다.");
                    } else {
                        System.out.println("일반 사용자 권한입니다.");
                    }
                    break; // 로그인 성공했으므로 반복 종료
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                    loginAttempts++;
                }
            } else {
                System.out.println("존재하지 않는 사용자명입니다.");
                loginAttempts++;
            }

            if (loginAttempts >= 3) {
                isAccountLocked = true;
                System.out.println("3회 실패로 계정이 잠겼습니다.");
            }

            System.out.println(); // 줄바꿈
        }
    }
}
