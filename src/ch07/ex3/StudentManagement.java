package ch07.ex3;
import java.util.ArrayList;


public class StudentManagement {
    static class Course {
        String name;
        int credits;

        public Course(String name, int credits) {
            this.name = name;
            this.credits = credits;
        }
    }

    static class Student {
        String name;
        int id;
        ArrayList<Course> courses;
        ArrayList<Double> grades;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
            this.courses = new ArrayList<>();
            this.grades = new ArrayList<>();
        }

        public void enrollCourse(Course course, double grade) {
            courses.add(course);
            grades.add(grade);
        }

        public double calculateGPA() {
            double totalPoints = 0;
            int totalCredits = 0;
            for (int i = 0; i < courses.size(); i++) {
                totalPoints += grades.get(i) * courses.get(i).credits;
                totalCredits += courses.get(i).credits;
            }
            return totalCredits == 0 ? 0 : totalPoints / totalCredits;
        }

        public void printTranscript() {
            System.out.println("학생: " + name + " (ID: " + id + ")");
            System.out.println("수강 과목:");
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                System.out.println("- " + course.name + " (" + course.credits + "학점): " + grades.get(i));
            }
            System.out.printf("평균 학점 (GPA): %.2f ", calculateGPA());
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("김철수", 20210001);
        Student student2 = new Student("이영희", 20210002);

        student1.enrollCourse(new Course("자바 프로그래밍", 3), 4.0);
        student1.enrollCourse(new Course("자료구조", 3), 3.5);
        student1.enrollCourse(new Course("데이터베이스", 3), 4.5);

        student2.enrollCourse(new Course("자바 프로그래밍", 3), 4.5);
        student2.enrollCourse(new Course("웹 프로그래밍", 3), 4.0);
        student2.enrollCourse(new Course("알고리즘", 3), 3.0);

        students.add(student1);
        students.add(student2);

        for (Student student : students) {
            student.printTranscript();
        }

        System.out.println(" === 우수 학생 (GPA 3.5 이상) ===");
        for (Student student : students) {
            if (student.calculateGPA() >= 3.5) {
                System.out.println(student.name + " (GPA: " + String.format("%.2f", student.calculateGPA()) + ")");
            }
        }
    }
}
