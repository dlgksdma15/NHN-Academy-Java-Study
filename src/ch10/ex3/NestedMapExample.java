package ch10.ex3;

import java.util.*;

public class NestedMapExample {

    public static void main(String[] args) {
        // 학생별, 과목별 점수
        Map<String, Map<String, Integer>> gradeBook = new HashMap<>();

        // 점수 추가 헬퍼 메서드
        addGrade(gradeBook, "김철수", "수학", 85);
        addGrade(gradeBook, "김철수", "영어", 90);
        addGrade(gradeBook, "김철수", "과학", 88);

        addGrade(gradeBook, "이영희", "수학", 92);
        addGrade(gradeBook, "이영희", "영어", 88);
        addGrade(gradeBook, "이영희", "과학", 95);

        addGrade(gradeBook, "박민수", "수학", 78);
        addGrade(gradeBook, "박민수", "영어", 85);
        addGrade(gradeBook, "박민수", "과학", 82);

        // 전체 성적표 출력
        System.out.println("=== 전체 성적표 ===");
        for (Map.Entry<String, Map<String, Integer>> student : gradeBook.entrySet()) {
            System.out.println(student.getKey() + ":");
            for (Map.Entry<String, Integer> subject : student.getValue().entrySet()) {
                System.out.printf("  %s: %d점%n", subject.getKey(), subject.getValue());
            }
            System.out.printf("  평균: %.1f점%n", calculateAverage(student.getValue()));
            System.out.println();
        }

        // 과목별 평균
        System.out.println("=== 과목별 평균 ===");
        Map<String, Double> subjectAverages = calculateSubjectAverages(gradeBook);
        for (Map.Entry<String, Double> entry : subjectAverages.entrySet()) {
            System.out.printf("%s: %.1f점%n", entry.getKey(), entry.getValue());
        }

        // 전체 평균이 가장 높은 학생
        System.out.println("\n=== 최우수 학생 ===");
        String topStudent = findTopStudent(gradeBook);
        System.out.println(topStudent);
    }

    private static void addGrade(Map<String, Map<String, Integer>> gradeBook,
                                 String student, String subject, int score) {
        gradeBook.computeIfAbsent(student, k -> new HashMap<>())
                .put(subject, score);
    }

    private static double calculateAverage(Map<String, Integer> scores) {
        return scores.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    private static Map<String, Double> calculateSubjectAverages(
            Map<String, Map<String, Integer>> gradeBook) {
        Map<String, List<Integer>> subjectScores = new HashMap<>();

        // 과목별로 점수 수집
        for (Map<String, Integer> studentScores : gradeBook.values()) {
            for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
                subjectScores.computeIfAbsent(entry.getKey(), k -> new ArrayList<>())
                        .add(entry.getValue());
            }
        }

        // 평균 계산
        Map<String, Double> averages = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : subjectScores.entrySet()) {
            double avg = entry.getValue().stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
            averages.put(entry.getKey(), avg);
        }

        return averages;
    }

    private static String findTopStudent(Map<String, Map<String, Integer>> gradeBook) {
        String topStudent = null;
        double maxAverage = 0;

        for (Map.Entry<String, Map<String, Integer>> entry : gradeBook.entrySet()) {
            double avg = calculateAverage(entry.getValue());
            if (avg > maxAverage) {
                maxAverage = avg;
                topStudent = entry.getKey();
            }
        }

        return topStudent + " (평균: " + String.format("%.1f", maxAverage) + "점)";
    }
}