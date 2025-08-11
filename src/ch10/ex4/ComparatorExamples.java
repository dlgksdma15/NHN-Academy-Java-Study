package ch10.ex4;

import java.util.*;

public class ComparatorExamples {

    static class Student {
        String name;
        int grade;
        double gpa;

        Student(String name, int grade, double gpa) {
            this.name = name;
            this.grade = grade;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return String.format("%s (학년:%d, GPA:%.2f)",
                    name, grade, gpa);
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("김철수", 3, 3.5),
                new Student("이영희", 2, 4.0),
                new Student("박민수", 3, 3.8),
                new Student("정수진", 1, 3.9),
                new Student("김영희", 2, 3.7)
        );

        // 1. 이름순 정렬
        System.out.println("=== 이름순 정렬 ===");
        TreeSet<Student> byName = new TreeSet<>(
                Comparator.comparing((Student s) -> s.name)
        );
        byName.addAll(students);
        byName.forEach(System.out::println);

        // 2. GPA 내림차순 정렬
        System.out.println("\n=== GPA 내림차순 ===");
        TreeSet<Student> byGpaDesc = new TreeSet<>(
                Comparator.comparingDouble((Student s) -> s.gpa).reversed()
        );
        byGpaDesc.addAll(students);
        byGpaDesc.forEach(System.out::println);

        // 3. 학년순, 같으면 GPA순
        System.out.println("\n=== 학년순, GPA순 ===");
        TreeSet<Student> byGradeThenGpa = new TreeSet<>(
                Comparator.comparingInt((Student s) -> s.grade)
                        .thenComparingDouble(s -> s.gpa)
                        .reversed()  // 둘 다 내림차순
        );
        byGradeThenGpa.addAll(students);
        byGradeThenGpa.forEach(System.out::println);

        // 4. 커스텀 Comparator
        System.out.println("\n=== 이름 길이순, 같으면 알파벳순 ===");
        Comparator<Student> customComparator = (s1, s2) -> {
            int lengthCompare = s1.name.length() - s2.name.length();
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.name.compareTo(s2.name);
        };

        TreeSet<Student> byCustom = new TreeSet<>(customComparator);
        byCustom.addAll(students);
        byCustom.forEach(System.out::println);

        // 5. null 처리
        System.out.println("\n=== null 처리 ===");
        List<String> withNulls = Arrays.asList("apple", null, "banana", "cherry", null);

        // null을 마지막으로
        TreeSet<String> nullsLast = new TreeSet<>(
                Comparator.nullsLast(String::compareTo)
        );
        nullsLast.addAll(withNulls);
        System.out.println("null 마지막: " + nullsLast);

        // null을 처음으로
        TreeSet<String> nullsFirst = new TreeSet<>(
                Comparator.nullsFirst(String::compareTo)
        );
        nullsFirst.addAll(withNulls);
        System.out.println("null 처음: " + nullsFirst);
    }
}