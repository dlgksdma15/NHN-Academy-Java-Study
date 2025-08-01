package ch02.ex4;

public class OutputTypes {
    public static void main(String[] args) {
        // TODO: 다양한 타입의 변수를 생성하고 출력하세요
        int age = 25;
        double height = 175.5;
        char grade = 'A';
        boolean isStudent = true;
        String name = "김철수";

        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height);
        System.out.println("학점: " + grade);
        System.out.println("학생 여부: " + isStudent);

        System.out.println("\n한 줄 요약:");
        System.out.println(name + ", " + age + "세, " + height + "cm, 학점 " + grade);

    }
}
