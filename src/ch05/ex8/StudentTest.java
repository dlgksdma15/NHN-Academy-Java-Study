package ch05.ex8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 학생 관리 시스템
 */
class StudentManager {
    private List<Student> students = new ArrayList<>();

    static class Student {
        String name;
        int age;
        double gpa;

        Student(String name, int age, double gpa) {
            // TODO 64
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            // TODO 65
            return "%s (나이: %d, 학점: %.2f)".formatted(name, age, gpa);
        }
    }

    public void addStudent(String name, int age, double gpa) {
        // TODO 66
        students.add(new Student(name, age, gpa));
    }

    // 다양한 정렬 방법
    public void sortByName() {
        // TODO 67: 이름순 오름차순
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });
    }

    public void sortByAge() {
        // TODO 68: 나이순 오름차순
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.age, s2.age);
            }
        });
    }

    public void sortByGPA() {
        // TODO 69: 학점순 내림차순
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.gpa, s1.gpa);
            }
        });
    }

    // 필터링
    public List<Student> filterStudents(Predicate<Student> condition) {
        // TODO 70
        List<Student> filtered = new ArrayList<>();
        for (Student s : students) {
            if (condition.test(s)) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public void printStudents(String title) {
        // TODO 71
        System.out.println("=== " + title + " ===");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();
    }

    // 필터링된 리스트 출력용 메서드
    public void printFiltered(String title, List<Student> filtered) {
        System.out.println("=== " + title + " ===");
        for (Student s : filtered) {
            System.out.println(s);
        }
        System.out.println();
    }
}

// 테스트
public class StudentTest {
    public static void main(String[] args) {
        // TODO 72: 학생 추가
        StudentManager manager = new StudentManager();
        manager.addStudent("김철수", 22, 3.8);
        manager.addStudent("이영희", 21, 4.2);
        manager.addStudent("박민수", 23, 3.5);
        manager.addStudent("최지우", 20, 4.0);

        // TODO 73: 원본 출력
        manager.printStudents("원본");

        // TODO 74: 이름순 정렬
        manager.sortByName();
        manager.printStudents("이름순 정렬");

        // TODO 75: 학점순 정렬
        manager.sortByGPA();
        manager.printStudents("학점순 정렬");

        // TODO 76: 익명 클래스 - GPA 4.0 이상
        List<StudentManager.Student> highGpa = manager.filterStudents(new Predicate<StudentManager.Student>() {
            @Override
            public boolean test(StudentManager.Student s) {
                return s.gpa >= 4.0;
            }
        });

        // TODO 77: 필터링 결과 출력
        manager.printFiltered("학점 4.0 이상", highGpa);

        // TODO 78: 람다식 - 21세 이하
        List<StudentManager.Student> youngStudents = manager.filterStudents(s -> s.age <= 21);

        // TODO 79: 필터링 결과 출력
        manager.printFiltered("21세 이하", youngStudents);
    }
}
