package ch10.ex3;

import java.util.*;

public class SubMapExample {

    public static void main(String[] args) {
        TreeMap<String, String> dictionary = new TreeMap<>();

        // 사전 데이터 추가
        dictionary.put("apple", "사과");
        dictionary.put("banana", "바나나");
        dictionary.put("cherry", "체리");
        dictionary.put("date", "대추");
        dictionary.put("elderberry", "엘더베리");
        dictionary.put("fig", "무화과");
        dictionary.put("grape", "포도");
        dictionary.put("honeydew", "허니듀");

        System.out.println("전체 사전: " + dictionary);

        // 1. subMap - 범위 지정
        System.out.println("\n=== subMap ===");
        SortedMap<String, String> cToE = dictionary.subMap("c", "f");
        System.out.println("'c'부터 'f'이전: " + cToE);

        // 2. headMap - 특정 키 이전
        System.out.println("\n=== headMap ===");
        SortedMap<String, String> beforeD = dictionary.headMap("d");
        System.out.println("'d' 이전: " + beforeD);

        // 3. tailMap - 특정 키 이후
        System.out.println("\n=== tailMap ===");
        SortedMap<String, String> fromF = dictionary.tailMap("f");
        System.out.println("'f' 이후: " + fromF);

        // 서브맵 수정은 원본에 영향
        System.out.println("\n=== 서브맵 수정 ===");
        cToE.put("dragon", "용");
        System.out.println("서브맵에 추가: " + cToE);
        System.out.println("원본도 변경됨: " + dictionary);
    }
}