package ch04.ex6;

// TODO 60: StudentService 클래스 만들기 (service 패키지)

// TODO 61: 필요한 import문 추가하기

// TODO 62: StudentService 클래스에 Javadoc 주석 작성하기

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <ul>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 * </ul>
 */
public class StudentService {
    // TODO 63: 학생 저장용 Map 선언하기
    private Map<String, Student> studentMap;

    // TODO 64: 생성자 구현하기
    public StudentService() {
        studentMap = new HashMap<>();
    }

    // TODO 65: addStudent 메서드 구현하기
    /**
     * @param student
     * @throws IllegalArgumentException
     */
    public void addStudent(Student student) {
        studentMap.put(student.getStudentId(),student);
    }

    // TODO 66: findStudent 메서드 구현하기
    /**
     * @param studentId
     * @return
     */
    public Student findStudent(String studentId) {
        return studentMap.get(studentId);
    }

    // TODO 67: getAllStudents 메서드 구현하기
    /**
     * @return
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    // TODO 68: searchByName 메서드 구현하기
    /**
     * @param name
     * @return
     */
    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentMap.values()) {
            if (s.getName().contains(name)) {
                result.add(s);
            }
        }
        return result;
    }

}