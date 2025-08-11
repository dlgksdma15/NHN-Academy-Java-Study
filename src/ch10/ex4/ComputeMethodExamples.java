package ch10.ex4;

import java.util.*;

public class ComputeMethodExamples {

    public static void main(String[] args) {
        // 1. compute - 값 계산 및 수정
        System.out.println("=== compute ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kim", 80);
        scores.put("Lee", 90);

        // 10점 보너스
        scores.compute("Kim", (k, v) -> (v == null) ? 10 : v + 10);
        scores.compute("Park", (k, v) -> (v == null) ? 10 : v + 10);
        System.out.println(scores);

        // 2. computeIfAbsent - 없을 때만 계산
        System.out.println("\n=== computeIfAbsent ===");
        Map<String, List<String>> groups = new HashMap<>();

        // 그룹에 멤버 추가
        groups.computeIfAbsent("TeamA", k -> new ArrayList<>()).add("Kim");
        groups.computeIfAbsent("TeamA", k -> new ArrayList<>()).add("Lee");
        groups.computeIfAbsent("TeamB", k -> new ArrayList<>()).add("Park");
        System.out.println(groups);

        // 3. computeIfPresent - 있을 때만 계산
        System.out.println("\n=== computeIfPresent ===");
        Map<String, Double> prices = new HashMap<>();
        prices.put("Apple", 1000.0);
        prices.put("Banana", 500.0);

        // 10% 할인 (있는 항목만)
        prices.computeIfPresent("Apple", (k, v) -> v * 0.9);
        prices.computeIfPresent("Orange", (k, v) -> v * 0.9);  // 효과 없음
        System.out.println(prices);

        // 4. merge - 병합
        System.out.println("\n=== merge ===");
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apple", 10);

        // 재고 추가
        inventory.merge("Apple", 5, Integer::sum);    // 10 + 5
        inventory.merge("Banana", 3, Integer::sum);  // 0 + 3
        System.out.println(inventory);

        // 5. 실전 예제: 단어 그룹화
        System.out.println("\n=== 단어 그룹화 ===");
        String[] words = {"apple", "apricot", "banana", "berry", "cherry"};
        Map<Character, List<String>> wordsByFirstChar = new HashMap<>();

        for (String word : words) {
            char firstChar = word.charAt(0);
            wordsByFirstChar.computeIfAbsent(firstChar, k -> new ArrayList<>())
                    .add(word);
        }
        System.out.println(wordsByFirstChar);

        // 6. 복잡한 예제: 성적 통계
        System.out.println("\n=== 성적 통계 ===");
        Map<String, List<Integer>> studentScores = new HashMap<>();

        // 점수 추가
        addScore(studentScores, "Kim", 85);
        addScore(studentScores, "Kim", 90);
        addScore(studentScores, "Kim", 88);
        addScore(studentScores, "Lee", 92);
        addScore(studentScores, "Lee", 88);

        // 평균 계산
        Map<String, Double> averages = new HashMap<>();
        studentScores.forEach((name, scores2) -> {
            double avg = scores2.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
            averages.put(name, avg);
        });

        System.out.println("점수들: " + studentScores);
        System.out.println("평균: " + averages);
    }

    private static void addScore(Map<String, List<Integer>> map,
                                 String name, int score) {
        map.computeIfAbsent(name, k -> new ArrayList<>()).add(score);
    }
}