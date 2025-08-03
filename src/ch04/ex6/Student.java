package ch04.ex6;

// TODO 53: Student 클래스 만들기 (model 패키지)

// TODO 54: 필요한 import문 추가하기

// TODO 55: Student 클래스에 상세한 Javadoc 주석 작성하기

import javax.swing.text.html.parser.TagElement;
import java.time.LocalDate;

/**
 * @author
 * @version
 */
public class Student {
    // TODO 56: private 필드들 선언하기
    private String studentId;
    private String name;
    private int age;
    private LocalDate enrollDate;
    // TODO 57: 생성자에 Javadoc 주석과 구현 작성하기
    /**
     * @param studentId
     * @param name
     * @param age
     * @param enrollDate
     */
    public Student(String studentId, String name, int age, LocalDate enrollDate) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.enrollDate = enrollDate;
    }

    // TODO 58: getter 메서드들 구현하기
    public String getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    // TODO 59: toString 메서드 구현하기
    @Override
    public String toString() {
        return String.format("[%s] %s (%d세) - 입학일: %s",
                studentId, name, age, enrollDate);
    }
}