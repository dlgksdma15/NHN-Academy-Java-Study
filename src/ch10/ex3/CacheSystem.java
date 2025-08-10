package ch10.ex3;

import java.util.*;

public class CacheSystem<K, V> {

    private final int maxSize;
    private final Map<K, V> cache;
    private final Map<K, Long> accessTime;
    private final Map<K, Integer> accessCount;

    public CacheSystem(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new HashMap<>();
        this.accessTime = new HashMap<>();
        this.accessCount = new HashMap<>();
    }

    // 값 추가/조회
    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            // 접근 정보 업데이트
            accessTime.put(key, System.currentTimeMillis());
            accessCount.put(key, accessCount.getOrDefault(key, 0) + 1);
        }
        return value;
    }

    // 값 추가
    public void put(K key, V value) {
        // 캐시가 가득 차면 제거 정책 실행
        if (cache.size() >= maxSize && !cache.containsKey(key)) {
            evict();
        }

        cache.put(key, value);
        accessTime.put(key, System.currentTimeMillis());
        accessCount.put(key, accessCount.getOrDefault(key, 0) + 1);
    }

    // LRU (Least Recently Used) 제거
    private void evict() {
        K lruKey = null;
        long oldestTime = Long.MAX_VALUE;

        for (Map.Entry<K, Long> entry : accessTime.entrySet()) {
            if (entry.getValue() < oldestTime) {
                oldestTime = entry.getValue();
                lruKey = entry.getKey();
            }
        }

        if (lruKey != null) {
            cache.remove(lruKey);
            accessTime.remove(lruKey);
            accessCount.remove(lruKey);
            System.out.println("제거됨 (LRU): " + lruKey);
        }
    }

    // 캐시 통계
    public void printStatistics() {
        System.out.println("=== 캐시 통계 ===");
        System.out.println("크기: " + cache.size() + "/" + maxSize);

        // 가장 많이 접근된 항목
        if (!accessCount.isEmpty()) {
            Map.Entry<K, Integer> mostAccessed = Collections.max(
                    accessCount.entrySet(),
                    Map.Entry.comparingByValue()
            );
            System.out.println("가장 많이 접근: " + mostAccessed.getKey() +
                    " (" + mostAccessed.getValue() + "회)");
        }

        // 캐시 내용
        System.out.println("\n현재 캐시:");
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.printf("  %s -> %s (접근: %d회)%n",
                    entry.getKey(),
                    entry.getValue(),
                    accessCount.get(entry.getKey()));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CacheSystem<String, String> cache = new CacheSystem<>(3);

        // 데이터 추가
        cache.put("user1", "Alice");
        Thread.sleep(100);
        cache.put("user2", "Bob");
        Thread.sleep(100);
        cache.put("user3", "Charlie");

        // 접근
        cache.get("user1");
        cache.get("user1");
        cache.get("user2");

        cache.printStatistics();

        // 캐시 초과
        System.out.println("\n새 사용자 추가:");
        cache.put("user4", "David");  // user3가 제거될 것

        cache.printStatistics();
    }
}