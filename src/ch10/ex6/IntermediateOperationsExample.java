package ch10.ex6;

import java.util.*;
import java.util.stream.*;

public class IntermediateOperationsExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("김철수", 85, "컴퓨터공학"),
                new Student("이영희", 92, "수학"),
                new Student("박민수", 78, "컴퓨터공학"),
                new Student("최유진", 88, "수학"),
                new Student("정현우", 95, "물리학"),
                new Student("김영희", 82, "컴퓨터공학")
        );

        System.out.println("=== 중간 연산 예제 ===");

        // 1. filter() - 조건에 맞는 요소만 선택
        System.out.println("컴퓨터공학과 학생들:");
        students.stream()
                .filter(s -> s.getMajor().equals("컴퓨터공학"))
                .forEach(System.out::println);

        // 2. map() - 요소 변환
        System.out.println("\n학생 이름들:");
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        // 3. mapToInt() - 기본형으로 변환
        System.out.println("\n점수들:");
        students.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);

        // 4. distinct() - 중복 제거
        System.out.println("\n전공 목록 (중복 제거):");
        students.stream()
                .map(Student::getMajor)
                .distinct()
                .forEach(System.out::println);

        // 5. sorted() - 정렬
        System.out.println("\n점수 순 정렬:");
        students.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .forEach(System.out::println);

        // 6. limit() - 개수 제한
        System.out.println("\n상위 3명:");
        students.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .limit(3)
                .forEach(System.out::println);

        // 7. skip() - 요소 건너뛰기
        System.out.println("\n상위 2명 제외한 나머지:");
        students.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .skip(2)
                .forEach(System.out::println);

        // 8. 복합 연산
        System.out.println("\n컴퓨터공학과 중 80점 이상 학생 이름:");
        students.stream()
                // TODO 5: 컴퓨터공학과 학생 필터링
                .filter(s -> s.getMajor().equals("컴퓨터공학"))
                // TODO 6: 80점 이상인 학생 필터링
                .filter(s -> s.getScore() >= 80)
                // TODO 7: 학생 이름으로 매핑
                .map(Student::getName)
                // TODO 8: 이름순 정렬
                .sorted()
                // TODO 9: 출력
                .forEach(System.out::println);
    }
}

class Student {
    private String name;
    private int score;
    private String major;

    public Student(String name, int score, String major) {
        this.name = name;
        this.score = score;
        this.major = major;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
    public String getMajor() { return major; }

    @Override
    public String toString() {
        return String.format("%s(%d점, %s)", name, score, major);
    }
}