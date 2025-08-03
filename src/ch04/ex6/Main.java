package ch04.ex6;

// TODO 69: Main 클래스 만들기
// TODO 70: 필요한 import문 추가하기

// TODO 71: Main 클래스에 Javadoc 주석 작성하기

import java.time.LocalDate;
import java.util.List;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        // TODO 72: StudentService 객체 생성하기
        StudentService service = new StudentService();
        // TODO 73: 학생들 추가하기
        service.addStudent(new Student("S001", "김철수", 20, LocalDate.of(2023, 3, 1)));
        service.addStudent(new Student("S002", "이영희", 19, LocalDate.of(2023, 3, 1)));
        service.addStudent(new Student("S003", "박민수", 21, LocalDate.of(2022, 9, 1)));
        // TODO 74: 모든 학생 출력하기
        System.out.println("=== 전체 학생 목록 ===");
        List<Student> allStudents = service.getAllStudents();

        for (Student allStudent : allStudents) {
            System.out.println(allStudent);
        }
        // TODO 75: 특정 학생 검색하기
        System.out.println("=== 학생 검색 ===");
        Student find = service.findStudent("S002");
        System.out.println("찾은 학생: " + find);

        // TODO 76: 이름으로 검색하기
        System.out.println("=== 이름 검색 ===");
        List<Student> searchByName = service.searchByName("김철수");
        System.out.println(searchByName);
    }
}