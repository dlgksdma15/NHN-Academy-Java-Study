package ch10.ex3;

import java.util.*;

public class HashCollisionDemo {

    // 의도적으로 충돌을 만드는 키 클래스
    static class CollisionKey {
        String value;

        CollisionKey(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CollisionKey)) return false;
            return value.equals(((CollisionKey) obj).value);
        }

        @Override
        public int hashCode() {
            // 의도적으로 간단한 해시 함수 사용
            return value.length() % 3;  // 0, 1, 2만 반환
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public static void main(String[] args) {
        Map<CollisionKey, Integer> map = new HashMap<>();

        String[] words = {"a", "bb", "ccc", "dddd", "eeeee", "ffffff"};

        System.out.println("=== 해시 충돌 데모 ===");
        for (String word : words) {
            CollisionKey key = new CollisionKey(word);
            int hash = key.hashCode();
            map.put(key, word.length());
            System.out.printf("키: %s, 해시코드: %d, 길이: %d%n",
                    word, hash, word.length());
        }

        System.out.println("\n=== 맵 내용 ===");
        for (Map.Entry<CollisionKey, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n=== 조회 테스트 ===");
        for (String word : words) {
            CollisionKey key = new CollisionKey(word);
            Integer value = map.get(key);
            System.out.printf("get(\"%s\") = %d%n", word, value);
        }

        // 해시코드 분포
        System.out.println("\n=== 해시코드 분포 ===");
        Map<Integer, List<String>> distribution = new HashMap<>();
        for (String word : words) {
            CollisionKey key = new CollisionKey(word);
            distribution.computeIfAbsent(key.hashCode(), k -> new ArrayList<>())
                    .add(word);
        }

        for (Map.Entry<Integer, List<String>> entry : distribution.entrySet()) {
            System.out.println("해시코드 " + entry.getKey() + ": " + entry.getValue());
        }
    }
}