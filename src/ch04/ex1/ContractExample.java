package ch04.ex1;

public class ContractExample {
    public static void main(String[] args) {
        System.out.println("=== 서브루틴의 계약 예제 ===\n");

        // 31: 나누기 계약 테스트하기
        System.out.println("1. 나누기 계약:");
        try {
            System.out.println("10 / 2 = " + safeDivide(10, 2)); // 정상 케이스
            System.out.println("10 / 0 = " + safeDivide(10, 0)); // 예외 케이스
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 32: 배열 검색 계약 테스트하기
        System.out.println("\n2. 배열 검색 계약:");
        int[] numbers = {3, 7, 1, 9, 5};
        System.out.println("찾는 값 9의 인덱스: " + findElement(numbers, 9));
        System.out.println("찾는 값 4의 인덱스: " + findElement(numbers, 4));
        System.out.println("배열이 null일 때: " + findElement(null, 3));

        // 33: 비밀번호 검증 계약 테스트하기
        System.out.println("\n3. 비밀번호 검증 계약:");
        testPassword("abc");        // 너무 짧음
        testPassword("abcdef");     // 숫자 없음
        testPassword("123456");     // 문자 없음
        testPassword("abc123");     // 올바른 비밀번호
        testPassword("Abc12");      // 짧음
        testPassword("Abc12345");   // 올바른 비밀번호
    }

    // 34: 안전한 나누기 연산 메서드 구현
    public static double safeDivide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return dividend / divisor;
    }

    // 35: 배열에서 요소 찾기 메서드 구현
    public static int findElement(int[] array, int target) {
        if (array == null) {
            return -1; // null 방어
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // 요소 찾으면 인덱스 반환
            }
        }
        return -1; // 못 찾으면 -1 반환
    }

    // 36: 비밀번호 유효성 검사 메서드 구현
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) hasLetter = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }

        return hasLetter && hasDigit;
    }

    // 37: 비밀번호 테스트 메서드 구현
    private static void testPassword(String password) {
        if (isValidPassword(password)) {
            System.out.println("비밀번호 \"" + password + "\"는 유효합니다.");
        } else {
            System.out.println("비밀번호 \"" + password + "\"는 유효하지 않습니다.");
        }
    }
}
