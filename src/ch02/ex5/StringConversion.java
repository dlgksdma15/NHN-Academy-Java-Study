package ch02.ex5;

public class StringConversion {
    public static void main(String[] args) {
        System.out.println("=== 문자열 변환 ===");

        // 기본 타입 → String
        int num = 42;
        double pi = 3.14;
        boolean flag = true;
        char ch = 'A';

        // 방법 1: + 연산자
        String str1 = num + "";
        String str2 = "" + pi;

        // 방법 2: String.valueOf() (권장)
        String str3 = String.valueOf(flag);
        String str4 = String.valueOf(ch);

        System.out.println("int → String: " + str1);
        System.out.println("double → String: " + str2);
        System.out.println("boolean → String: " + str3);
        System.out.println("char → String: " + str4);

        // String → 기본 타입
        System.out.println("\n=== String → 기본 타입 ===");

        String numStr = "123";
        String doubleStr = "45.67";
        String boolStr = "true";

        int intValue = Integer.parseInt(numStr);
        double doubleValue = Double.parseDouble(doubleStr);
        boolean boolValue = Boolean.parseBoolean(boolStr);

        System.out.println("\"" + numStr + "\" → " + intValue);
        System.out.println("\"" + doubleStr + "\" → " + doubleValue);
        System.out.println("\"" + boolStr + "\" → " + boolValue);

        // 변환 오류 처리
        System.out.println("\n=== 변환 오류 예제 ===");
        String invalidNumber = "abc123";
        try {
            int value = Integer.parseInt(invalidNumber);
        } catch (NumberFormatException e) {
            System.out.println("\"" + invalidNumber + "\"는 숫자로 변환할 수 없습니다!");
        }
    }
}