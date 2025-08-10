package ch10.ex3;

import java.util.*;

public class MapNullHandling {

    public static void main(String[] args) {
        // HashMap은 null 키와 값을 허용
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "null 키의 값");
        hashMap.put("키1", null);
        hashMap.put("키2", "정상 값");

        System.out.println("HashMap:");
        System.out.println("null 키: " + hashMap.get(null));
        System.out.println("키1: " + hashMap.get("키1"));
        System.out.println("전체: " + hashMap);

        // TreeMap은 null 키를 허용하지 않음
        Map<String, String> treeMap = new TreeMap<>();
        // treeMap.put(null, "값");  // NullPointerException!
        treeMap.put("키1", null);  // null 값은 가능
        treeMap.put("키2", "정상 값");

        System.out.println("\nTreeMap:");
        System.out.println("키1: " + treeMap.get("키1"));
        System.out.println("전체: " + treeMap);
    }
}