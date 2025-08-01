package ch03.ex7;

import textio.TextIO;

public class RangeValidationExample {
    public static void main(String[] args) {
        System.out.println("=== 범위 검증 입력 예제 ===");

        int age = getValidAge();
        int score = getValidScore();

        System.out.println("입력 완료!");
        System.out.println("나이: " + age + "세");
        System.out.println("점수: " + score + "점");

        // 등급 계산
        String grade = calculateGrade(score);
        System.out.println("등급: " + grade);
    }

    public static int getValidAge() {
        while (true) {

            // TODO: 나이 검증 로직
            // 힌트: 범위 검사 후 continue로 재시도
            try{
                System.out.print("나이를 입력하세요 (1-150): ");
                String input = TextIO.getln();
                int age = Integer.parseInt(input);

                if(age > 0 && age < 150) {
                    System.out.println("✅ 유효한 나이입니다.");
                    return age;
                }else{
                    System.out.println("❌ 유효하지 않는 나이입니다.");
                }
            } catch (NumberFormatException e){
                System.out.println("나이를 제대로 입력하지 않았습니다." + e.getMessage());
            }

            // 여기에 코드를 작성하세요
        }
    }

    public static int getValidScore() {
        while (true) {
            // TODO: 점수 검증 로직
            // 힌트: 범위 검사 후 continue로 재시도
            try{
                System.out.print("점수를 입력하세요 (0-100): ");
                String input = TextIO.getln();
                int score = Integer.parseInt(input);
                if(score > 0 && score <= 100){
                    System.out.println("✅ 유효한 점수입니다.");
                    return score;
                }else{
                    System.out.println("❌ 유요하지 않는 점수입니다.");
                }

            }catch (NumberFormatException e){
                System.out.println("점수를 제대로 입력하지 않았습니다" + e.getMessage());
            }

            // 여기에 코드를 작성하세요
        }
    }

    public static String calculateGrade(int score) {
        // TODO: 점수에 따른 등급 계산
        String result;
        if (score >= 80 && score <= 100){
            result = "A";
        }else if(score >= 60){
            result = "B";
        }else if(score >= 40){
            result = "C";
        }else{
            result = "D";
        }
        return result;
    }
}