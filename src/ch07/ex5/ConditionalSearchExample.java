package ch07.ex5;

public class ConditionalSearchExample {
    static class Student {
        String name;
        int score;
        String major;

        Student(String name, int score, String major) {
            this.name = name;
            this.score = score;
            this.major = major;
        }

        @Override
        public String toString() {
            return String.format("%s(%d점, %s)", name, score, major);
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("김철수", 85, "컴퓨터공학"),
                new Student("이영희", 92, "수학"),
                new Student("박민수", 78, "컴퓨터공학"),
                new Student("최지영", 95, "물리학"),
                new Student("홍길동", 88, "컴퓨터공학")
        };

        // 이름으로 학생 찾기
        Student found = findStudentByName(students, "이영희");
        System.out.println("찾은 학생: " + found);

        // 90점 이상인 학생들 찾기
        Student[] highScorers = findStudentsByScore(students, 90);
        System.out.println("\n90점 이상 학생들:");
        for (Student s : highScorers) {
            System.out.println("  " + s);
        }

        // 컴퓨터공학과 학생들 찾기
        Student[] csStudents = findStudentsByMajor(students, "컴퓨터공학");
        System.out.println("\n컴퓨터공학과 학생들:");
        for (Student s : csStudents) {
            System.out.println("  " + s);
        }
    }

    // 이름으로 학생 찾기
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.name.equals(name)) {
                return s;
            }
        }
        return null;
    }

    // 최소 점수 이상인 학생들 찾기
    public static Student[] findStudentsByScore(Student[] students, int minScore) {
        // 조건 만족 학생 수 세기
        int count = 0;
        for (Student s : students) {
            if (s.score >= minScore) {
                count++;
            }
        }

        // 배열 생성
        Student[] result = new Student[count];

        // 배열 채우기
        int index = 0;
        for (Student s : students) {
            if (s.score >= minScore) {
                result[index++] = s;
            }
        }

        return result;
    }

    // 전공으로 학생 찾기
    public static Student[] findStudentsByMajor(Student[] students, String major) {
        // 조건 만족 학생 수 세기
        int count = 0;
        for (Student s : students) {
            if (s.major.equals(major)) {
                count++;
            }
        }

        // 배열 생성
        Student[] result = new Student[count];

        // 배열 채우기
        int index = 0;
        for (Student s : students) {
            if (s.major.equals(major)) {
                result[index++] = s;
            }
        }

        return result;
    }
}