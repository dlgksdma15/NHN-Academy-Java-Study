package ch10.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
    private String studentId;
    private String name;
    private double gpa;

    public Student(String studentId, String name, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
    }

    // GPA로 내림차순 정렬 (높은 점수가 먼저)
    @Override
    public int compareTo(Student other) {
        // TODO: GPA 기준 내림차순 비교
        // 힌트: Double.compare(other.gpa, this.gpa)

        return Double.compare(other.gpa, this.gpa);
    }

    @Override
    public String toString() {
        return String.format("%s: %s (GPA: %.2f)", studentId, name, gpa);
    }

    // Getter 메서드들
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public String getStudentId() { return studentId; }

    public static void main(String[] args) {
        // 실행 결과:
        // 정렬 전:
        // 2024001: 김철수 (GPA: 3.80)
        // 2024002: 이영희 (GPA: 4.20)
        // 2024003: 박민수 (GPA: 3.50)
        // 2024004: 정지원 (GPA: 4.00)
        //
        // GPA 내림차순 정렬:
        // 2024002: 이영희 (GPA: 4.20)
        // 2024004: 정지원 (GPA: 4.00)
        // 2024001: 김철수 (GPA: 3.80)
        // 2024003: 박민수 (GPA: 3.50)
        List<Student> students = new ArrayList<>();
        students.add(new Student("2024001", "김철수", 3.80));
        students.add(new Student("2024002", "이영희", 4.20));
        students.add(new Student("2024003", "박민수", 3.50));
        students.add(new Student("2024004", "정지원", 4.00));

        System.out.println("정렬 전:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println();

        // Collections.sort()는 Comparable을 구현한 클래스를 정렬할 수 있습니다.
        Collections.sort(students);

        System.out.println("GPA 내림차순 정렬:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}