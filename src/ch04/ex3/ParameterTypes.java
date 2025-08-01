package ch04.ex3;

public class ParameterTypes {
    public static void main(String[] args) {
        System.out.println("=== 매개변수 타입 예제 ===\n");

        // 1: 기본 타입 매개변수 메서드들 호출하기
        printNumber(100);
        printBoolean(true);
        printCharacter('A');

        // 2: 문자열 매개변수 메서드 호출하기
        printMessage("안녕하세요!");

        // 3: 여러 매개변수 메서드 호출하기
        printPersonInfo("김철수", 25, 175.5);

        // 4: 배열 매개변수 메서드 호출하기
        int[] numbers = {10, 20, 30, 40, 50};
        printArray(numbers);
    }

    // 5: 정수를 출력하는 메서드
    static void printNumber(int num) {
        System.out.println("정수 값: " + num);
    }

    // 6: 불린값을 출력하는 메서드
    static void printBoolean(boolean value) {
        System.out.println("불린 값: " + value);
    }

    // 7: 문자를 출력하는 메서드
    static void printCharacter(char ch) {
        System.out.println("문자 값: " + ch);
    }

    // 8: 문자열을 출력하는 메서드
    static void printMessage(String msg) {
        System.out.println("문자열: " + msg);
    }

    // 9: 개인 정보를 출력하는 메서드
    static void printPersonInfo(String name, int age, double height) {
        System.out.printf("이름: %s, 나이: %d, 키: %.1fcm\n", name, age, height);
    }

    // 10: 배열을 출력하는 메서드
    static void printArray(int[] arr) {
        System.out.print("배열 값: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
