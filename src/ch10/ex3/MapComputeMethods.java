package ch10.ex3;

import java.util.*;

public class MapComputeMethods {

    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        String text = "the quick brown fox jumps over the lazy dog " +
                "the fox was very quick";

        // 1. compute - 키가 있든 없든 계산
        System.out.println("=== compute ===");
        for (String word : text.split(" ")) {
            wordCount.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
        }
        System.out.println("단어 빈도: " + wordCount);

        // 2. computeIfAbsent - 키가 없을 때만 계산
        System.out.println("\n=== computeIfAbsent ===");
        Map<String, List<Integer>> indexMap = new HashMap<>();
        String[] words = text.split(" ");

        // TODO 10: 각 단어가 나타나는 인덱스를 리스트로 저장
        for (int i = 0; i < words.length; i++) {
            final int index = i;
            // TODO 구현
            indexMap.computeIfAbsent(words[i], k -> new ArrayList<>()).add(index);
        }
        System.out.println("단어 위치: " + indexMap);

        for (int i = 0; i < words.length; i++) {
            final int index = i;
            // TODO 구현
        }
        System.out.println("단어 위치: " + indexMap);

        // 3. computeIfPresent - 키가 있을 때만 계산
        System.out.println("\n=== computeIfPresent ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("김철수", 80);
        scores.put("이영희", 90);
        scores.put("박민수", 85);

        // 보너스 점수 추가 (10%)
        scores.computeIfPresent("김철수", (k, v) -> (int)(v * 1.1));
        scores.computeIfPresent("정지원", (k, v) -> (int)(v * 1.1)); // 없으므로 무시
        System.out.println("보너스 후: " + scores);

        // 4. merge - 값 병합
        System.out.println("\n=== merge ===");
        Map<String, Integer> inventory1 = new HashMap<>();
        inventory1.put("사과", 30);
        inventory1.put("바나나", 20);

        Map<String, Integer> inventory2 = new HashMap<>();
        inventory2.put("사과", 25);
        inventory2.put("오렌지", 15);

        // 두 재고 합치기
        for (Map.Entry<String, Integer> entry : inventory2.entrySet()) {
            inventory1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        System.out.println("합친 재고: " + inventory1);
    }
}