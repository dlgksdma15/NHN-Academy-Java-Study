package ch10.ex3;

import java.util.*;

public class HashMapVsTreeMap {

    public static void main(String[] args) {
        // 같은 데이터를 두 맵에 추가
        String[] fruits = {"banana", "apple", "cherry", "date", "elderberry"};
        int[] prices = {1500, 2000, 3000, 2500, 4000};

        // HashMap - 순서 보장 없음
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            hashMap.put(fruits[i], prices[i]);
        }

        // TreeMap - 키로 정렬
        Map<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < fruits.length; i++) {
            treeMap.put(fruits[i], prices[i]);
        }

        // LinkedHashMap - 삽입 순서 유지
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            linkedHashMap.put(fruits[i], prices[i]);
        }

        System.out.println("=== HashMap (순서 없음) ===");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n=== TreeMap (키로 정렬) ===");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n=== LinkedHashMap (삽입 순서) ===");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}