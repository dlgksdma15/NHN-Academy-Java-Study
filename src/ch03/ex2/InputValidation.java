package ch03.ex2;

import textio.TextIO;

public class InputValidation {
    public static void main(String[] args) {
        int age;
        double score;

        // 나이 입력 검증
        System.out.println("=== 나이 입력 ===");
        do {
            System.out.print("나이를 입력하세요 (1-120): ");
            age = TextIO.getlnInt();

            if (age < 1 || age > 120) {
                System.out.println("유효하지 않은 나이입니다!");
            }
        } while (age < 1 || age > 120);

        System.out.println("입력된 나이: " + age);

        // TODO: 점수 입력 검증
        System.out.println("\n=== 점수 입력 ===");
        // 힌트:
        // 1. while(true) 무한 루프 사용
        // 2. 점수 입력받기
        // 3. 0 <= score <= 100 이면 break
        // 4. 그렇지 않으면 오류 메시지 출력하고 계속

        // 여기에 코드를 작성하세요
        while (true) {
            System.out.print("점수를 입력하세요 (0-100): ");
            score = TextIO.getlnDouble();

            if (score >= 0 && score <= 100) {
                break;
            } else {
                System.out.println("유효하지 않은 점수입니다!");
            }
        }


        System.out.println("입력된 점수: " + score);
    }
}