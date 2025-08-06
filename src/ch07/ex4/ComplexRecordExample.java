package ch07.ex4;

import java.time.LocalDate;
import java.util.List;

public class ComplexRecordExample {
    record Student(String name, int id, LocalDate birthDate, List<String> courses, double gpa) {
        public int age() {
            return LocalDate.now().getYear() - birthDate.getYear();
        }
        public int courseCount() {
            return courses != null ? courses.size() : 0;
        }
    }

    public static void main(String[] args) {
        Student student = new Student(
                "김철수",
                20210001,
                LocalDate.of(2000, 3, 15),
                List.of("자바", "데이터베이스", "웹프로그래밍"),
                4.2
        );

        System.out.println("학생 정보: " + student);
        System.out.println("이름: " + student.name());
        System.out.println("나이: " + student.age() + "세");
        System.out.println("수강 과목 수: " + student.courseCount());

        System.out.println("\n수강 과목:");
        for (String c : student.courses()) {
            System.out.println("- " + c);
        }
    }
}