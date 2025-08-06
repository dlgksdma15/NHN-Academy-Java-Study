package ch07.ex5;

import java.util.Arrays;
import java.util.Scanner;

public class StudentGradeSystem {
    static class Student {
        String id;
        String name;
        int[] scores;  // 과목별 점수
        double average;

        Student(String id, String name, int subjectCount) {
            this.id = id;
            this.name = name;
            this.scores = new int[subjectCount];
            this.average = 0.0;
        }

        public void calculateAverage() {
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            average = (double) sum / scores.length;
        }

        public String getGrade() {
            if (average >= 95) return "A+";
            else if (average >= 90) return "A";
            else if (average >= 85) return "B+";
            else if (average >= 80) return "B";
            else if (average >= 75) return "C+";
            else if (average >= 70) return "C";
            else if (average >= 65) return "D+";
            else if (average >= 60) return "D";
            else return "F";
        }

        @Override
        public String toString() {
            return String.format("%-8s %-10s %s 평균:%.1f(%s)",
                    id, name, Arrays.toString(scores), average, getGrade());
        }
    }

    static class GradeManager {
        private Student[] students;
        private int count;
        private String[] subjects;

        public GradeManager(int capacity, String[] subjects) {
            this.students = new Student[capacity];
            this.count = 0;
            this.subjects = subjects;
        }

        // 학생 추가
        public boolean addStudent(String id, String name) {
            if (count >= students.length) {
                System.out.println("더 이상 학생을 추가할 수 없습니다.");
                return false;
            }

            // 중복 ID 확인
            if (findStudentById(id) != null) {
                System.out.println("이미 존재하는 학번입니다: " + id);
                return false;
            }

            students[count++] = new Student(id, name, subjects.length);
            return true;
        }

        // 학번으로 학생 찾기
        public Student findStudentById(String id) {
            for (int i = 0; i < count; i++) {
                if (students[i].id.equals(id)) {
                    return students[i];
                }
            }
            return null;
        }

        // 성적 입력
        public boolean inputScores(String id, int[] scores) {
            Student student = findStudentById(id);
            if (student == null) {
                System.out.println("학생을 찾을 수 없습니다: " + id);
                return false;
            }

            if (scores.length != subjects.length) {
                System.out.println("과목 수가 맞지 않습니다.");
                return false;
            }

            for (int i = 0; i < scores.length; i++) {
                student.scores[i] = scores[i];
            }
            student.calculateAverage();
            return true;
        }

        // 평균 점수순 정렬 (내림차순)
        public void sortByAverage() {
            for (int i = 0; i < count - 1; i++) {
                int maxIndex = i;

                for (int j = i + 1; j < count; j++) {
                    if (students[j].average > students[maxIndex].average) {
                        maxIndex = j;
                    }
                }

                // 교환
                Student temp = students[i];
                students[i] = students[maxIndex];
                students[maxIndex] = temp;
            }
        }

        // 이름순 정렬
        public void sortByName() {
            for (int i = 1; i < count; i++) {
                Student key = students[i];
                int j = i - 1;

                while (j >= 0 && students[j].name.compareTo(key.name) > 0) {
                    students[j + 1] = students[j];
                    j = j - 1;
                }

                students[j + 1] = key;
            }
        }

        // 특정 점수 이상 학생 찾기
        public Student[] findStudentsByMinAverage(double minAverage) {
            int matchCount = 0;
            for (int i = 0; i < count; i++) {
                if (students[i].average >= minAverage) {
                    matchCount++;
                }
            }

            Student[] results = new Student[matchCount];
            int resultIndex = 0;
            for (int i = 0; i < count; i++) {
                if (students[i].average >= minAverage) {
                    results[resultIndex++] = students[i];
                }
            }

            return results;
        }

