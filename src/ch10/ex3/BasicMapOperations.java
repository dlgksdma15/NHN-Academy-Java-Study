package ch10.ex3;

import java.util.*;

public class BasicMapOperations {

    public static void main(String[] args) {
        // HashMap 생성
        Map<String, Integer> inventory = new HashMap<>();

        // 1. put - 항목 추가
        System.out.println("=== 재고 추가 ===");
        inventory.put("사과", 50);
        inventory.put("바나나", 30);
        inventory.put("오렌지", 40);
        inventory.put("포도", 25);
        System.out.println("초기 재고: " + inventory);

        // 2. get - 값 조회
        System.out.println("\n=== 재고 조회 ===");
        Integer appleCount = inventory.get("사과");
        System.out.println("사과 재고: " + appleCount);

        // 존재하지 않는 키
        Integer mangoCount = inventory.get("망고");
        System.out.println("망고 재고: " + mangoCount);  // null

        // 3. getOrDefault - 기본값과 함께 조회
        int kiwiCount = inventory.getOrDefault("키위", 0);
        System.out.println("키위 재고: " + kiwiCount);  // 0

        // 4. put - 값 수정
        System.out.println("\n=== 재고 수정 ===");
        Integer oldValue = inventory.put("사과", 60);
        System.out.println("이전 사과 재고: " + oldValue);
        System.out.println("현재 사과 재고: " + inventory.get("사과"));

        // 5. putIfAbsent - 없을 때만 추가
        inventory.putIfAbsent("사과", 100);  // 이미 있으므로 무시됨
        inventory.putIfAbsent("망고", 20);   // 추가됨
        System.out.println("putIfAbsent 후: " + inventory);

        // 6. remove - 제거
        System.out.println("\n=== 항목 제거 ===");
        Integer removed = inventory.remove("포도");
        System.out.println("제거된 포도 재고: " + removed);
        System.out.println("제거 후: " + inventory);

        // 7. containsKey, containsValue
        System.out.println("\n=== 존재 확인 ===");
        System.out.println("'바나나' 키 존재? " + inventory.containsKey("바나나"));
        System.out.println("재고 30개 존재? " + inventory.containsValue(30));

        // 8. size, isEmpty
        System.out.println("\n=== 크기 정보 ===");
        System.out.println("전체 품목 수: " + inventory.size());
        System.out.println("비어있나? " + inventory.isEmpty());

        // 9. clear
        inventory.clear();
        System.out.println("\n모두 제거 후: " + inventory);
        System.out.println("비어있나? " + inventory.isEmpty());
    }
}