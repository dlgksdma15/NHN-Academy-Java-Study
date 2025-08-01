package ch03.ex7;

import textio.TextIO;

public class NumberParsingExample {
    public static void main(String[] args) {
        System.out.println("=== 숫자 변환 예제 ===");

        String[] testInputs = {"123", "45.67", "abc", "12x", "", "  ", "-789"};

        for (String input : testInputs) {
            System.out.println("\n입력: '" + input + "'");

            // TODO: Integer 변환 시도
            // 힌트: try-catch 구조 사용

            // 여기에 Integer 변환 코드를 작성하세요
            try{
                int intValue = Integer.parseInt(input);
                System.out.println("✅Integer 성공: " + intValue);

            }catch (NumberFormatException e){
                System.out.println("❌Integer 변환 실패: " + e.getMessage());
            }

            // TODO: Double 변환 시도
            // 힌트: try-catch 구조 사용
            // 여기에 Double 변환 코드를 작성하세요
            try{
                double doubleValue = Double.parseDouble(input);
                System.out.println("✅ Double 성공: " + doubleValue );
            } catch (NumberFormatException e){
                System.out.println("❌ Double 실패: " + e.getMessage());
            }
        }
    }
}
