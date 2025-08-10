package ch10.ex1;

import java.util.*;

public class SimpleGradeSystem {

    // 학생 클래스
    static class Student {
        private String id;
        private String name;
        private Map<String, Double> grades;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
            this.grades = new HashMap<>();
        }

        public void addGrade(String subject, double grade) {
            // TODO: 과목과 성적을 grades Map에 추가
            grades.put(subject, grade);
        }

        public double getAverageGrade() {
            // TODO: 모든 성적의 평균 계산
            // 힌트: grades가 비어있으면 0 반환
            if(grades.isEmpty()){
                return 0;
            }
            double total = 0;


            for (Double value : grades.values()) {
                total += value;
            }
            double average = total / grades.size();

            return average; // 임시 반환값
        }

        public String getId() { return id; }
        public String getName() { return name; }
    }

    private Map<String, Student> students;

    public SimpleGradeSystem() {
        this.students = new HashMap<>();
    }

    // 학생 추가
    public void addStudent(Student student) {
        // TODO: students Map에 학생 추가 (ID를 키로 사용)
        students.put(student.getId(),student);
    }

    // 성적 입력
    public void addGrade(String studentId, String subject, double grade) {
        // TODO: 해당 학생을 찾아서 성적 추가
        // 힌트: students.get(studentId) 사용
        Student student = students.get(studentId);
        // student = 김철수
        student.addGrade(subject,grade); // 김철수, 수학,85 | 영어 90

    }

    // 전체 학생 중 최고 평균 성적 학생 찾기
    public Student getTopStudent() {
        // TODO: 모든 학생 중 평균 성적이 가장 높은 학생 반환
        // 힌트: students.values()로 모든 학생 순회
        Student topStudent = null;
        double max = 0;
        for (Student student : students.values()) {
            if(max < student.getAverageGrade()){
                max = student.getAverageGrade();
                topStudent = student;
            }
        }

        return topStudent; // 임시 반환값
    }

    public static void main(String[] args) {
        SimpleGradeSystem system = new SimpleGradeSystem();

        // 학생 추가
        Student s1 = new Student("2024001", "김철수");
        Student s2 = new Student("2024002", "이영희");
        Student s3 = new Student("2024003", "박민수");

        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);

        // 성적 입력
        system.addGrade("2024001", "수학", 85);
        system.addGrade("2024001", "영어", 90);

        system.addGrade("2024002", "수학", 95);
        system.addGrade("2024002", "영어", 92);

        system.addGrade("2024003", "수학", 78);
        system.addGrade("2024003", "영어", 85);

        // 실행 결과:
        // 김철수 평균: 87.5
        // 이영희 평균: 93.5
        // 박민수 평균: 81.5
        System.out.println("김철수 평균: " + s1.getAverageGrade());
        System.out.println(s2.name + " 평균: " + s2.getAverageGrade());
        System.out.println(s3.name + " 평균: " + s3.getAverageGrade());

        // 최고 성적 학생: 이영희
        Student topStudent = system.getTopStudent();
        System.out.println("최고 성적 학생: " + topStudent.getName());

    }
}