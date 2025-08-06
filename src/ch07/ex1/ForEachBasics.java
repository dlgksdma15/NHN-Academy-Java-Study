package ch07.ex1;

public class ForEachBasics {
    public static void main(String[] args) {
        // 정수 배열
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("=== 전통적인 for 루프 ===");
        // TODO: 전통적인 for 루프를 사용하여 배열의 인덱스와 값을 출력하세요
        // 형식: "numbers[인덱스] = 값"
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println("\n=== for-each 루프 ===");
        // TODO: for-each 루프를 사용하여 배열의 값들을 출력하세요
        // 형식: "값: 값"
        for (int number : numbers) {
            System.out.println("값: " + number);
        }

        // 문자열 배열
        String[] days = {"월요일", "화요일", "수요일", "목요일", "금요일"};

        System.out.println("\n=== 요일 출력 ===");
        // TODO: for-each 루프를 사용하여 각 요일 뒤에 "입니다."를 붙여서 출력하세요
        for (String day : days) {
            System.out.println(day + "입니다.");
        }

    }
}