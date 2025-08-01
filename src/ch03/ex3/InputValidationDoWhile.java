package ch03.ex3;

import textio.TextIO;

public class InputValidationDoWhile {
    public static void main(String[] args) {
        int age;
        char grade;
        String password;

        // 나이 입력 검증
        do {
            System.out.print("나이를 입력하세요 (1-120): ");
            age = TextIO.getlnInt();

            if (age < 1 || age > 120) {
                System.out.println("유효하지 않은 나이입니다!");
            }
        } while (age < 1 || age > 120);

        System.out.println("입력된 나이: " + age);

        // 학점 입력 검증
        do {
            System.out.print("\n학점을 입력하세요 (A-F): ");
            String input = TextIO.getln();

            if (input.length() == 0) {
                grade = ' ';
            } else {
                grade = input.toUpperCase().charAt(0);
            }

            if (grade < 'A' || grade > 'F' || grade == 'E') {
                System.out.println("유효하지 않은 학점입니다!");
            }
        } while (grade < 'A' || grade > 'F' || grade == 'E');

        System.out.println("입력된 학점: " + grade);

        // TODO: 비밀번호 강도 검증
        // 힌트:
        // 1. do-while 루프 사용
        // 2. 비밀번호 입력받기
        // 3. 길이가 8자 이상인지 확인
        // 4. 조건을 만족하지 않으면 오류 메시지 출력
        // 5. 조건을 만족할 때까지 반복
        boolean isValid;

        // 여기에 코드를 작성하세요
        do{
            System.out.println("비밀번호를 입력하세요 (최소 8자):");
            password = TextIO.getln();
            if(password.length() < 8){
                System.out.println("비밀번호가 최소 8자 이상이어야 합니다!\n");
            }
        } while(password.length() < 8);
        System.out.println("비밀번호가 설정되었습니다.");
    }
}