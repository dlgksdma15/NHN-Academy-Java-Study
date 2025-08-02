package ch04.ex4;

public class VoidReturn {
    public static void main(String[] args) {
        System.out.println("=== void 메서드의 return ===\n");

        processPositiveOnly(10);
        processPositiveOnly(-5);
        processPositiveOnly(20);

        int[] numbers = {10, 20, 30, 40, 50};
        searchAndPrint(numbers, 30);
        searchAndPrint(numbers, 25);

        validateAndProcess("user@email.com");
        validateAndProcess("invalid-email");
    }

    static void processPositiveOnly(int n) {
        if (n < 0) {
            System.out.println(n + "은(는) 음수입니다. 처리하지 않습니다.");
            return;
        }
        System.out.println(n + "을(를) 처리합니다...");
        System.out.println("결과: " + (n * 2));
    }

    static void searchAndPrint(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println(target + " 찾기: 인덱스 " + i + "에서 발견!");
                return;
            }
        }
        System.out.println(target + " 찾기: 찾을 수 없습니다.");
    }

    static void validateAndProcess(String email) {
        if (!email.contains("@")) {
            System.out.println("이메일 처리: 잘못된 이메일 형식입니다.");
            return;
        }
        System.out.println("이메일 처리: " + email + " 처리 완료!");
    }
}
