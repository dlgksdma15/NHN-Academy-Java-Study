package ch02.ex5;

public class ShortCircuit {
    public static void main(String[] args) {
        System.out.println("=== 단축 평가 예제 ===");

        // && 단축 평가
        System.out.println("\n&& 단축 평가:");
        int x = 0;
        boolean result1 = (x != 0) && (10 / x > 1);
        System.out.println("x = " + x);
        System.out.println("(x != 0) && (10 / x > 1) = " + result1);
        System.out.println("0으로 나누기 오류가 발생하지 않음!");

        // || 단축 평가
        System.out.println("\n|| 단축 평가:");
        boolean hasPermission = true;
        boolean isAdmin = false;

        if (hasPermission || checkComplexCondition()) {
            System.out.println("접근 허용");
            // hasPermission이 true이므로 checkComplexCondition()은 호출되지 않음
        }

        // 단축 평가를 이용한 null 체크
        System.out.println("\n단축 평가로 안전한 검사:");
        String str = null;

        // 안전한 방법
        if (str != null && str.length() > 0) {
            System.out.println("문자열이 비어있지 않음");
        } else {
            System.out.println("문자열이 null이거나 비어있음");
        }

        // 위험한 방법 (NullPointerException 발생)
        // if (str.length() > 0 && str != null) { } // 오류!
    }

    static boolean checkComplexCondition() {
        System.out.println("복잡한 조건 검사 실행됨!");
        return true;
    }
}