        // 통계 정보
        public void printStatistics() {
            if (count == 0) {
                System.out.println("등록된 학생이 없습니다.");
                return;
            }

            double totalAverage = 0;
            double maxAverage = students[0].average;
            double minAverage = students[0].average;

            for (int i = 0; i < count; i++) {
                totalAverage += students[i].average;
                if (students[i].average > maxAverage) {
                    maxAverage = students[i].average;
                }
                if (students[i].average < minAverage) {
                    minAverage = students[i].average;
                }
            }

            System.out.println("=== 통계 정보 ===");
            System.out.printf("총 학생 수: %d명\n", count);
            System.out.printf("전체 평균: %.2f점\n", totalAverage / count);
            System.out.printf("최고 점수: %.2f점\n", maxAverage);
            System.out.printf("최저 점수: %.2f점\n", minAverage);
        }

        // 전체 학생 목록 출력
        public void printAllStudents() {
            if (count == 0) {
                System.out.println("등록된 학생이 없습니다.");
                return;
            }

            System.out.println("=== 전체 학생 목록 ===");
            System.out.printf("%-8s %-10s", "학번", "이름");
            for (String subject : subjects) {
                System.out.printf(" %-4s", subject);
            }
            System.out.println(" 평균   등급");
            System.out.println("------------------------------------------------");

            for (int i = 0; i < count; i++) {
                System.out.printf("%-8s %-10s",
                        students[i].id, students[i].name);
                for (int score : students[i].scores) {
                    System.out.printf(" %-4d", score);
                }
                System.out.printf(" %-6.1f %s\n",
                        students[i].average, students[i].getGrade());
            }
        }
    }

    public static void main(String[] args) {
        String[] subjects = {"국어", "영어", "수학", "과학"};
        GradeManager manager = new GradeManager(100, subjects);
        Scanner scanner = new Scanner(System.in);

        // 샘플 데이터 추가
        manager.addStudent("20240001", "김철수");
        manager.addStudent("20240002", "이영희");
        manager.addStudent("20240003", "박민수");

        manager.inputScores("20240001", new int[]{85, 90, 88, 92});
        manager.inputScores("20240002", new int[]{95, 87, 93, 89});
        manager.inputScores("20240003", new int[]{78, 82, 85, 80});

        while (true) {
            System.out.println("\n=== 학생 성적 관리 시스템 ===");
            System.out.println("1. 학생 추가");
            System.out.println("2. 성적 입력");
            System.out.println("3. 전체 목록 (이름순)");
            System.out.println("4. 전체 목록 (성적순)");
            System.out.println("5. 학생 검색");
            System.out.println("6. 우수학생 (90점 이상)");
            System.out.println("7. 통계 정보");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 소비

            switch (choice) {
                case 1:
                    System.out.print("학번: ");
                    String id = scanner.nextLine();
                    System.out.print("이름: ");
                    String name = scanner.nextLine();

                    if (manager.addStudent(id, name)) {
                        System.out.println("학생이 추가되었습니다.");
                    }
                    break;

                case 2:
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine();

                    int[] scores = new int[subjects.length];
                    for (int i = 0; i < subjects.length; i++) {
                        System.out.printf("%s 점수: ", subjects[i]);
                        scores[i] = scanner.nextInt();
                    }
                    scanner.nextLine();  // 개행 문자 소비

                    if (manager.inputScores(studentId, scores)) {
                        System.out.println("성적이 입력되었습니다.");
                    }
                    break;

                case 3:
                    manager.sortByName();
                    manager.printAllStudents();
                    break;

                case 4:
                    manager.sortByAverage();
                    manager.printAllStudents();
                    break;

                case 5:
                    System.out.print("검색할 학번: ");
                    String searchId = scanner.nextLine();
                    Student found = manager.findStudentById(searchId);

                    if (found != null) {
                        System.out.println("검색 결과: " + found);
                    } else {
                        System.out.println("학생을 찾을 수 없습니다.");
                    }
                    break;

                case 6:
                    Student[] excellentStudents = manager.findStudentsByMinAverage(90.0);
                    System.out.println("=== 우수학생 (90점 이상) ===");
                    if (excellentStudents.length == 0) {
                        System.out.println("해당하는 학생이 없습니다.");
                    } else {
                        for (Student student : excellentStudents) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 7:
                    manager.printStatistics();
                    break;

                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
