package ch02.ex5;

public class RangeCheck {
    public static void main(String[] args) {
        // 나이별 그룹 분류
        System.out.println("=== 나이별 그룹 분류 ===");
        int[] ages = {5, 13, 18, 25, 65, 70};

        for (int age : ages) {
            System.out.print("나이 " + age + "세: ");

            if (age < 13) {
                System.out.println("어린이");
            } else if (age >= 13 && age < 20) {
                System.out.println("청소년");
            } else if (age >= 20 && age < 65) {
                System.out.println("성인");
            } else {
                System.out.println("노인");
            }
        }

        // 성적 등급
        System.out.println("\n=== 성적 등급 ===");
        int[] scores = {95, 87, 73, 68, 55};

        for (int score : scores) {
            System.out.print("점수 " + score + ": ");

            if (score >= 90) {
                System.out.println("A등급");
            } else if (score >= 80) {
                System.out.println("B등급");
            } else if (score >= 70) {
                System.out.println("C등급");
            } else if (score >= 60) {
                System.out.println("D등급");
            } else {
                System.out.println("F등급");
            }
        }
    }
}