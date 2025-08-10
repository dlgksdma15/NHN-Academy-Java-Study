package ch10.ex3;

import java.util.*;

public class MapViewFiltering {

    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("김철수", 85);
        studentScores.put("이영희", 92);
        studentScores.put("박민수", 78);
        studentScores.put("정지원", 95);
        studentScores.put("홍길동", 88);
        studentScores.put("강민준", 73);
        studentScores.put("최서연", 91);

        // 90점 이상 학생 찾기
        System.out.println("=== 90점 이상 학생 ===");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if (entry.getValue() >= 90) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        // 특정 점수 구간 학생 찾기
        System.out.println("\n=== 80-89점 학생 ===");
        List<String> midRangeStudents = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            int score = entry.getValue();
            if (score >= 80 && score < 90) {
                midRangeStudents.add(entry.getKey());
            }
        }
        System.out.println(midRangeStudents);

        // 평균 계산
        // TODO 1: values()를 사용하여 모든 점수의 합계 구하기
        int total = 0;
        for(Integer value : studentScores.values()){
            total += value;
        }

        // TODO 2: 평균 계산 (합계 / 학생 수)
        double average = total / studentScores.size();

        System.out.printf("\n평균 점수: %.1f점%n", average);

        // 평균 이상 학생
        System.out.println("\n=== 평균 이상 학생 ===");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if (entry.getValue() >= average) {
                System.out.printf("%s: %d점 (평균 +%.1f)%n",
                        entry.getKey(),
                        entry.getValue(),
                        entry.getValue() - average);
            }
        }
    }
}