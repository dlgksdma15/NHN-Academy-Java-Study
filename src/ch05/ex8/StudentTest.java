package ch05.ex8;


import java.util.ArrayList;
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
            // TODO 64: name, age, gpa 초기화하기
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            // TODO 65: "name (나이: age, 학점: gpa)" 형식으로 반환하기
            return "";
        }
    }

    public void addStudent(String name, int age, double gpa) {
        // TODO 66: 새 Student 객체 생성하여 students에 추가하기
    }

    // 다양한 정렬 방법
    public void sortByName() {
        // TODO 67: 익명 클래스로 Comparator 구현하여 이름순 정렬하기
        // s1.name.compareTo(s2.name) 사용
    }

    public void sortByAge() {
        // TODO 68: 익명 클래스로 Comparator 구현하여 나이순 정렬하기
        // Integer.compare(s1.age, s2.age) 사용
    }

    public void sortByGPA() {
        // TODO 69: 익명 클래스로 Comparator 구현하여 학점 내림차순 정렬하기
        // Double.compare(s2.gpa, s1.gpa) 사용 (내림차순)
    }

    // 필터링
    public List<Student> filterStudents(Predicate<Student> condition) {
        // TODO 70: 조건에 맞는 학생만 필터링하기
        // 새 리스트 생성
        // condition.test()로 각 학생 검사
        // 조건에 맞으면 리스트에 추가
        return null;
    }

    public void printStudents(String title) {
        // TODO 71: 학생 리스트 출력하기
        // "=== title ===" 출력
        // 모든 학생 출력
    }
}

// 테스트
public class StudentTest {
    public static void main(String[] args) {
        // TODO 72: StudentManager 생성하고 학생 4명 추가하기
        // 김철수(22, 3.8), 이영희(21, 4.2)
        // 박민수(23, 3.5), 최지우(20, 4.0)
        StudentManager manager = new StudentManager();
        StudentManager.Student kim = new StudentManager.Student("김철수", 22, 3.8);
        StudentManager.Student lee = new StudentManager.Student("이영희", 21, 4.2);
        StudentManager.Student park = new StudentManager.Student("박민수", 23, 3.5);
        StudentManager.Student ch = new StudentManager.Student("최지우", 23, 4.0);

        manager.addStudent("김철수", 22, 3.8);
        manager.addStudent("이영희", 21, 4.2);
        manager.addStudent("박민수", 23, 3.5);
        manager.addStudent("최지우", 23, 4.0);

        // TODO 73: 원본 학생 리스트 출력하기

        // TODO 74: 이름순으로 정렬하고 출력하기

        // TODO 75: 학점순으로 정렬하고 출력하기

        // TODO 76: 익명 클래스로 GPA 4.0 이상 학생 필터링하기
        // Predicate<StudentManager.Student> 구현
        // test 메서드에서 s.gpa >= 4.0 검사

        // TODO 77: 필터링 결과 출력하기

        // TODO 78: 람다 표현식으로 21세 이하 학생 필터링하기
        // s -> s.age <= 21

        // TODO 79: 필터링 결과 출력하기
    }
}
