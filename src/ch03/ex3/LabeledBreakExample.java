package ch03.ex3;

public class LabeledBreakExample {
    public static void main(String[] args) {
        System.out.println("=== 곱셈표 (곱이 50을 초과하면 중단) ===");

        outerLoop:
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int product = i * j;

                if (product > 50) {
                    System.out.println("\n곱이 50을 초과했습니다!");
                    break outerLoop;  // 바깥 루프까지 종료
                }

                System.out.printf("%2d × %2d = %2d  ", i, j, product);
            }
            System.out.println();
        }

        // 문자열에서 공통 문자 찾기
        System.out.println("\n=== 공통 문자 찾기 ===");
        String str1 = "hello";
        String str2 = "world";
        char commonChar = '\0';
        boolean found = false;

        searchLoop:
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    commonChar = str1.charAt(i);
                    found = true;
                    break searchLoop;  // 두 루프 모두 종료
                }
            }
        }

        if (found) {
            System.out.println("첫 번째 공통 문자: '" + commonChar + "'");
        } else {
            System.out.println("공통 문자가 없습니다.");
        }
    }
}